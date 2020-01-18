package com.example.crud.employee.controllers.dto;
import java.io.Serializable;

public class EmployeeDTO implements Serializable {
    private static final long serialVersionUID = 4865903039190150223L;
    private String name;
    private String dob;

    private int salary;
  
    private String imageurl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

}