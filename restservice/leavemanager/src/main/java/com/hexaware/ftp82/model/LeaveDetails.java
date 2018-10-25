package com.hexaware.ftp82.model;
import java.sql.Date;
import java.util.Objects;
import java.util.List;
import com.hexaware.ftp82.persistence.DbConnection;
import com.hexaware.ftp82.persistence.LeaveDetailsDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.text.DateFormat;
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
  public LeaveDetails(final int leaveId, final String leaveType, final Date startDate,
      final Date endDate, final int noOfDays, final String leaveStatus, final String leaveReason,
      final Date leaveAppliedOn, final String managerComments, final int empId) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      this.leaveId = leaveId;
      this.leaveType = leaveType;
      String startDate = dateFormat.format(startDate);
      this.startDate = startDate;
      String endDate = dateFormat.format(endDate);
      this.endDate = endDate;
      this.noOfDays = noOfDays;
      this.leaveStatus = leaveStatus;
      this.leaveReason = leaveReason;
      String leaveApplied = dateFormat.format(leaveAppliedOn);
      this.leaveAppliedOn = leaveApplied;
      this.managerComments = argsManagerComments;
      this.empId = argsEmpId;
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
   * @param argLeaveId to set leave id.
   */
  public final void setLeaveId(final int argLeaveId) {
    this.leaveId = argLeaveId;
  }
  /**
  @return this Leave Type.
   */
  public final String getLeaveType() {
    return leaveType;
  }
  /**
   *
   * @param argLeaveType to set leave type.
   */
  public final void setLeaveType(final String argLeaveType) {
    this.leaveType = argLeaveType;
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
   * @param argStartDate to set start date.
   */
  public final void setStartDate(final String argStartDate) {
    this.startDate = argStartDate;
  }
  /**
   *@return this End date.
   */
  public final String getEndDate() {
    return endDate;
  }
  /**
   *
   * @param argEndDate to set End date.
   */
  public final void setEndDate(final String argEndDate) {
    this.endDate = argEndDate;
  }
  /**
   * @return this number of days
   */
  public final int getNoOfDays() {
    return noOfDays;
  }
  /**
   *
   * @param argNoOfDays to set number of days.
   */
  public final void setNoOfDays(final int argNoOfDays) {
    this.noOfDays = argNoOfDays;
  }
  /**
   *@return this leave status
   */
  public final String getLeaveStatus() {
    return leaveStatus;
  }
  /**
   *
   * @param argLeaveStatus to set leave status.
   */
  public final void setLeaveStatus(final String argLeaveStatus) {
    this.leaveStatus = argLeaveStatus;
  }
  /**
   *@return this leave reason
   */
  public final String getLeaveReason() {
    return leaveReason;
  }
  /**
   *
   * @param argLeaveReason to set leave reason.
   */
  public final void setLeaveReason(final String argLeaveReason) {
    this.leaveReason = argLeaveReason;
  }
  /**
   * @return this leave applied on
   */
  public final String getLeaveAppliedOn() {
    return leaveAppliedOn;
  }
  /**
   *
   * @param argLeaveAppliedOn to set applied.
   */
  public final void setLeaveAppliedOn(final String argLeaveAppliedOn) {
    this.leaveAppliedOn = argLeaveAppliedOn;
  }
  /**
   * @return this manager comments
   */
  public final String getManagerComments() {
    return managerComments;
  }
  /**
   *
   * @param argManagerComments to set manager comments.
   */
  public final void setManagerComments(final String argManagerComments) {
    this.managerComments = argManagerComments;
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
        System.out.println("\n number of days" + diffInDays + "\n");
        status = dao().insertLeaveDetails(leaveType, sDate, eDate, diffInDays, leaveReason, appliedDate, leaveStatus, empId);
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
      if (statusOfEmp.equals(LeaveStatus.PENDING.toString())) {
        statusOfEmp = LeaveStatus.APPROVED.toString();
        int approvedLeaves = leaveBalance - appliedNoOfLeaves;
        dao().updateEmployee(approvedLeaves, argApplyEmpId);
        dao().updateApproveOrDenial(statusOfEmp, argMgrComments, argApplyLeaveId);
        return 1;
      }
    } else if (argApproveStatus.equalsIgnoreCase("deny")) {
      statusOfEmp = LeaveStatus.DENIED.toString();
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
    try {
      Date sDate = Date.valueOf(startDate);
      List<LeaveDetails> lshs = dao().leaveHistory(emID);
      for (LeaveDetails ls : lshs) {
        Date sd = Date.valueOf(ls.getStartDate());
        Date ed = Date.valueOf(ls.getEndDate());
        if (sDate.after(sd) && sDate.before(ed)) {
          return 0;
        }
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
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
    try {
      Date appliedDate = Date.valueOf(java.time.LocalDate.now());
      Date sDate = Date.valueOf(startDate);
      Date eDate = Date.valueOf(endDate);
      diffInDays = dateCheck(sDate, eDate);
      System.out.println("\n number of days" + diffInDays + "\n");
      status = dao().updateLeaveDetails(leaveType, sDate, eDate, diffInDays, leaveStatus, leaveReason, appliedDate, empId, leaveId);
    } catch (Exception e) {
      System.out.println(e.toString());
    }
    return status;
  }
  /**
   * view the employee's details of given id.
   * @param id the id of the employee.
   * @return the employee details
   */
  public static LeaveDetails[] listAl(final int id) {
    List<LeaveDetails> ls = dao().listal(id);
    return ls.toArray(new LeaveDetails[ls.size()]);
  }
  /**
   * view the employee's details of given id.
   * @param agrsEmpId the id of the employee
   * @param argsLeaveId the id of the employee
   * @param reEditStatus the id of the employee
   * @param reEditMgrCmts the id of the employee
   * @return the employee details
   */
  public static int editPermis(final int agrsEmpId, final int argsLeaveId, final String reEditStatus, final String reEditMgrCmts) {
    Employee eStatus = dao().getLeaveBalance(agrsEmpId);
    LeaveDetails lsStatus = dao().checkStatus(argsLeaveId);

    int leaveBalance = eStatus.getEmpLeaveBalance();
    int appliedNoOfLeaves = lsStatus.getNoOfDays();
    try {
      Date sDate = Date.valueOf(lsStatus.getStartDate());
      if(sDate.after(Date.valueOf(java.time.LocalDate.now()))) {
        String editStatus = "";
        int approvedLeaves = 0;
        if(reEditStatus.equalsIgnoreCase("approve")) {
          editStatus = LeaveStatus.APPROVED.toString();
          approvedLeaves = leaveBalance - appliedNoOfLeaves;
        } else if (reEditStatus.equalsIgnoreCase("deny")){
          editStatus = LeaveStatus.DENIED.toString();
          approvedLeaves = leaveBalance + appliedNoOfLeaves;
        } else {
          return -1;
        }
        if (editStatus.equals(lsStatus.getLeaveStatus())) {
          return -1;
        } else {
            dao().updateEmployee(approvedLeaves, agrsEmpId);
            dao().reEditApproveOrDenial(argsLeaveId, editStatus, reEditMgrCmts);
            return 1;
        }
      }
    } catch(Exception e) {
      System.out.println(e.toString());
    }
    return 0;
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
      Date sd = Date.valueOf(l2.getStartDate());
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
