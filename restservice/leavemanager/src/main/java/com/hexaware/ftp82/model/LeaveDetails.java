package com.hexaware.ftp82.model;
import java.util.Date;
import java.util.Objects;

/**
 * LeaveDetails class to process employee leave details.
 * @author hexware
 */
public class LeaveDetails {
/**
 *
 */
  private int leaveId;
  private LeaveType leaveType;
  private Date startDate;
  private Date endDate;
  private int noOfDays;
  private LeaveStatus leaveStatus;
  private String leaveReason;
  private Date leaveAppliedOn;
  private String managerComments;
  private int empId;
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails ld = (LeaveDetails) obj;
    if (Objects.equals(leaveId, ld.leaveId)) {
      return true;
    }
    if (Objects.equals(leaveType, ld.leaveType)) {
      return true;
    }
    if (Objects.equals(startDate, ld.startDate)) {
      return true;
    }
    if (Objects.equals(endDate, ld.endDate)) {
      return true;
    }
    if (Objects.equals(noOfDays, ld.noOfDays)) {
      return true;
    }
    if (Objects.equals(leaveStatus, ld.leaveStatus)) {
      return true;
    }
    if (Objects.equals(leaveReason, ld.leaveReason)) {
      return true;
    }
    if (Objects.equals(leaveAppliedOn, ld.leaveAppliedOn)) {
      return true;
    }
    if (Objects.equals(managerComments, ld.managerComments)) {
      return true;
    }
    if (Objects.equals(empId, ld.empId)) {
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
 *
 */
  public LeaveDetails() { }
  /**
   * @param argleaveId to initialize employee table details.
   * @param argleaveType to initialize employee table details.
   * @param argstartDate to initialize employee table details.
   * @param argendDate to initialize employee table details.
   * @param argnoOfDays to initialize employee table details.
   * @param argleaveStatus to initialize employee table details.
   * @param argleaveReason to initialize employee table details.
   * @param argleaveAppliedOn to initialize employee table details.
   * @param argmanagerComments to initialize employee table details.
   * @param argempId to initialize employee table details.
   */
  public LeaveDetails(final int argleaveId, final LeaveType argleaveType, final Date argstartDate, final Date argendDate, final int argnoOfDays, final LeaveStatus argleaveStatus, final String argleaveReason, final Date argleaveAppliedOn, final String argmanagerComments, final int argempId) {
    this.leaveId = argleaveId;
    this.leaveType = argleaveType;
    this.startDate = argstartDate;
    this.endDate = argendDate;
    this.noOfDays = argnoOfDays;
    this.leaveStatus = argleaveStatus;
    this.leaveReason = argleaveReason;
    this.leaveAppliedOn = argleaveAppliedOn;
    this.managerComments = argmanagerComments;
    this.empId = argempId;
  }
  /**
   *@return the Leave ID.
   */
  public final  int getLeaveId() {
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
  @return this Leave Type.
   */
  public final LeaveType getLeaveType() {
    return leaveType;
  }
  /**
   *
   * @param argleaveType to set leave type.
   */
  public final void setLeaveType(final LeaveType argleaveType) {
    this.leaveType = argleaveType;
  }
  /**
   * @return this Leave Type.
   */
  public final Date getStartDate() {
    return startDate;
  }
  /**
   *
   * @param argstartDate to set start date.
   */
  public final void setStartDate(final Date argstartDate) {
    this.startDate = argstartDate;
  }
  /**
   *@return this End date.
   */
  public final Date getEndDate() {
    return endDate;
  }
  /**
   *
   * @param argendDate to set End date.
   */
  public final void setEndDate(final Date argendDate) {
    this.endDate = argendDate;
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
  public final void setNOOfDays(final int argnoOfDays) {
    this.noOfDays = argnoOfDays;
  }
  /**
   *@return this leave status
   */
  public final LeaveStatus getLeaveStatus() {
    return leaveStatus;
  }
  /**
   *
   * @param argleaveStatus to set leave status.
   */
  public final void setLeaveStatus(final LeaveStatus argleaveStatus) {
    this.leaveStatus = argleaveStatus;
  }
  /**
   *@return this leave reason
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
   * @return this leave applied on
   */
  public final Date getLeaveAppliedOn() {
    return leaveAppliedOn;
  }
  /**
   *
   * @param argleaveAppliedOn to set leave status.
   */
  public final void setLeaveAppliedOn(final Date argleaveAppliedOn) {
    this.leaveAppliedOn = argleaveAppliedOn;
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
   * @param argempId to set manager comments.
   */
  public final void setEmpId(final int argempId) {
    this.empId = argempId;
  }
  /**
   * apply for leave method to process employee leave details.
   * @author hexware
   */
  public final void applyForLeave() {
    System.out.println("Welcome to ls");
  }
}
