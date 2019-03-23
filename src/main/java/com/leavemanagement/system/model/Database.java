package com.leavemanagement.system.model;

import lombok.Data;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@Data
public class Database {
    public List<Employee> employeeList=new ArrayList<>();
    public List<Employee> adminList=new ArrayList<>();
    public Map<Month, Set<LocalDate>> holidayList=new HashMap<>();
    public Map<Integer,Map<LeaveType,Integer>> leaves=new HashMap<>();

    private static Database ourInstance = new Database();

    public static Database getInstance() {
        return ourInstance;
    }

    private Database() {
    }
}
