package org.kainos.ea.core;

import org.kainos.ea.cli.DeliveryEmployeeRequest;
import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.client.GenericValidationException;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;

public class DeliveryEmployeeValidator extends EmployeeValidator{

//    public DeliveryEmployeeValidator(String firstName, String lastName, double salary, String bankAccountNumber, String nationalInsuranceNumber) {
//        super(firstName, lastName, salary, bankAccountNumber, nationalInsuranceNumber);
//    }

    public void isValidDeliveryEmployee(DeliveryEmployeeRequest deliveryEmployee) throws GenericValidationException {

        super.isValidEmployee(deliveryEmployee);

    }

}
