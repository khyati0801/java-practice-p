package com.onerivet.deskbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onerivet.deskbook.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
