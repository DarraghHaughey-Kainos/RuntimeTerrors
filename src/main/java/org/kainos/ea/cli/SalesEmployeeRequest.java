package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmployeeRequest extends EmployeeRequest{

    private double commissionRate;

    public SalesEmployeeRequest(String firstName, String lastName, double salary, String bankAccountNumber, String nationalInsuranceNumber, double commissionRate) {
        super(firstName, lastName, salary, bankAccountNumber, nationalInsuranceNumber);
        this.commissionRate = commissionRate;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    @JsonCreator
    public SalesEmployeeRequest(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("salary") double salary,
            @JsonProperty("bankAccountNumber") String bankAccountNumber,
            @JsonProperty("nationalInsuranceNumber") String nationalInsuranceNumber,
            @JsonProperty("commissionRate") double commissionRate) {


    }
}
