package com.leavemanagement.system.service.database;

import com.leavemanagement.system.model.Database;
import com.leavemanagement.system.model.Employee;
import com.leavemanagement.system.model.EmployeeBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseServicesTest {
    DatabaseServices databaseServices;
    Database database;
    Employee john;

    @BeforeEach
    public void init(){
        databaseServices=new DatabaseServices();
        database=Database.getInstance();
        john= EmployeeBuilder.builder().name("John Cena").email("johncena@youcantseeme.com").build();
    }
    @Test
    public void addEmployee() {

        databaseServices.addEmployee(john);
        assertEquals(true,database.getEmployeeList().contains(john));
    }

    @Test
    public void removeEmployee() {
        databaseServices.removeEmployee(john);
        assertEquals(false,database.getEmployeeList().contains(john));
    }

    @Test
    public void addHoliday() {
        databaseServices.addHoliday(LocalDate.now());
        assertEquals(true,database.getHolidayList().get(LocalDate.now().getMonth()).contains(LocalDate.now()));
    }
}