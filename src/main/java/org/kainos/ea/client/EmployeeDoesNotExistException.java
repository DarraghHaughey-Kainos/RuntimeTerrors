package org.kainos.ea.client;

public class EmployeeDoesNotExistException extends Throwable{
    @Override
    public String getMessage() {
        return "The employee does not exist in the database";
    }
}
