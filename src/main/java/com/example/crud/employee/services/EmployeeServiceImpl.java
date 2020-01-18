package com.example.crud.employee.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.crud.employee.entities.Employee;
import com.example.crud.employee.repos.EmployeePageRepository;
import com.example.crud.employee.repos.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRespository;

    @Autowired
    private EmployeePageRepository employeePageRepository;

    public Employee addEmplopyee(Employee emp) {

        // Add business logic
        employeeRespository.save(emp);
        return emp;
    }

    @Override
    public Employee updateEmployee(Integer empID, Employee emp) {
        Employee oldEmployee = employeeRespository.findById(empID).orElse(null);
        if (oldEmployee != null) {
            BeanUtils.copyProperties(emp, oldEmployee);
            oldEmployee.setId(empID);
            employeeRespository.save(oldEmployee);
        }
        return oldEmployee;
    }

    @Override
    public Iterable<Employee> getEmployees(int page, int count) {
        Pageable pageable = PageRequest.of(page, count);
        Page<Employee> pageEmployee = employeePageRepository.findAll(pageable);
        return pageEmployee.getContent();
    }

    @Override
    public List<String> getSkills() {
        List<String> skills = new ArrayList<String>();
        skills.add("Skill1");
        skills.add("Skill2");
        skills.add("Skill3");
        skills.add("Skill4");
        return skills;
    }
}