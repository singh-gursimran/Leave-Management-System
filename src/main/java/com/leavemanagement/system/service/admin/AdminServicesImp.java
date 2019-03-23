package com.leavemanagement.system.service.admin;

import com.leavemanagement.system.exception.LeaveManagementException;
import com.leavemanagement.system.model.Employee;
import com.leavemanagement.system.service.database.DatabaseServices;
import java.time.LocalDate;

public class AdminServicesImp implements AdminServices {
    private DatabaseServices databaseServices = new DatabaseServices();

    public AdminServicesImp(Employee admin) throws LeaveManagementException {
        if (!databaseServices.isAdmin(admin)) {
            throw new LeaveManagementException("No Admin Rights");
        }
    }

    public void addEmployee(Employee employee) {
        databaseServices.addEmployee(employee);
    }

    public void removeEmployee(Employee employee){
        databaseServices.removeEmployee(employee);
    }

    public void addHoliday(LocalDate date){
        databaseServices.addHoliday(date);
    }

}
