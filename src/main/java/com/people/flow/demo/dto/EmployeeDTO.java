package com.people.flow.demo.dto;

import com.people.flow.demo.constant.EmployeeStateEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EmployeeDTO {

    private String id;

    @NotBlank
    private String name;

    private String contractInfo;

    @NotNull
    private int age;

    private EmployeeStateEnum state;
}
