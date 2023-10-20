package org.kainos.ea.core;

import org.kainos.ea.cli.DeliveryEmployeeRequest;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.GenericValidationException;

public class EmployeeValidator {

//    public EmployeeValidator(String firstName, String lastName, double salary, String bankAccountNumber, String nationalInsuranceNumber) {
//    }

    public void isValidEmployee(EmployeeRequest Employee) throws GenericValidationException {
        if (Employee.getFirstName().length() > 70) {
            throw new GenericValidationException("First name must be less than 70 characters");
        }

        if (Employee.getLastName().length() > 70) {
            throw new GenericValidationException("Last name must be less than 70 characters");
        }

        if (Employee.getSalary() < 0) {
            throw new GenericValidationException("Salary must be more than 0");
        }

        if (Employee.getSalary() > 9999999.99) {
            throw new GenericValidationException("Salary must not be more than 9 999 999.99");
        }

        if (Employee.getBankAccountNumber().length() > 8) {
            throw new GenericValidationException("Bank account number must be less than 8 characters");
        }

        if (Employee.getNationalInsuranceNumber().length() > 9) {
            throw new GenericValidationException("National insurance number must be less than 9 characters");
        }
    }
}
