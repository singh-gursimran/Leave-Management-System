package com.leavemanagement.system.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Employee{
    private String name;
    private String email;
    private LocalDate dateOfJoining;
    private int id;

    public Employee(EmployeeBuilder employeeBuilder) {
        this.name=employeeBuilder.getName();
        this.email=employeeBuilder.getEmail();
        this.dateOfJoining=employeeBuilder.getDateOfJoining();
        this.id=employeeBuilder.getId();
    }

}
