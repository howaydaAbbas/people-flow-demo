package com.people.flow.demo.service;

import com.people.flow.demo.constant.EmployeeStateEnum;
import com.people.flow.demo.exception.EmployeeNotFoundException;
import com.people.flow.demo.dto.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);

    void changeEmployeeState(String id, EmployeeStateEnum employeeState) throws EmployeeNotFoundException;
}
