package com.william.mockito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.william.mockito.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
