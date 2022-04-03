package com.people.flow.demo.service.impl;

import com.people.flow.demo.constant.EmployeeStateEnum;
import com.people.flow.demo.exception.EmployeeNotFoundException;
import com.people.flow.demo.model.Employee;
import com.people.flow.demo.repo.EmployeeRepository;
import com.people.flow.demo.dto.EmployeeDTO;
import com.people.flow.demo.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.people.flow.demo.service.generator.GenerateStubs.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Test
    public void givenEmployeeToAddShouldReturnAddedEmployee() {

        when(employeeRepository.save(Mappers.getMapper(EmployeeMapper.class).toEntity(generateEmployeeDTO()))).thenReturn(generateEmployee());
        EmployeeDTO result = employeeService.addEmployee(generateEmployeeDTO());
        Employee employee = Mappers.getMapper(EmployeeMapper.class).toEntity(result);
        assertEquals(generateEmployee(), employee);
        verify(employeeRepository, times(1)).save(Mappers.getMapper(EmployeeMapper.class).toEntity(generateEmployeeDTO()));
    }

    @Test
    public void changeEmployeeStateSuccess() throws EmployeeNotFoundException {

        when(employeeRepository.findById(EMPLOYEE_ID)).thenReturn(Optional.of(generateEmployee()));
        employeeService.changeEmployeeState(EMPLOYEE_ID, EmployeeStateEnum.ACTIVE);
        verify(employeeRepository, times(1)).findById(EMPLOYEE_ID);
    }
}
