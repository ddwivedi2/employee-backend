package com.example.crud.employee.controllers;

import java.util.List;

import com.example.crud.employee.controllers.dto.EmployeeDTO;
import com.example.crud.employee.entities.Employee;
import com.example.crud.employee.services.EmployeeService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/emp")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping(path="/")
  public @ResponseBody Iterable<Employee> getEmployees(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int count) {
    return employeeService.getEmployees(page, count);
  }

  @PostMapping(path="/")
  public @ResponseBody Employee addNewEmp (@RequestBody EmployeeDTO empDTO) {

    Employee emp = new Employee();
    BeanUtils.copyProperties(empDTO, emp);
    employeeService.addEmplopyee(emp);
    return emp;
  }

  @PatchMapping(path="/{employeeId}")
  public @ResponseBody Employee updateEmployee (@PathVariable(value="employeeId") Integer empID, @RequestBody EmployeeDTO empDTO) throws Exception {

    Employee emp = new Employee();
    BeanUtils.copyProperties(empDTO, emp);
    emp = employeeService.updateEmployee(empID, emp);
    if(emp == null){
        throw new Exception("Employee ID Not found");
    }
    return emp;
  }

  @GetMapping(path="/skills")
  public @ResponseBody List<String> getSkills() {
    return employeeService.getSkills();
  }
}