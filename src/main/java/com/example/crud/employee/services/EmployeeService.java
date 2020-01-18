package com.example.crud.employee.services;

import java.util.List;

import com.example.crud.employee.entities.Employee;

public interface EmployeeService {
    public Employee addEmplopyee(Employee emp);
    public Employee updateEmployee(Integer empID, Employee emp);
    public Iterable<Employee> getEmployees(int page, int count);
    public List<String> getSkills();
}