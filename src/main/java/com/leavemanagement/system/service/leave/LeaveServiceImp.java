package com.leavemanagement.system.service.leave;

import com.leavemanagement.system.model.Leave;
import com.leavemanagement.system.model.LeaveType;
import com.leavemanagement.system.service.database.DatabaseServices;
import com.leavemanagement.system.utilties.CalenderService;
import java.util.Map;

public class LeaveServiceImp implements LeaveService {

    DatabaseServices databaseServices = new DatabaseServices();

    private void sanctionLeaves(Leave leave){
        CalenderService calenderService =new CalenderService();
        int availableLeaves= databaseServices.getLeaves(leave.getEmployeeId()).get(leave.getLeaveType());
        int requestedNumberOfDays=
                calenderService.getWorkingDaysBetweenTwoDates(leave.getStartdate(), leave.getEndDate());
        int updatedNumberOfLeaves=availableLeaves-requestedNumberOfDays;
        databaseServices.updateLeaves(leave.getEmployeeId(), leave.getLeaveType(),updatedNumberOfLeaves);
    }

    private Boolean requestValidation(Leave leave){
        boolean leaveSanctioned = false;
        int availableLeaves= databaseServices.getLeaves(leave.getEmployeeId()).get(leave.getLeaveType());
        CalenderService calenderService =new CalenderService();
        int requestedNumberOfDays=
                calenderService.getWorkingDaysBetweenTwoDates(leave.getStartdate(), leave.getEndDate());
        if(availableLeaves>=requestedNumberOfDays){
            leaveSanctioned=true;
        }
        return leaveSanctioned;
    }

    public boolean getLeaves(Leave leave){
        if (requestValidation(leave)){
            sanctionLeaves(leave);
            return true;
        }
        return false;
    }

    public Map<LeaveType, Integer> availableLeaves(Integer employeeId){
        return databaseServices.getLeaves(employeeId);
    }
}
