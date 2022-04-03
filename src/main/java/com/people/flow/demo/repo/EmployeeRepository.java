package com.people.flow.demo.repo;

import com.people.flow.demo.constant.EmployeeStateEnum;
import com.people.flow.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Transactional
    @Modifying
    @Query("update Employee emp set emp.state = :state WHERE emp.id = :id")
    void updateEmployeeState(@Param("id") String id, @Param("state") EmployeeStateEnum state);
}
