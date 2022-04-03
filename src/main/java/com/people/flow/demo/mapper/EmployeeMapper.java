package com.people.flow.demo.mapper;

import com.people.flow.demo.model.Employee;
import com.people.flow.demo.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface EmployeeMapper extends EntityMapper<EmployeeDTO, Employee> {
}
