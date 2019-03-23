package com.leavemanagement.system.model;

import com.leavemanagement.system.utilties.UserValidate;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class EmployeeBuilder {
    private String name;
    private String email;
    private LocalDate dateOfJoining;
    private int id;



    public static EmployeeBuilder builder(){
        return new EmployeeBuilder();

    }

    public Employee build(){
        UserValidate validate=new UserValidate();
        validate.validateEmail(email);
        validate.validateName(name);
        dateOfJoining();
        id();
        return new Employee(this);
    }


    public EmployeeBuilder email(String email) {
        this.email=email;
        return this;

    }

    private void dateOfJoining(){
        this.dateOfJoining=LocalDate.now();
    }

    private void id(){
        this.id=name.hashCode()+email.hashCode();
    }

    public EmployeeBuilder name(String name){
        this.name=name;
        return this;
    }

}
