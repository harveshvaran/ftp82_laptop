package com.hexaware.ftp82.integration.test;

import com.hexaware.ftp82.integration.test.CommonUtil;
import java.util.Objects;
import java.sql.Date;

import javax.management.RuntimeErrorException;
import java.text.SimpleDateFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
/**
 * LeaveDetails class to process employee leave details.
 * @author hexaware
 */
public class LeaveDetails {

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

    public LeaveDetails() {
    }

    public LeaveDetails(final int empId) {
      this.empId = empId;
    }

    public LeaveDetails(final int leaveId, final String leaveType, final Date startDate,
      final Date endDate, final int noOfDays, final String leaveStatus, final String leaveReason,
      final Date leaveAppliedOn, final String managerComments, final int empId) {
        try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        this.leaveId = leaveId;
        this.leaveType = leaveType;
        String strtDate = dateFormat.format(startDate);
        this.startDate = startDate;
        String edDate = dateFormat.format(endDate);
        this.endDate = endDate;
        this.noOfDays = noOfDays;
        this.leaveStatus = leaveStatus;
        this.leaveReason = leaveReason;
        String leaveApplied = dateFormat.format(leaveAppliedOn);
        this.leaveAppliedOn = leaveAppliedOn;
        this.managerComments = managerComments;
        this.empId = empId;
      } catch (Exception e) {
        System.out.println(e.toString());
      }
    } 

    public final  int getLeaveId() {
      return leaveId;
    }
  
    public final void setLeaveId(final int leaveId) {
      this.leaveId = leaveId;
    }
  
    public final String getLeaveType() {
      return leaveType;
    } 
  
    public final void setLeaveType(final String leaveType) {
      this.leaveType = leaveType;
    }
  
    public final Date getStartDate() {
      return startDate;
    }
  
    public final void setStartDate(final Date startDate) {
      this.startDate = startDate;
    }
  
    public final Date getEndDate() {
      return endDate;
    }
  
    public final void setEndDate(final Date endDate) {
      this.endDate = endDate;
    }
  
    public final int getNoOfDays() {
      return noOfDays;
    }
  
    public final void setNoOfDays(final int noOfDays) {
      this.noOfDays = noOfDays;
    } 
  
    public final String getLeaveStatus() {
      return leaveStatus;
    }
  
    public final void setLeaveStatus(final String leaveStatus) {
      this.leaveStatus = leaveStatus;
    }
  
    public final String getLeaveReason() {
      return leaveReason;
    }
  
    public final void setLeaveReason(final String leaveReason) {
      this.leaveReason = leaveReason;
    }
  
    public final Date getLeaveAppliedOn() {
      return leaveAppliedOn;
    }
  
    public final void setLeaveAppliedOn(final Date leaveAppliedOn) {
      this.leaveAppliedOn = leaveAppliedOn;
    }
  
    public final String getManagerComments() {
      return managerComments;
    }
  
    public final void setManagerComments(final String managerComments) {
      this.managerComments = managerComments;
    }
  
    public final int getEmpId() {
      return empId;
    } 
  
    public final void setEmpId(final int empId) {
      this.empId = empId;
    }

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
