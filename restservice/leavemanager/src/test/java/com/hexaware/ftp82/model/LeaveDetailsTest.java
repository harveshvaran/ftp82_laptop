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
          Date sDate = Date.valueOf("2018-11-27");
          Date eDate = Date.valueOf("2018-11-29");
          dao.insertLeaveDetails("EL", sDate, eDate, 3, "SICK", appliedDate, "PENDING", 100);
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
    int e = LeaveDetails.applyLeave(100, "EL", "2018-11-27", "2018-11-29", "SICK");
    assertEquals(0, e);
  }
  /**
   * testDateMethod class Tests that a fetch of a specific employee works correctly.
   */
  @Test
  public final void testDateMethod() {
    int res = LeaveDetails.dateExpiryOfsdate("2018-10-28");
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
    final LeaveDetails l101 = new LeaveDetails();
    new Expectations() {
      {
        dao.getLeaveBalance(100);
        e100.setEmpLeaveBalance(30);
        result = e100;

        dao.getStatus(200);
        l100.setNoOfDays(5);
        l100.setLeaveStatus("PENDING");
        result = l100;

        dao.getStatus(400);
        l101.setNoOfDays(5);
        l101.setLeaveStatus("APPROVE");
        result = l101;

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
    int status = l100.applyForLeave(100, 200, "hi", "approve");
    int status1 = l100.applyForLeave(100, 300, "hi", "deny");
    int status2 = l100.applyForLeave(100, 300, "hi", "pending");
    int status3 = l101.applyForLeave(100, 400, "hi", "approve");
    assertEquals(status, 1);
    assertNotEquals(status, 1000);
    assertEquals(status1, 100);
    assertEquals(status2, 101);
    assertEquals(status3, 101);
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
    final LeaveDetails l101 = new LeaveDetails();
    new Expectations() {
      {
        dao.checkIdss(2000);
        l100.setEmpId(2000);
        l100.setLeaveId(1000);
        result = l100;

        dao.checkIdss(4000);
        l101.setEmpId(5000);
        l101.setLeaveId(1000);
        result = l101;
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
    int l2 = LeaveDetails.checkIds(4000, 1000);
    assertEquals(l100.getEmpId(), 2000);
    assertEquals(l100.getLeaveId(), 1000);
    assertNotEquals(l101.getEmpId(), 4000);
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
    Date sDate = Date.valueOf("2018-10-15");
    Date eDate = Date.valueOf("2018-10-16");
    int res = LeaveDetails.dateCheck(sDate, eDate);
    assertEquals(2, res);
    Date sDate1 = Date.valueOf("2018-10-15");
    Date eDate1 = Date.valueOf("2018-10-11");
    int res1 = LeaveDetails.dateCheck(sDate1, eDate1);
    assertEquals(2, res1);
  }
  /**
   *@param dao to access object
   */
  @Test
  public final void testUpdateLeave(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        try {
          Date appliedDate = Date.valueOf(java.time.LocalDate.now());
          Date sDate = Date.valueOf("2018-10-26");
          Date eDate = Date.valueOf("2018-10-26");
          dao.updateLeaveDetails("EL", sDate, eDate, 1, "PENDING", "SICK", appliedDate, 100, 20);
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
    int e = LeaveDetails.editLeave(100, "EL", "2018-10-26", "2018-10-26", "SICK", 20);
    assertEquals(1, e);
  }
  // /**
  //  *@param dao to access object
  //  */
  // @Test
  // public final void testReEditPermission(@Mocked final LeaveDetailsDAO dao) {
  //   final Employee eStatus = new Employee();
  //   final LeaveDetails lsStatus = new LeaveDetails();
  //   new Expectations() {
  //     {
  //       try {
  //         dao.getLeaveBalance(100);
  //         dao.checkStatus(1);
  //         eStatus.setEmpLeaveBalance(30);
  //         result = eStatus;

  //         lsStatus.setNoOfDays(5);
  //         lsStatus.setStartDate("2018/11/15");
  //         lsStatus.setLeaveStatus("DENIED");
  //         result = lsStatus;

  //         dao.updateEmployee(25, 100);
  //         dao.reEditApproveOrDenial(1, "approve", "okk");
  //         result = 1;

  //       } catch(Exception e) {
  //         System.out.println(e.toString());
  //       }
  //     }
  //   };
  //   new MockUp<LeaveDetails>() {
  //     @Mock
  //     LeaveDetailsDAO dao() {
  //       return dao;
  //     }
  //   };
  //   int e = LeaveDetails.editPermis(100, 1, "approve", "okk");
  //   assertEquals(0, e);
  // }
  /**
   *@param dao to access object
   */
  @Test
  public final void testReEditPermission(@Mocked final LeaveDetailsDAO dao) {
    final Employee eStatus = new Employee();
    final LeaveDetails lsStatus = new LeaveDetails();
    new Expectations() {
      {
        dao.getLeaveBalance(100);
        dao.checkStatus(1);
        eStatus.setEmpLeaveBalance(30);

        lsStatus.setNoOfDays(5);
        lsStatus.setStartDate("2018/11/15");
        lsStatus.setLeaveStatus("DENIED");

        int leaveBalance = eStatus.getEmpLeaveBalance();
        int appliedNoOfLeaves = lsStatus.getNoOfDays();
        try {
          Date sDate = Date.valueOf(lsStatus.getStartDate());
          if(sDate.after(Date.valueOf(java.time.LocalDate.now()))) {
            String editStatus = "";
            int approvedLeaves = 0;
            if("approve".equalsIgnoreCase("approve")) {
              editStatus = LeaveStatus.APPROVED.toString();
              approvedLeaves = leaveBalance - appliedNoOfLeaves;
            } else if ("approve".equalsIgnoreCase("deny")){
              editStatus = LeaveStatus.DENIED.toString();
              approvedLeaves = leaveBalance + appliedNoOfLeaves;
            } else {
              result = -1;
            }
            if (editStatus.equals(lsStatus.getLeaveStatus())) {
              result = -1;
            } else {
                dao.updateEmployee(approvedLeaves, 100);
                dao.reEditApproveOrDenial(1, editStatus, "okk");
                result = 1;
            }
          }
        } catch(Exception e) {
          System.out.println(e.toString());
        }
        result = 0;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    int e = LeaveDetails.editPermis(100, 1, "approve", "okk");
    assertEquals(0, e);
  }
   /**
   *@param dao to access object
   */
  @Test
  public final void testDeleteLeave(@Mocked final LeaveDetailsDAO dao) {
    final LeaveDetails ld4 = new LeaveDetails();
    final Employee e100 = new Employee();
    new Expectations() {
      {
        try {
          Employee e2 = dao.getLeaveBalance(100);
          LeaveDetails l2 = dao.getStatus(10);
          int appliedNoOfLeaves = l2.getNoOfDays();
          int leaveBalance = e2.getEmpLeaveBalance();
          String statusOfEmp = l2.getLeaveStatus();
          Date sd = Date.valueOf(l2.getStartDate());
          System.out.println("start date:" + sd);
          if (statusOfEmp.equals("APPROVED")) {
            if (sd.before(Date.valueOf(java.time.LocalDate.now()))) {
              int balance = leaveBalance + appliedNoOfLeaves;
              dao.updateEmployee(15, 100);
              dao.deleteLeaveRequest(10);
              result = 0;
            }
          } else {
            dao.deleteLeaveRequest(10);
            result = 1;
          }
        } catch (Exception e) {
          System.out.println(e.toString());
        }
        result = 3;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    int e = LeaveDetails.removeLeaveRequest(10, 100);
    assertEquals(0, e);
  }
}
