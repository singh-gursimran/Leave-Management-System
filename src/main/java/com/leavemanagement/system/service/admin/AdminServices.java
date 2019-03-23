package com.leavemanagement.system.service.admin;

import com.leavemanagement.system.model.Employee;

import java.time.LocalDate;

interface AdminServices {

    void addEmployee(Employee employee);

    void removeEmployee(Employee employee);

    void addHoliday(LocalDate localDate);

}
