package com.people.flow.demo.exception;

public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException(String errorMsg) {
        super(errorMsg);
    }
}
