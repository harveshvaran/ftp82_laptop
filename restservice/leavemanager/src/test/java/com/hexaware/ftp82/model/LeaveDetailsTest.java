package com.hexaware.ftp82.model;

import com.hexaware.ftp82.persistence.LeaveDetailsDAO;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class LeaveDetailsTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testLeaveHistory(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        dao.leaveHistory(300); result = new ArrayList<LeaveDetails>();
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] l = LeaveDetails.history(300);
    assertEquals(0, l.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAll(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        ArrayList<LeaveDetails> lt = new ArrayList<LeaveDetails>();
        lt.add(new LeaveDetails(100));
        lt.add(new LeaveDetails(200));
        lt.add(new LeaveDetails(300));
        dao.list(300); result = lt;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] lt = LeaveDetails.listAll(300);
    assertEquals(3, lt.length);
    assertEquals(new LeaveDetails(100), lt[0]);
    assertEquals(new LeaveDetails(200), lt[1]);
    assertEquals(new LeaveDetails(300), lt[2]);
  }
}
