package com.hexaware.ftp82.model;
import java.sql.Date;
import java.util.Objects;
import java.util.List;
import com.hexaware.ftp82.persistence.DbConnection;
import com.hexaware.ftp82.persistence.LeaveDetailsDAO;
import java.text.SimpleDateFormat;
/**
 * LeaveDetails class to process employee leave details.
 * @author hexaware
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
  public LeaveDetails(final int argLeaveId, final String argLeaveType, final String argStartDate, final String argEndDate, final int argNoOfDays, final String argLeaveStatus, final String argLeaveReason, final String argLeaveAppliedOn, final String argManagerComments, final int argEmpId) {
    try {
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
    } catch (Exception e)  {
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
   *@return this End date.
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
    int status = 0;
    try {
      Date appliedDate = Date.valueOf(java.time.LocalDate.now());
      Date sDate = Date.valueOf(startDate);
      Date eDate = Date.valueOf(endDate);
      long diff = eDate.getTime() - sDate.getTime();
      int diffInDays = (int) diff / (1000 * 60 * 60 * 24);
      status = dao().insertLeaveDetails(leaveType, sDate, eDate, diffInDays, leaveReason, appliedDate, leaveStatus, empId);
    } catch (Exception e) {
      System.out.println(e.toString());
    }
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
   * @param sDate to initialize end date.
   * @return values of leave date.
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
    int appliedNoOfLeaves = l1.getNoOfDays();
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
    if (lsId.getLeaveId() == leaveId && lsId.getEmpId() == empId) {
      return 1;
    }
    return 0;
  }
   /**
   * list employee details by id.
   * @param empId to get employee details.
   * @param leaveId to get employee details.
   * @return Employee
   */
   public static int overlapCheck(int empId, String startDate) {
     List<LeaveDetails> li = dao().leaveHistory(empId);
     Date chDate = date.valueOf(startDate);
     for(LeaveDetails l : li) {
       Date sDate = l.getStartDate();
       Date eDate = l.getEndDate();
       if(chDate.after(sDate)&&chDate.before(eDate)) {
         return 0;
       } else 
       {
         return 1;
       }
     }
   }
}
