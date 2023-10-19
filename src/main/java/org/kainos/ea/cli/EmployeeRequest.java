package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {
    private String first_name;
    private String last_name;
    private Double salary;
    private String bank_account_number;
    private String national_insurance_number;

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getBankAccountNumber() {
        return bank_account_number;
    }

    public void setBankAccountNumber(String bank_account_number) {
        this.bank_account_number = bank_account_number;
    }

    public String getNationalInsuranceNumber() {
        return national_insurance_number;
    }

    public void setNationalInsuranceNumber(String national_insurance_number) {
        this.national_insurance_number = national_insurance_number;
    }

}
