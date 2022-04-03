package com.people.flow.demo.service.generator;

import com.people.flow.demo.constant.EmployeeStateEnum;
import com.people.flow.demo.model.Employee;
import com.people.flow.demo.dto.EmployeeDTO;

public class GenerateStubs {

    public static final String EMPLOYEE_ID = "659e0e00-1319-4897-a400-fb040d048171";

    public static EmployeeDTO generateEmployeeDTO() {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Employee1");
        employeeDTO.setAge(30);
        employeeDTO.setState(EmployeeStateEnum.ADDED);
        return employeeDTO;
    }

    public static Employee generateEmployee() {

        Employee employee = new Employee();
        employee.setId(EMPLOYEE_ID);
        employee.setName("Employee1");
        employee.setAge(30);
        return employee;
    }
}
