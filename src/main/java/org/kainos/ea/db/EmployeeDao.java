package org.kainos.ea.db;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public List<Employee> getAllEmployees() throws SQLException {
        Connection c = DatabaseConnector.getConnection();
        assert c != null;

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT employee_id, first_name, last_name, salary, bank_account_number, national_insurance_number FROM employee;");

        List<Employee> employeeList = new ArrayList<>();

        while (rs.next()) {
            Employee employee = new Employee(
                    rs.getInt("employee_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDouble("salary"),
                    rs.getString("bank_account_number"),
                    rs.getString("national_insurance_number")
            );

            employeeList.add(employee);
        }

        return employeeList;
    }

    public void updateEmployee(int id, EmployeeRequest employee) throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        String updateStatement = "UPDATE employee SET first_name = ?, last_name = ?, salary = ?, bank_account_number = ?, national_insurance_number = ? WHERE employee_id = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, employee.getFirstName());
        st.setString(2, employee.getLast_name());
        st.setDouble(3, employee.getSalary());
        st.setString(4,employee.getBank_account_number());
        st.setString(5,employee.getNational_insurance_number());
        st.setInt(6,id);

        st.executeUpdate();

    }

    public Employee getEmployeeById(int id) throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT employee_id, first_name, last_name, salary, bank_account_number, national_insurance_number" +
                " FROM `employee` WHERE employee_id=" + id);

        while (rs.next()) {
            return new Employee(
                    rs.getInt("employee_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDouble("salary"),
                    rs.getString("bank_account_number"),
                    rs.getString("national_insurance_number")
            );

        }

        return null;
    }
}
