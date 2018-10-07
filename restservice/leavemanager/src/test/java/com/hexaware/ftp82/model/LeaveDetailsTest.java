package com.hexaware.ftp82.model;

import com.hexaware.ftp82.persistence.LeaveDetailsDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Date;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;
//import java.text.SimpleDateFormat;
/**
 * Test class for LeaveDetails.
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
  * Test class for LeaveDetails.
  */
  @Test
  public final void testLeaveDetails() {
    final LeaveDetails ld = new LeaveDetails(1, "EL", "2018-08-27", "2018-08-27", 2, "PENDING", "SICK", "2018-08-27", "OK", 1000);
    final LeaveDetails ld1 = new LeaveDetails();
    assertNotEquals(ld, null);
    assertNotEquals(ld, new Integer(100));
    assertEquals(ld, new LeaveDetails(1, "EL", "2018-08-27", "2018-08-27", 2, "PENDING", "SICK", "2018-08-27", "OK", 1000));
    assertEquals(ld1, new LeaveDetails());
    assertEquals(ld1.hashCode(), new LeaveDetails().hashCode());
    ld.setLeaveId(100);
    assertEquals(ld.getLeaveId(), 100);
    ld.setLeaveType("EL");
    assertEquals(ld.getLeaveType(), "EL");
    ld.setStartDate("2018-08-27");
    assertEquals(ld.getStartDate(), "2018-08-27");
    ld.setEndDate("2018-08-27");
    assertEquals(ld.getEndDate(), "2018-08-27");
    ld.setNoOfDays(2);
    assertEquals(ld.getNoOfDays(), 2);
    ld.setLeaveStatus("PENDING");
    assertEquals(ld.getLeaveStatus(), "PENDING");
    ld.setLeaveReason("SICK");
    assertEquals(ld.getLeaveReason(), "SICK");
    ld.setManagerComments("OK");
    assertEquals(ld.getManagerComments(), "OK");
    ld.setEmpId(1000);
    assertEquals(ld.getEmpId(), 1000);
    ld.setLeaveAppliedOn("2018-08-27");
    assertEquals(ld.getLeaveAppliedOn(), "2018-08-27");
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        dao.list(100); result = new ArrayList<LeaveDetails>();
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] es = LeaveDetails.listAll(100);
    assertEquals(0, es.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        ArrayList<LeaveDetails> es = new ArrayList<LeaveDetails>();
        es.add(new LeaveDetails(1));
        es.add(new LeaveDetails(10));
        es.add(new LeaveDetails(100));
        dao.list(100); result = es;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] es = LeaveDetails.listAll(100);
    assertEquals(3, es.length);
    assertEquals(new LeaveDetails(1), es[0]);
    assertEquals(new LeaveDetails(10), es[1]);
    assertEquals(new LeaveDetails(100), es[2]);
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testApplyLeave(@Mocked final LeaveDetailsDAO dao) {
    final LeaveDetails ld2 = new LeaveDetails();
    new Expectations() {
      {
        try {
          Date appliedDate = Date.valueOf(java.time.LocalDate.now());
          Date sDate = Date.valueOf("2018-08-26");
          Date eDate = Date.valueOf("2018-08-26");
          dao.insertLeaveDetails("EL", sDate, eDate, 0, "SICK", appliedDate, "Pending", 100);
        } catch (Exception e) {
          System.out.println(e.toString());
        }
        result = 1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    int e = LeaveDetails.applyLeave(100, "EL", "2018-08-26", "2018-08-26", "SICK");
    assertEquals(1, e);

    //e = LeaveDetails.applyLeave(-1);
    //assertNull(e);
  }
  /**
   * Tests that a fetch of a specific leavedetails works correctly.
   */
  @Test
  public final void testDateMethod()  {
    int res = LeaveDetails.dateExpiryOfsdate("2018-10-08");
    assertEquals(0, res);
    int res1 = LeaveDetails.dateExpiryOfsdate("2018-10-02");
    assertEquals(1, res1);
    int res2 = LeaveDetails.dateExpiryOfedate("2018-10-15", "2018-10-08");
    assertEquals(1, res2);
    int res3 = LeaveDetails.dateExpiryOfedate("2018-10-06", "2018-10-08");
    assertEquals(0, res3);
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
