package com.leavemanagement.system.service.employee;

import com.leavemanagement.system.service.database.DatabaseServices;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImpTest {
    private DatabaseServices databaseServices = new DatabaseServices();
    private EmployeeServiceImp employeeServiceImp=new EmployeeServiceImp();

    @Test
    void getMonthWiseHolidayList() {
        assertEquals(databaseServices.getMonthWiseHolidayList("April"),employeeServiceImp.getMonthWiseHolidayList("April"));

    }

    @Test
    void getYearWiseHolidayList() {
        assertEquals(databaseServices.getYearWiseHolidayList(),employeeServiceImp.getYearWiseHolidayList());
    }
}