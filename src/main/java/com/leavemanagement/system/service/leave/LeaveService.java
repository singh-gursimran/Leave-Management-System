package com.leavemanagement.system.service.leave;

import com.leavemanagement.system.model.Leave;
import com.leavemanagement.system.model.LeaveType;

import java.util.Map;

public interface LeaveService {

    Map<LeaveType, Integer> availableLeaves(Integer employeeId);

    boolean getLeaves(Leave leave);

}
