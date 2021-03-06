package com.hexaware.ftp82.model;
import com.hexaware.ftp82.persistence.DbConnection;
import com.hexaware.ftp82.persistence.LeaveDetailsDAO;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Objects;
import java.util.List;
import java.util.Calendar;
/**
 * LeaveDetails class to process employee leave details.
 * @author hexaware
 */
public class LeaveDetails {
 /**
   * leaveId to store leave id.
   * leaveType to store leaveType.
   * startDate to store leave startDate.
   * endDate to store leave endDate.
   * noOfDays to calculate no of days leave applied.
   * leaveReason to store reason for leave.
   * leaveAppliedOn to store applied date of leave.
   * managerComments to store comments from manager.
   * empId to store employee id.
   */
  private int leaveId;
  private String leaveType;
  private String startDate;
  private String endDate;
  private int noOfDays;
  private String leaveStatus;
  private String leaveReason;
  private String leaveAppliedOn;
  private String managerComments;
  private int empId;
  /**
   *
   */
  public LeaveDetails() { }
  /**
   *@param argEmpId to set empId
   */
  public LeaveDetails(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * @param argLeaveId to initialize Leave Id in leave details table.
   * @param argLeaveType to initialize leave type in leave details table.
   * @param argStartDate to initialize start date in leave details table.
   * @param argEndDate to initialize end date in leave details table.
   * @param argNoOfDays to initialize No of days in leave details table.
   * @param argLeaveStatus to initialize leave status in leave details table.
   * @param argLeaveReason to initialize leave reason in leave details table.
   * @param argLeaveAppliedOn to initialize date leave appliedon in leave details table.
   * @param argManagerComments to initialize manager comments in leave details table.
   * @param argEmpId to initialize employee id in leave details table.
   */
  public LeaveDetails(final int leaveId, final String leaveType, final Date startDate,
      final Date endDate, final int noOfDays, final String leaveStatus, final String leaveReason,
      final Date leaveAppliedOn, final String managerComments, final int empId) {
    //try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      this.leaveId = leaveId;
      this.leaveType = leaveType;
      String strtDate = dateFormat.format(startDate);
      this.startDate = strtDate;
      String edDate = dateFormat.format(endDate);
      this.endDate = edDate;
      this.noOfDays = noOfDays;
      this.leaveStatus = leaveStatus;
      this.leaveReason = leaveReason;
      String leaveApplied = dateFormat.format(leaveAppliedOn);
      this.leaveAppliedOn = leaveApplied;
      this.managerComments = managerComments;
      this.empId = empId;
    // } catch (Exception e) {
    //   System.out.println(e.toString());
    // }
  }

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails ld = (LeaveDetails) obj;
    if (Objects.equals(leaveId, ld.leaveId) && Objects.equals(leaveType, ld.leaveType)
        && Objects.equals(startDate, ld.startDate) && Objects.equals(endDate, ld.endDate)
        && Objects.equals(noOfDays, ld.noOfDays) && Objects.equals(leaveStatus, ld.leaveStatus)
        && Objects.equals(leaveReason, ld.leaveReason) && Objects.equals(leaveAppliedOn, ld.leaveAppliedOn)
        && Objects.equals(managerComments, ld.managerComments) && Objects.equals(empId, ld.empId))  {
      return true;
    }
    return false;
  }
 /**
   * hashcode class.
   * @return this LeaveId.
   * @return this LeaveType.
   * @return this startDate.
   * @return this endDate.
   * @return this noOfDays.
   * @return this leaveStatus.
   * @return this leaveReason.
   * @return this leaveAppliedOn.
   * @return this managerComments.
   * @return this empId.
   */
  @Override
  public final int hashCode() {
    return Objects.hash(leaveId, leaveType, startDate, endDate, noOfDays, leaveStatus, leaveReason, leaveAppliedOn, managerComments, empId);
  }
  /**
   * Gets the LeaveId.
   * @return this LeaveId.
   */
  public final  int getLeaveId() {
    return leaveId;
  }
  /**
   *
   * @param argleaveId to set leave id.
   */
  public final void setLeaveId(final int leaveId) {
    this.leaveId = leaveId;
  }
  /**
  @return this Leave Type.
   */
  public final String getLeaveType() {
    return leaveType;
  }
  /**
   *
   * @param argleaveType to set leave type.
   */
  public final void setLeaveType(final String leaveType) {
    this.leaveType = leaveType;
  }
  /**
   * Gets the StartDate.
   * @return this StartDate.
   */
  public final String getStartDate() {
    return startDate;
  }
  /**
   *
   * @param argstartDate to set start date.
   */
  public final void setStartDate(final String startDate) {
    this.startDate = startDate;
  }
  /**
   *@return this End date.
   */
  public final String getEndDate() {
    return endDate;
  }
  /**
   *
   * @param argendDate to set End date.
   */
  public final void setEndDate(final String endDate) {
    this.endDate = endDate;
  }
  /**
   * @return this number of days
   */
  public final int getNoOfDays() {
    return noOfDays;
  }
  /**
   *
   * @param argnoOfDays to set number of days.
   */
  public final void setNoOfDays(final int noOfDays) {
    this.noOfDays = noOfDays;
  }
  /**
   *@return this leave status
   */
  public final String getLeaveStatus() {
    return leaveStatus;
  }
  /**
   *
   * @param argleaveStatus to set leave status.
   */
  public final void setLeaveStatus(final String leaveStatus) {
    this.leaveStatus = leaveStatus;
  }
  /**
   *@return this leave reason
   */
  public final String getLeaveReason() {
    return leaveReason;
  }
  /**
   *
   * @param argleaveReason to set leave reason.
   */
  public final void setLeaveReason(final String leaveReason) {
    this.leaveReason = leaveReason;
  }
  /**
   * @return this leave applied on
   */
  public final String getLeaveAppliedOn() {
    return leaveAppliedOn;
  }
  /**
   *
   * @param argleaveAppliedOn to set applied.
   */
  public final void setLeaveAppliedOn(final String leaveAppliedOn) {
    this.leaveAppliedOn = leaveAppliedOn;
  }
  /**
   * @return this manager comments
   */
  public final String getManagerComments() {
    return managerComments;
  }
  /**
   *
   * @param argmanagerComments to set manager comments.
   */
  public final void setManagerComments(final String managerComments) {
    this.managerComments = managerComments;
  }
  /**
   * @return this Employee ID
   */
  public final int getEmpId() {
    return empId;
  }
  /**
   *
   * @param argempId to set manager comments.
   */
  public final void setEmpId(final int empId) {
    this.empId = empId;
  }
  /**
   *
   */
  private static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }
  /**
   * view the employee's details of given id.
   * @param id the id of the employee.
   * @return the employee details
   */
  public static LeaveDetails[] listAll(final int id) {
    List<LeaveDetails> ls = dao().list(id);
    return ls.toArray(new LeaveDetails[ls.size()]);
  }
  /**
   *@param id to check employee leave history.
   *@return The leave history for the current employee.
   */
  public static LeaveDetails[] history(final int id) {
    List<LeaveDetails> lh = dao().leaveHistory(id);
    return lh.toArray(new LeaveDetails[lh.size()]);
  }
  /**
   *@param leaveType leave pending details
   *@param startDate startdate of applied leave.
   *@param endDate enddate of applied leave.
   *@param empId employee ID
   *@param leaveReason leave reason of applied leave.
   *@return status of the leave application
   */
  public static int applyLeave(final int empId, final String leaveType, final String startDate, final String endDate, final String leaveReason) {
    String leaveStatus = "";
    if (empId == 1000) {
      leaveStatus = LeaveStatus.APPROVED.toString();
    } else {
      leaveStatus = LeaveStatus.PENDING.toString();
    }
    int status = 0;
    int diffInDays = 0;
    try {
      Date appliedDate = Date.valueOf(java.time.LocalDate.now());
      Date sDate = Date.valueOf(startDate);
      Date eDate = Date.valueOf(endDate);
      diffInDays = dateCheck(sDate, eDate);
      if (diffInDays > 0) {
        status = dao().insertLeaveDetails(leaveType, sDate, eDate, diffInDays, leaveReason, appliedDate, leaveStatus, empId);
        //Employee.sendMail(argApplyEmpId, e1.getEmpManagerId(argApplyEmpId));
      } else {
        System.out.println("Cannot apply leave on saturday and sunday");
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }
    return status;
  }
  /**
   * @param sDate to initialize start date.
   * @return values about valid leave date.
   */
  public static int dateExpiryOfsdate(final String sDate) {
    Date startDate = Date.valueOf(sDate);
    long ex = startDate.getTime();
    Date dt = new Date(ex);
    if (dt.before(Date.valueOf(java.time.LocalDate.now()))) {
      return 1;
    } else {
      return 0;
    }
  }
  /**
   * @param eDate to initialize end date.
   * @param sDate to initialize end date.
   * @return values about valid leave date.
   */
  public static int dateExpiryOfedate(final String eDate, final String sDate) {
    Date endDate = Date.valueOf(eDate);
    long ex = endDate.getTime();
    Date dt = new Date(ex);
    if (dt.after(Date.valueOf(sDate))) {
      return 1;
    } else {
      return 0;
    }
  }
  /**
   * @param argApplyEmpId to initialize employee id.
   * @param argApplyLeaveId to initialize leave id.
   * @param argMgrComments to  initialize manager comments.
   * @param argApproveStatus to  initialize leave status.
   * @return return statusId;
   */
  public final int applyForLeave(final int argApplyEmpId, final int argApplyLeaveId, final String argMgrComments, final String argApproveStatus) {
    Employee e1 = dao().getLeaveBalance(argApplyEmpId);
    LeaveDetails l1 = dao().getStatus(argApplyLeaveId);
    int leaveBalance = e1.getEmpLeaveBalance();
    int appliedNoOfLeaves = l1.getNoOfDays();
    String statusOfEmp = l1.getLeaveStatus();
    if (argApproveStatus.equalsIgnoreCase("approve")) {
      statusOfEmp = LeaveStatus.APPROVED.toString();
      int approvedLeaves = leaveBalance - appliedNoOfLeaves;
      //String message="Your leave has been approved !";
      dao().updateEmployee(approvedLeaves, argApplyEmpId);
      dao().updateApproveOrDenial(statusOfEmp, argMgrComments, argApplyLeaveId);
      //Employee.sendMail(e1.getEmpManagerId(argApplyEmpId), argApplyEmpId, message);
        return 1;
    } else if (argApproveStatus.equalsIgnoreCase("deny")) {
      statusOfEmp = LeaveStatus.DENIED.toString();
      //String message="Your leave has been denied !";
      //Employee.sendMail(e1.getEmpManagerId(argApplyEmpId), argApplyEmpId, message);
      dao().updateApproveOrDenial(statusOfEmp, argMgrComments, argApplyLeaveId);
      return 100;
    }
    return 101;
  }
  /**
   * list employee details by employee id.
   * @param empId to get employee details.
   * @param leaveId to get leave details.
   * @return values.
   */
  public static int checkIds(final int empId, final int leaveId) {
    LeaveDetails lsId = dao().checkIdss(empId);
    if (lsId.getLeaveId() == leaveId && lsId.getEmpId() == empId) {
      return 1;
    }
    return 0;
  }
   /**
   * list employee details by employee id.
   * @param strtDate to initialize start date.
   * @param emID to initialize employee id.
   * @return values.
   */
  public static int overLapCheck(final String strtDate, final int emID) {
    //try {
      Date sDate = Date.valueOf(strtDate);
      List<LeaveDetails> lshs = dao().leaveHistory(emID);
      for (LeaveDetails ls : lshs) {
        Date sd = Date.valueOf(ls.getStartDate());
        Date ed = Date.valueOf(ls.getEndDate());
        if (sDate.after(sd) && sDate.before(ed)) {
          return 0;
        }
      }
    // } catch (IllegalArgumentException e) {
    //   System.out.println(e);
    // }
    return 1;
  }
  /**
   * list employee details by id.
   * @param startDate to get employee details.
   * @param endDate to get employee details.
   * @return Employee
   */
  public static int dateCheck(final Date startDate, final Date endDate) {
    int noOfDays = 0;
    Calendar sD = Calendar.getInstance();
    Calendar eD = Calendar.getInstance();
    sD.setTime(startDate);
    eD.setTime(endDate);
    if (sD.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && sD.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
      do {
        sD.add(Calendar.DAY_OF_MONTH, 1);
        if (sD.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && sD.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
          ++noOfDays;
        }
      } while (sD.getTimeInMillis() < eD.getTimeInMillis());
    } else {
      return noOfDays;
    }
    return noOfDays + 1;
  }
/**
   *@param leaveType leave pending details
   *@param startDate startdate of applied leave.
   *@param endDate enddate of applied leave.
   *@param empId employee ID
   *@param leaveReason leave reason of applied leave.
   *@param leaveId leave Id
   *@return status of the leave application
   */
  public static int editLeave(final int empId, final String leaveType, final String startDate, final String endDate, final String leaveReason, final int leaveId) {
    String leaveStatus = LeaveStatus.PENDING.toString();
    int status = 0;
    int diffInDays = 0;
      Date appliedDate = Date.valueOf(java.time.LocalDate.now());

      Date sdt = Date.valueOf(startDate);
      long ex = sdt.getTime();
      Date sDate = new Date(ex);

      Date edt = Date.valueOf(endDate);
      long ex1 = edt.getTime();
      Date eDate = new Date(ex1);

      diffInDays = dateCheck(sDate, eDate);
      status = dao().updateLeaveDetails(leaveType, sDate, eDate, diffInDays, leaveStatus, leaveReason, appliedDate, empId, leaveId);
    return status;
  }
  /**
   * to cancel applied leave.
   * @param leaveID to get leave details.
   * @param empID to get the employee details.
   * @return status.
   */
  public static int removeLeaveRequest(final int leaveID, final int empID) {
    int status = 0;
    try {
      Employee e2 = dao().getLeaveBalance(empID);
      LeaveDetails l2 = dao().getStatus(leaveID);
      int appliedNoOfLeaves = l2.getNoOfDays();
      int leaveBalance = e2.getEmpLeaveBalance();
      String statusOfEmp = l2.getLeaveStatus();

      Date sDate= Date.valueOf(l2.getStartDate());
      long ex = sDate.getTime();
      Date sd = new Date(ex);

      System.out.println("start date:" + sd);
      if (statusOfEmp.equals("APPROVED")) {
        if (sd.before(Date.valueOf(java.time.LocalDate.now()))) {
          int balance = leaveBalance + appliedNoOfLeaves;
          dao().updateEmployee(balance, empID);
          status = dao().deleteLeaveRequest(leaveID);
          return status;
          
        }
      } else {
        status = dao().deleteLeaveRequest(leaveID);
        return status;
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }
    return status;
  }
}
