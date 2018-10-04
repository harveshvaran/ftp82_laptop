package com.hexaware.ftp82.model;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
//import static org.junit.Assert.assertEquals;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
@RunWith(JMockit.class)
public class LeaveStatusTest {
    @Test
    public final void testLeaveStatus() {
        LeaveStatus ls1 = LeaveStatus.PENDING;
        LeaveStatus ls2 = LeaveStatus.APPROVED;
        LeaveStatus ls3 = LeaveStatus.DENIED;
        
    }

}