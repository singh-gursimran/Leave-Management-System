package com.leavemanagement.system.utilties;


import com.leavemanagement.system.utilties.CalenderService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalenderServiceTest {

    @Test
    void getWorkingDaysBetweenTwoDatesTest() {
        CalenderService calenderService=new CalenderService();
        assertEquals(2,calenderService.getWorkingDaysBetweenTwoDates("07-Mar-2019","09-Mar-2019"));
        assertEquals(2,calenderService.getWorkingDaysBetweenTwoDates("07-Mar-2019","10-Mar-2019"));
        assertEquals(1,calenderService.getWorkingDaysBetweenTwoDates("08-Mar-2019","10-Mar-2019"));
        assertEquals(10,calenderService.getWorkingDaysBetweenTwoDates("04-Mar-2019","17-Mar-2019"));
    }
}