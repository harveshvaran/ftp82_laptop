package com.hexaware.ftp82.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.integration.junit4.JMockit;
/**.
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class LeaveTypeTest {
/**
 * Test class for Employee.
 */
  @Test
    public final void testLeaveType() {
    LeaveType lt1 = LeaveType.EL;
    LeaveType lt2 = LeaveType.SL;
    LeaveType lt3 = LeaveType.MPL;
  }
}
