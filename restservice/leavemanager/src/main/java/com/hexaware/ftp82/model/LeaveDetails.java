package com.hexaware.ftp82.model;
import java.util.Objects;
import java.util.List;
import com.hexaware.ftp82.persistence.DbConnection;
import com.hexaware.ftp82.persistence.LeaveDetailsDAO;
//import com.hexaware.ftp82.persistence.EmployeeDAO;
//import com.hexaware.ftp82.persistence.EmployeeDAO;
//import java.Date;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 * LeaveDetails class to process employee leave details.
 * @author hexaware
 */
public class LeaveDetails {
  /**
 * Apply for leave method to apply leave.
 * @author hexware
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

   * return LeaveDetails.
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
    /**
   * Gets the StartDate.
   * @return the startdate
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
  public final void setNoOfDays(final int argnoOfDays) {
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
   *@param id to check employee leave history.
   *@return The leave history for the current employee.
   */
  public static LeaveDetails[] history(final int id) {
    List<LeaveDetails> lh = dao().leaveHistory(id);
    return lh.toArray(new LeaveDetails[lh.size()]);
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
}
