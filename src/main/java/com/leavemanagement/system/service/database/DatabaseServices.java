package com.leavemanagement.system.service.database;

import com.leavemanagement.system.model.Database;
import com.leavemanagement.system.model.Employee;
import com.leavemanagement.system.model.LeaveType;

import java.time.LocalDate;
import java.util.*;

public class DatabaseServices {
    private Database database=Database.getInstance();

    public void addEmployee(Employee employee){
        database.employeeList.add(employee);
    }

    public void removeEmployee(Employee employee){
        database.employeeList.remove(employee);
    }

    public Map<LeaveType,Integer> getLeaves(Integer employeeId){
        return database.leaves.get(employeeId);
    }

    public void updateLeaves(int employeeId,LeaveType leaveType,int update){
        database.leaves.get(employeeId).put(leaveType,update);
    }

    public Set<LocalDate> getMonthWiseHolidayList(String month){
        return database.holidayList.get(month);
    }

    public List<LocalDate> getYearWiseHolidayList(){
        List<LocalDate> yearWiseHolidayList=new ArrayList<>();
        for (Set<LocalDate> month:database.holidayList.values()){
            yearWiseHolidayList.addAll(month);
        }
        return yearWiseHolidayList;
    }

    public void addHoliday(LocalDate date){
        if (!database.getHolidayList().containsKey(date.getMonth())){
            Set<LocalDate> set=new HashSet<>();
            set.add(date);
            database.getHolidayList().put(date.getMonth(),set);
        }
        else{
            database.holidayList.get(date.getMonth()).add(date);}
    }

    public boolean isAdmin(Employee employee){
        if (database.getAdminList().contains(employee)){
            return true;
        }
        else {
            return false;
        }
    }

    public void addAdmin(Employee employee){
        database.getAdminList().add(employee);
    }
}


