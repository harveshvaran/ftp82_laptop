package com.hexaware.ftp82.model;
import java.sql.Date;
import java.util.Objects;
import java.util.List;
import com.hexaware.ftp82.persistence.DbConnection;
import com.hexaware.ftp82.persistence.LeaveDetailsDAO;
import java.text.SimpleDateFormat;
/**
 * LeaveDetails class to process employee leave details.
 * @author hexware
 */
public class LeaveDetails {
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
  public final int applyForLeave(final int argApplyEmpId, final int argApplyLeaveId, final String argMgrComments, final String argApproveStatus) {
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
  /**
   * list employee details by id.
   * @param empId to get employee details.
   * @param leaveId to get employee details.
   * @return Employee
   */
  public static int checkIds(final int empId, final int leaveId) {
    LeaveDetails lsId = dao().checkIdss(empId);
    System.out.println(lsId.getLeaveId() + " " + leaveId);
    System.out.println(lsId.getEmpId() + " " + empId);
    if (lsId.getLeaveId() == leaveId && lsId.getEmpId() == empId) {
      return 1;
    }
    return 0;
  }
}
