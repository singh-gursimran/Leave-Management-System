package com.leavemanagement.system.service.admin;

import com.leavemanagement.system.exception.LeaveManagementException;
import com.leavemanagement.system.model.Database;
import com.leavemanagement.system.model.Employee;
import com.leavemanagement.system.model.EmployeeBuilder;
import com.leavemanagement.system.service.database.DatabaseServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AdminServicesImpTest {
    private Employee john;
    private DatabaseServices databaseServices;
    private AdminServicesImp admin;
    private Employee mary;
    private Database database;

    @BeforeEach
    public void init() throws LeaveManagementException {
        databaseServices=new DatabaseServices();
        john= EmployeeBuilder.builder().name("John Cena").email("johncena@youcantseeme.com").build();
        mary=EmployeeBuilder.builder().name("Mary").email("mary@google.com").build();
        databaseServices.addAdmin(john);
        admin=new AdminServicesImp(john);
        database=Database.getInstance();
    }

    @Test
    void addEmployee() {
        admin.addEmployee(mary);
        assertEquals(true,database.getEmployeeList().contains(mary));
    }

    @Test
    void removeEmployee() {
        admin.removeEmployee(mary);
        assertEquals(false,database.getEmployeeList().contains(mary));
    }

    @Test
    void addHoliday() {
        admin.addHoliday(LocalDate.now());
        assertTrue(database.getHolidayList().get(LocalDate.now().getMonth()).contains(LocalDate.now()));
    }
}