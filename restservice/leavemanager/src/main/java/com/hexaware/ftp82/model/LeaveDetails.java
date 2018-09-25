package com.hexaware.ftp82.model;
import java.util.Objects;
import java.util.List;
import com.hexaware.ftp82.persistence.DbConnection;
import com.hexaware.ftp82.persistence.LeaveDetailsDAO;

//import com.hexaware.ftp82.persistence.EmployeeDAO;

import java.util.regex.*;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 * LeaveDetails class to process employee leave details.
 * @author hexware
 */
public class LeaveDetails {
  /**
 * Apply for leave method to apply leave.
 * @author hexware
 */
  public final void applyForLeave() {
    System.out.println("Welcome to ls");
  }
/**
 *
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
  private int managerId;
  /**
   *
   */
  public LeaveDetails() { }
  /**
   *@param argEmpId to set manager comments
   */
  public LeaveDetails(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * @param argleaveId to initialize LeaveDetails table.
   * @param argleaveType to initialize LeaveDetails table.
   * @param argnoOfDays to initialize LeaveDetails table.
   * @param argstartDate to initialize LeaveDetails table.
   * @param argendDate to initialize LeaveDetails table.
   * @param argleaveStatus to initialize LeaveDetails table.
   * @param argleaveReason to initialize LeaveDetails table.
   * @param argleaveAppliedOn to initialize LeaveDetails table.
   * @param argmanagerComments to initialize LeaveDetails table.
   * @param argempId to initialize LeaveDetails table.
   */
  public LeaveDetails(final int argleaveId, final String argleaveType, final Date argstartDate, final Date argendDate, final int argnoOfDays,
      final String argleaveStatus, final String argleaveReason, final Date argleaveAppliedOn,
      final String argmanagerComments, final int argempId) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    this.leaveId = argleaveId;
    this.leaveType = argleaveType;
    this.startDate = dateFormat.format(argstartDate);
    this.endDate = dateFormat.format(argendDate);
    this.noOfDays = argnoOfDays;
    this.leaveStatus = argleaveStatus;
    this.leaveReason = argleaveReason;
    String appliedOn = dateFormat.format(argleaveAppliedOn);
    this.leaveAppliedOn = appliedOn;
    this.managerComments = argmanagerComments;
    this.empId = argempId;
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails ls = (LeaveDetails) obj;
    if (Objects.equals(leaveId, ls.leaveId)) {
      return true;
    }
    if (Objects.equals(leaveType, ls.leaveType)) {
      return true;
    }
    if (Objects.equals(startDate, ls.startDate)) {
      return true;
    }
    if (Objects.equals(endDate, ls.endDate)) {
      return true;
    }
    if (Objects.equals(noOfDays, ls.noOfDays)) {
      return true;
    }
    if (Objects.equals(leaveStatus, ls.leaveStatus)) {
      return true;
    }
    if (Objects.equals(leaveReason, ls.leaveReason)) {
      return true;
    }
    if (Objects.equals(leaveAppliedOn, ls.leaveAppliedOn)) {
      return true;
    }
    if (Objects.equals(managerComments, ls.managerComments)) {
      return true;
    }
    if (Objects.equals(empId, ls.empId)) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(leaveId, leaveType, startDate, endDate, noOfDays, leaveStatus, leaveReason, leaveAppliedOn, managerComments, empId);
  }
  /**
   * Gets the LeaveId.
   * @return this LeaveId.
   */
  public final int getLeaveId() {
    return leaveId;
  }
  /**
   *
   * @param argleaveId to set leave id.
   */
  public final void setLeaveId(final int argleaveId) {
    this.leaveId = argleaveId;
  }
  /**
   * Gets the LeaveType.
   * @return this LeaveType.
   */
  public final String getLeaveType() {
    return leaveType;
  }
  /**
   *
   * @param argleaveType to set leave type.
   */
  public final void setLeaveType(final String argleaveType) {
    this.leaveType = argleaveType;
  }
    /**
   * Gets the StartDate.
   * @return the startdate
   */
  public final String getStartDate() {
    return startDate;
  }
  /**
   *
   * @param argstartDate to set start date.
   */
  public final void setStartDate(final String argstartDate) {
    this.startDate = argstartDate;
  }
  /**
   * Gets the EndDate.
   * @return this EndDate.
   */
  public final String getEndDate() {
    return endDate;
  }
  /**
   *
   * @param argendDate to set End date.
   */
  public final void setEndDate(final String argendDate) {
    this.endDate = argendDate;
  }
  /**
   * Gets the NumberOfdays.
   * @return this NumberOfDays.
   */
  public final int getNumberOfDays() {
    return noOfDays;
  }
  /**
   *
   * @param argnoOfDays to set employee id.
   */
  public final void setNumberOfDays(final int argnoOfDays) {
    this.noOfDays = argnoOfDays;
  }
    /**
   * Gets the LeaveStatus.
   * @return this LeaveStatus.
   */
  public final String getLeaveStatus() {
    return leaveStatus;
  }
  /**
   *
   * @param argleaveStatus to set leave status.
   */
  public final void setLeaveStatus(final String argleaveStatus) {
    this.leaveStatus = argleaveStatus;
  }
  /**
   * Gets the LeaveId.
   * @return this LeaveId.
   */
  public final String getLeaveReason() {
    return leaveReason;
  }
  /**
   *
   * @param argleaveReason to set leave status.
   */
  public final void setLeaveReason(final String argleaveReason) {
    this.leaveReason = argleaveReason;
  }
  /**
   * Gets the LeaveAppliedOn.
   * @return this LeaveAppliedOn.
   */
  public final String getLeaveAppliedOn() {
    return leaveAppliedOn;
  }
  /**
   *
   * @param argleaveAppliedOn to set leave status.
   */
  public final void setLeaveAppliedOn(final String argleaveAppliedOn) {
    this.leaveAppliedOn = argleaveAppliedOn;
  }

  /**
   * Gets the ManagerComments.
   * @return this ManagerComments.
   */
  public final String getManagerComments() {
    return managerComments;
  }
  /**
   *
   * @param argmanagerComments to set manager comments.
   */
  public final void setManagerComments(final String argmanagerComments) {
    this.managerComments = argmanagerComments;
  }
  /**
   * @return this Employee ID
   */
  public final int getEmpId() {
    return empId;
  }
  /**
   *
   * @param argEmpId to set manager comments.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   *
   */
  private static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }
  /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  public static LeaveDetails[] listAll(final int id) {
    List<LeaveDetails> ls = dao().list(id);
    return ls.toArray(new LeaveDetails[ls.size()]);
  }
  /**
   *@param leaveType leave pending details
   *@param startDate startdate
   *@param endDate enddate
   *@param empId employee ID
   *@param leaveReason leave reason
   *@return status of the application
   */
  public static int applyLeave(final int empId, final String leaveType, final String startDate, final String endDate, final String leaveReason) {
    String leaveStatus = "Pending";
    Date appliedDate = Date.valueOf(java.time.LocalDate.now());
    Date sDate = Date.valueOf(startDate);
    Date eDate = Date.valueOf(endDate);
    long diff = eDate.getTime() - sDate.getTime();
    int diffInDays = (int) diff / (1000 * 60 * 60 * 24);
    int status = dao().insertLeaveDetails(leaveType, sDate, eDate, diffInDays, leaveReason, appliedDate, leaveStatus, empId);
    return status;
  }
  /**
   * @param sDate to initialize start date.
   * @return values of leave date.
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
   * @return values of leave date.
   */
  public static int dateExpiryOfedate(final String eDate) {
    Date endDate = Date.valueOf(eDate);
    long ex = endDate.getTime();
    Date dt = new Date(ex);
    if (dt.after(Date.valueOf(java.time.LocalDate.now()))) {
      return 1;
    } else {
      return 0;
    }
  }
  /**
   *
   * @param argApplyEmpId to check manager Id.
   * @param argApplyLeaveId to check manager Id.
   * @param argMgrComments to check manager Id.
   * @param argApproveStatus to check manager Id.
   * @return return statusId;
   */
  public final int applyLeave(final int argApplyEmpId, final int argApplyLeaveId, final String argMgrComments, final String argApproveStatus) {
    Employee e1 = dao().getLeaveBalance(argApplyEmpId);
    LeaveDetails l1 = dao().getStatus(argApplyLeaveId);
    int leaveBalance = e1.getEmpLeaveBalance();
    int appliedNoOfLeaves = l1.getNumberOfDays();
    String statusOfEmp = l1.getLeaveStatus();
    if (argApproveStatus.equalsIgnoreCase("approve")) {
      if (statusOfEmp.equals("PENDING")) {
        statusOfEmp = "APPROVED";
        int approvedLeaves = leaveBalance - appliedNoOfLeaves;
        int leaves = dao().updateEmployee(approvedLeaves, argApplyEmpId);
        int applyEmpStatus = dao().updateApproveOrDenial(statusOfEmp, argMgrComments, argApplyLeaveId);
        if (leaves > 0 && applyEmpStatus > 0) {
          return 1;
        }
      } else {
        return 102;
      }
    } else if (argApproveStatus.equalsIgnoreCase("deny")) {
      statusOfEmp = "DENIED";
      dao().updateApproveOrDenial(statusOfEmp, argMgrComments, argApplyLeaveId);
      return 100;
    } else {
      return 101;
    }
    return 101;
  }
}
