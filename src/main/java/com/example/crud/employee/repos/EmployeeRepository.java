package com.example.crud.employee.repos;

import com.example.crud.employee.entities.Employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}