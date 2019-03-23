package com.leavemanagement.system.service.employee;

import com.leavemanagement.system.model.LeaveType;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

interface EmployeeServices {
    Set<LocalDate> getMonthWiseHolidayList(String month);
    List<LocalDate> getYearWiseHolidayList();

}
