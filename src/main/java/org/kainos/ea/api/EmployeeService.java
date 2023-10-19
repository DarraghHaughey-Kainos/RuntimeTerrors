package org.kainos.ea.api;

import org.kainos.ea.cli.DeliveryEmployeeRequest;
import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.GenericActionFailedException;
import org.kainos.ea.client.InvalidEmployeeException;
import org.kainos.ea.client.EmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToUpdateEmployeeException;
import org.kainos.ea.client.GenericValidationException;
import org.kainos.ea.core.DeliveryEmployeeValidator;
import org.kainos.ea.client.GenericDoesNotExistException;
import org.kainos.ea.db.EmployeeDao;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private final EmployeeDao employeeDao = new EmployeeDao();
    private final DeliveryEmployeeValidator deliveryEmployeeValidator = new DeliveryEmployeeValidator();

    public List<Employee> getAllEmployees() throws GenericActionFailedException {

        try {
            return employeeDao.getAllEmployees();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new GenericActionFailedException("get books");
        }
    }

    public int createDeliveryEmployee(DeliveryEmployeeRequest deliveryEmployee) throws GenericActionFailedException, GenericValidationException {
        try {
            deliveryEmployeeValidator.isValidDeliveryEmployee(deliveryEmployee);

            int id = employeeDao.createDeliveryEmployee(deliveryEmployee);

            if (id == -1) {
                throw new GenericActionFailedException("create delivery employee");
            }

            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new GenericActionFailedException("create delivery employee");
        }
    }

    public DeliveryEmployee getDeliveryEmployeeById(int id) throws GenericActionFailedException, GenericDoesNotExistException {

        try {
            DeliveryEmployee deliveryEmployee = employeeDao.getDeliveryEmployeeById(id);

            if (deliveryEmployee==null){
                throw new GenericDoesNotExistException("Delivery Employee does not exist");
            }

            return deliveryEmployee;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new GenericActionFailedException("Get Delivery Employee By ID");
        }
    }


    public List<DeliveryEmployee> getAllDeliveryEmployees() throws  GenericActionFailedException {

        try{

            return employeeDao.getAllDeliveryEmployees();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
           throw new GenericActionFailedException("get all delivery employees");

            }
        }

    public void deleteDeliveryEmployee(int id) throws GenericDoesNotExistException, GenericActionFailedException{
        try{
            DeliveryEmployee deliveryEmployeeToDelete = employeeDao.getDeliveryEmployeeById(id);

            if (deliveryEmployeeToDelete == null) {
                throw new GenericDoesNotExistException("delivery employee does not exist");
            }

            employeeDao.deleteDeliveryEmployee(id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new GenericActionFailedException("failed to delete delivery employee");
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
