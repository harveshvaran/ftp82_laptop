package com.hexaware.ftp82.model;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.integration.junit4.JMockit;
/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class LeaveStatusTest {
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
    public final void testLeaveStatus() {
    LeaveStatus ls1 = LeaveStatus.PENDING;
    LeaveStatus ls2 = LeaveStatus.APPROVED;
    LeaveStatus ls3 = LeaveStatus.DENIED;
  }
}
