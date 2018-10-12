package com.hexaware.ftp82.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

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
  private Date startDate;
  private Date endDate;
  private int noOfDays;
  private String leaveStatus;
  private String leaveReason;
  private Date leaveAppliedOn;
  private String managerComments;
  private int empId;
  /**
   *
   */
  public LeaveDetails() { }
  /**
   *@param argEmpId to set empId
   */
  public LeaveDetails(final int empId) {
    this.empId = empId;
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
  public LeaveDetails(final int leaveId, final String leaveType, final String startDate,
      final String endDate, final int noOfDays, final String leaveStatus, final String leaveReason,
      final String leaveAppliedOn, final String managerComments, final int empId) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      this.leaveId = leaveId;
      this.leaveType = leaveType;
      //String strtDate = dateFormat.format(startDate);
      Date startdate = Date.valueOf(startDate);
      this.startDate = startdate;
      //String edDate = dateFormat.format(endDate);
      Date enddate = Date.valueOf(endDate);
      this.endDate = enddate;
      this.noOfDays = noOfDays;
      this.leaveStatus = leaveStatus;
      this.leaveReason = leaveReason;
      //String leaveApplied = dateFormat.format(leaveAppliedOn);
      Date leaveApplied = Date.valueOf(leaveAppliedOn);
      this.leaveAppliedOn = leaveApplied;
      this.managerComments = managerComments;
      this.empId = empId;
    } catch (Exception e) {
      System.out.println(e.toString());
    }
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
    public final int hashCode() {
      return Objects.hash(leaveId, leaveType, startDate, endDate, noOfDays, leaveStatus, leaveReason, leaveAppliedOn, managerComments, empId);
  }

    public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
          return ow.writeValueAsString(this);
      } catch(Exception e) {
          throw new RuntimeException(e);
      }
    }
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
  public final Date getStartDate() {
    return startDate;
  }
  /**
   *
   * @param argstartDate to set start date.
   */
  public final void setStartDate(final Date startDate) {
    this.startDate = startDate;
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
  public final void setEndDate(final Date endDate) {
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
  public final Date getLeaveAppliedOn() {
    return leaveAppliedOn;
  }
  /**
   *
   * @param argleaveAppliedOn to set applied.
   */
  public final void setLeaveAppliedOn(final Date leaveAppliedOn) {
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
   * @param empId to set manager comments.
   */
  public final void setEmpId(final int empId) {
    this.empId = empId;
  }
}
