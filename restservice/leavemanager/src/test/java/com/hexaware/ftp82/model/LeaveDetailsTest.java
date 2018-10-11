package com.hexaware.ftp82.model;
import com.hexaware.ftp82.persistence.LeaveDetailsDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.sql.Date;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.List;
import java.util.ArrayList;
/**
  * setup method.
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
    //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String strtDate = "2018-08-27";
    String endDate = "2018-08-27";
    String appliedDate = "2018-08-27";
    Date sDate = Date.valueOf(strtDate);
    Date eDate = Date.valueOf(endDate);
    Date adate = Date.valueOf(appliedDate);
    final LeaveDetails ld = new LeaveDetails(1, "EL", sDate, eDate, 2, "PENDING", "SICK", adate, "OK", 1000);
    final LeaveDetails ld1 = new LeaveDetails();
    assertNotEquals(ld, null);
    assertNotEquals(ld, new Integer(100));
    assertEquals(ld, new LeaveDetails(1, "EL", sDate, eDate, 2, "PENDING", "SICK", adate, "OK", 1000));
    assertEquals(ld1, new LeaveDetails());
    assertNotEquals(ld, new LeaveDetails());
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
          dao.insertLeaveDetails("EL", sDate, eDate, 2, "SICK", appliedDate, "PENDING", 100);
        } catch (Exception e) {
          System.out.println(e.toString());
        }
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    int e = LeaveDetails.applyLeave(100, "EL", "2018-08-26", "2018-08-28", "SICK");
    assertEquals(1, e);
    int e1 = LeaveDetails.applyLeave(1000, "EL", "2018-08-26", "2018-08-28", "SICK");
    assertEquals(1, e1);
  }
  /**
   * testDateMethod class Tests that a fetch of a specific employee works correctly.
   */
  @Test
  public final void testDateMethod() {
    int res = LeaveDetails.dateExpiryOfsdate("2018-10-29");
    assertEquals(0, res);
    int res1 = LeaveDetails.dateExpiryOfsdate("2018-10-02");
    assertEquals(1, res1);
    int res2 = LeaveDetails.dateExpiryOfedate("2018-10-15", "2018-10-08");
    assertEquals(1, res2);
    int res3 = LeaveDetails.dateExpiryOfedate("2018-10-06", "2018-10-08");
    assertEquals(0, res3);
  }
  /**
   * testApplyOrDeny class Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testApplyOrDeny(@Mocked final LeaveDetailsDAO dao) {
    final Employee e100 = new Employee();
    final LeaveDetails l100 = new LeaveDetails();
    new Expectations() {
      {
        dao.getLeaveBalance(100);
        e100.setEmpLeaveBalance(30);
        result = e100;
        dao.getStatus(200);
        l100.setNoOfDays(5);
        l100.setLeaveStatus("PENDING");
        result = l100;
        dao.updateEmployee(25, 100);
        result = 1;
        dao.updateApproveOrDenial("APPROVED", "hi", 200);
        result = 1;
        dao.updateApproveOrDenial("DENIED", "hi", 300);
        result = 1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails ld = new LeaveDetails();
    int status = ld.applyForLeave(100, 200, "hi", "approve");
    int status1 = ld.applyForLeave(100, 300, "hi", "deny");
    int status2 = ld.applyForLeave(100, 300, "hi", "oky");
    assertEquals(status, 1);
    assertNotEquals(status, 1000);
    assertEquals(status1, 100);
    assertEquals(status2, 101);
  }
  /**
   * testLeaveHistory class Tests that a fetch of a specific employee works correctly.
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
   * testListAll class Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAll(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        ArrayList<LeaveDetails> lt = new ArrayList<LeaveDetails>();
        lt.add(new LeaveDetails(100));
        lt.add(new LeaveDetails(200));
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
    assertEquals(2, lt.length);
    assertEquals(new LeaveDetails(100), lt[0]);
    assertEquals(new LeaveDetails(200), lt[1]);
  }
  /**
   * testCheckIds class Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testCheckIds(@Mocked final LeaveDetailsDAO dao) {
    final LeaveDetails l100 = new LeaveDetails();
    new Expectations() {
      {
        dao.checkIdss(2000);
        l100.setEmpId(2000);
        l100.setLeaveId(1000);
        result = l100;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    int l = LeaveDetails.checkIds(2000, 1000);
    int l1 = LeaveDetails.checkIds(3000, 1000);
    assertEquals(l100.getEmpId(), 2000);
    assertEquals(l100.getLeaveId(), 1000);
    assertEquals(l, 1);
    assertNotEquals(l, 0);
    assertEquals(l1, 0);
  }
 /**
   * testOverlap class Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testOverlap(@Mocked final LeaveDetailsDAO dao) {
    final LeaveDetails lea = new LeaveDetails();
    final LeaveDetails lea1 = new LeaveDetails();
    new Expectations() {
      {
        List<LeaveDetails> lshs = new ArrayList();
        lea.setStartDate("2018-10-06");
        lea.setEndDate("2018-10-08");
        lea1.setStartDate("2018-10-06");
        lea1.setEndDate("2018-10-08");
        lshs.add(lea);
        lshs.add(lea1);
        lshs = dao.leaveHistory(300);
        result = lshs;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    int l = LeaveDetails.overLapCheck("2018-10-16", 300);
    int l2 = LeaveDetails.overLapCheck("2018-10-14", 300);
    assertEquals(1, l);
    assertEquals(1, l2);
  }
  /**
   *
   */
  @Test
  public final void testDateCheck() {
    Date sDate = Date.valueOf("2018-10-12");
    Date eDate = Date.valueOf("2018-10-16");
    int res = LeaveDetails.dateCheck(sDate, eDate);
    assertEquals(3, res);
    Date sDate1 = Date.valueOf("2018-10-12");
    Date eDate1 = Date.valueOf("2018-10-11");
    int res1 = LeaveDetails.dateCheck(sDate1, eDate1);
    assertEquals(1, res1);
  }
  /**
   *@param dao to access object
   */
  @Test
  public final void testUpdateLeave(@Mocked final LeaveDetailsDAO dao) {
    final LeaveDetails ld3 = new LeaveDetails();
    new Expectations() {
      {
        try {
          Date appliedDate = Date.valueOf(java.time.LocalDate.now());
          Date sDate = Date.valueOf("2018-08-26");
          Date eDate = Date.valueOf("2018-08-26");
          dao.updateLeaveDetails("EL", sDate, eDate, 2, "PENDING", "SICK", appliedDate, 100, 20);
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
    int e = LeaveDetails.editLeave(100, "EL", "2018-08-26", "2018-08-26", "SICK", 20);
    assertEquals(1, e);
  }
}
