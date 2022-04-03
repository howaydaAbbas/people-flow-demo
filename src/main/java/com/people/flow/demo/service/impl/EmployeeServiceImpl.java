package com.people.flow.demo.service.impl;

import com.people.flow.demo.constant.EmployeeStateEnum;
import com.people.flow.demo.exception.EmployeeNotFoundException;
import com.people.flow.demo.model.Employee;
import com.people.flow.demo.repo.EmployeeRepository;
import com.people.flow.demo.service.EmployeeService;
import com.people.flow.demo.dto.EmployeeDTO;
import com.people.flow.demo.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        log.info("Start addEmployee with name {}", employeeDTO.getName());
        Employee employee = Mappers.getMapper(EmployeeMapper.class).toEntity(employeeDTO);
        employee = employeeRepository.save(employee);
        return Mappers.getMapper(EmployeeMapper.class).toDto(employee);
    }

    @Override
    public void changeEmployeeState(String id, EmployeeStateEnum employeeState) throws EmployeeNotFoundException {
        log.info("Start changeEmployeeState with id {} and state {}", id, employeeState.name());
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new EmployeeNotFoundException("No employee found with id " + id);
        }
        employeeRepository.updateEmployeeState(id, employeeState);
    }
}
