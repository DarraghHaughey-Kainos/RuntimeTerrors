package org.kainos.ea.api;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.GenericActionFailedException;
import org.kainos.ea.client.InvalidEmployeeException;
import org.kainos.ea.client.EmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToUpdateEmployeeException;
import org.kainos.ea.db.EmployeeDao;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private final EmployeeDao employeeDao = new EmployeeDao();

//    private EmployeeValidator employeeValidator = new EmployeeValidator();

    public List<Employee> getAllEmployees() throws GenericActionFailedException {

        try {
//            List<Book> bookList = bookDao.getAllBooks();
//            return bookList;
            return employeeDao.getAllEmployees();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new GenericActionFailedException("books");
        }
    }

    public void updateEmployee (int id, EmployeeRequest employee) throws InvalidEmployeeException, EmployeeDoesNotExistException, FailedToUpdateEmployeeException {
        try {
//            String validation = employeeValidator.isValidEmployee(employee);
//
//            if (validation != null) {
//                throw new InvalidEmployeeException(validation);
//            }

            Employee employeeToUpdate = employeeDao.getEmployeeById(id);

            if (employeeToUpdate == null) {
                throw new EmployeeDoesNotExistException();
            }

            employeeDao.updateEmployee(id, employee);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateEmployeeException();
        }
    }
}
