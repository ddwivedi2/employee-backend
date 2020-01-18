
package com.example.crud.employee.repos;

import com.example.crud.employee.entities.Employee;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeePageRepository extends PagingAndSortingRepository<Employee, Integer> {

}