package com.hexaware.ftp82.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
//import java.text.DateFormat;

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
  public LeaveDetails(final int empId) {
    this.empId = empId;
  }
  /**
   * @param leaveId to initialize Leave Id in leave details table.
   * @param leaveType to initialize leave type in leave details table.
   * @param startDate to initialize start date in leave details table.
   * @param endDate to initialize end date in leave details table.
   * @param noOfDays to initialize No of days in leave details table.
   * @param leaveStatus to initialize leave status in leave details table.
   * @param leaveReason to initialize leave reason in leave details table.
   * @param leaveAppliedOn to initialize date leave appliedon in leave details table.
   * @param managerComments to initialize manager comments in leave details table.
   * @param empId to initialize employee id in leave details table.
   */
  public LeaveDetails(final int argLeaveId, final String argLeaveType, final String argStartDate,
      final String argEndDate, final int argNoOfDays, final String argLeaveStatus, final String argLeaveReason,
      final String argLeaveAppliedOn, final String argManagerComments, final int argEmpId) {
     try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
   * @param leaveId to set leave id.
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
   * @param leaveType to set leave type.
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
   * @param startDate to set start date.
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
   * @param endDate to set End date.
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
   * @param noOfDays to set number of days.
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
   * @param leaveStatus to set leave status.
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
   * @param leaveReason to set leave reason.
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
   * @param leaveAppliedOn to set applied.
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
   * @param managerComments to set manager comments.
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
