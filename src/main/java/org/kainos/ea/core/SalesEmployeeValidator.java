package org.kainos.ea.core;

import org.kainos.ea.cli.DeliveryEmployeeRequest;
import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.client.GenericValidationException;

public class SalesEmployeeValidator extends EmployeeValidator{

//    public SalesEmployeeValidator(String firstName, String lastName, double salary, String bankAccountNumber, String nationalInsuranceNumber) {
//        super(firstName, lastName, salary, bankAccountNumber, nationalInsuranceNumber);
//    }

    public void isValidSalesEmployee(SalesEmployeeRequest salesEmployee) throws GenericValidationException {

        super.isValidEmployee(salesEmployee);

        if (salesEmployee.getCommissionRate() < 0) {
            throw new GenericValidationException("Commission rate is less than zero");
        }
        
    }
}
