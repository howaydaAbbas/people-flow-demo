package com.people.flow.demo.controller;

import com.people.flow.demo.constant.EmployeeStateEnum;
import com.people.flow.demo.exception.EmployeeNotFoundException;
import com.people.flow.demo.service.EmployeeService;
import com.people.flow.demo.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        EmployeeDTO response = employeeService.addEmployee(employeeDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{id}/{state}")
    public ResponseEntity changeEmployeeState(@PathVariable("id") String id, @PathVariable("state") EmployeeStateEnum state) {
        try {
            employeeService.changeEmployeeState(id, state);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
