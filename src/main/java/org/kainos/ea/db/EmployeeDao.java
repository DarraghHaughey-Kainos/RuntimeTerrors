package org.kainos.ea.db;

import org.kainos.ea.cli.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}