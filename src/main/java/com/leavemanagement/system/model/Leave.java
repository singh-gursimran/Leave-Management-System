package com.leavemanagement.system.model;

import lombok.Data;

@Data
public class Leave {
    private Integer employeeId;
    private String startdate;
    private String endDate;
    private LeaveType leaveType;

}
