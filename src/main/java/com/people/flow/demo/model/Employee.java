package com.people.flow.demo.model;

import com.people.flow.demo.constant.EmployeeStateEnum;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;

    private String contractInfo;

    private int age;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EmployeeStateEnum state = EmployeeStateEnum.ADDED;
}