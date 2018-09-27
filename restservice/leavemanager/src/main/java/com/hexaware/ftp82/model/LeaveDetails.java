package com.hexaware.ftp82.model;
import java.util.Date;
import java.util.Objects;
import java.util.List;
import com.hexaware.ftp82.persistence.DbConnection;
import com.hexaware.ftp82.persistence.LeaveDetailsDAO;
//import com.hexaware.ftp82.persistence.EmployeeDAO;

import java.text.SimpleDateFormat;
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
   * @param argLeaveId to initialize employee table details.
   * @param argLeaveType to initialize employee table details.
   * @param argStartDate to initialize employee table details.
   * @param argEndDate to initialize employee table details.
   * @param argNoOfDays to initialize employee table details.
   * @param argLeaveStatus to initialize employee table details.
   * @param argLeaveReason to initialize employee table details.
   * @param argLeaveAppliedOn to initialize employee table details.
   * @param argManagerComments to initialize employee table details.
   * @param argEmpId to initialize employee table details.
   */
  public LeaveDetails(final int argLeaveId, final String argLeaveType, final Date argStartDate, final Date argEndDate, final int argNoOfDays, final String argLeaveStatus, final String argLeaveReason, final Date argLeaveAppliedOn, final String argManagerComments, final int argEmpId) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    this.leaveId = argLeaveId;
    this.leaveType = argLeaveType;
    String strtDate = dateFormat.format(argStartDate);
    this.startDate = strtDate;
    String edDate = dateFormat.format(argEndDate);
    this.endDate = edDate;
    this.noOfDays = argNoOfDays;
    this.leaveStatus = argLeaveStatus;
    this.leaveReason = argLeaveReason;
    String leaveApplied = dateFormat.format(argLeaveAppliedOn);
    this.leaveAppliedOn = leaveApplied;
    this.managerComments = argManagerComments;
    this.empId = argEmpId;
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
   *@param declares the enum variables
   */
  enum LeaveType {
  /**
   *@param decalres EL as leave type
   */
    EL;
  }
  /**
   *@param declares the enum variables
   */
  enum LeaveStatus {
  /**
   *@param declares PENDING, APPROVED, DENIED as enum variables
   */
    PENDING, APPROVED, DENIED;
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
   * @return this StartDate.
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
    this.managerComments = argmanagerComments;-
    
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
}
