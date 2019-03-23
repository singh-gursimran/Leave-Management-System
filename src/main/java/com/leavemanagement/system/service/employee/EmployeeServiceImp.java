package com.leavemanagement.system.service.employee;

import com.leavemanagement.system.service.database.DatabaseServices;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class EmployeeServiceImp implements EmployeeServices {
    DatabaseServices databaseServices=new DatabaseServices();

    @Override
    public Set<LocalDate> getMonthWiseHolidayList(String month) {
       return databaseServices.getMonthWiseHolidayList(month);
    }

    @Override
    public List<LocalDate> getYearWiseHolidayList() {
       return databaseServices.getYearWiseHolidayList();
    }

}
