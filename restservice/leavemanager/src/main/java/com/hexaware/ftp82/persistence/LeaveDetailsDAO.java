package com.hexaware.ftp82.persistence;
import com.hexaware.ftp82.model.Employee;
import com.hexaware.ftp82.model.LeaveDetails;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
//import org.skife.jdbi.v2.sqlobject.SQLDelete;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.sql.Date;
import java.util.List;

/**
 * The DAO class for leaveDetails.
 */
public interface LeaveDetailsDAO  {
  /**
   * @param empId of the employee
   * @param leaveType of the employee
   * @param startDate of the employee
   * @param endDate of the employee
   * @param noOfDays of the employee
   * @param leaveReason of the employee
   * @param leaveAppliedOn of the employee
   * @param leaveStatus of the employee
   * @return the leave object
   */
  @SqlUpdate("insert into Leave_Details(LEAVE_TYPE, START_DATE, END_DATE, NO_OF_DAYS, LEAVE_REASON,"
      + "LEAVE_APPLIED_ON, LEAVE_STATUS, EMP_ID) values "
      + "(:leaveType, :startDate, :endDate, :noOfDays, :leaveReason, :leaveAppliedOn, :leaveStatus, :empId)")
  int insertLeaveDetails(@Bind("leaveType") String leaveType, @Bind("startDate") Date startDate,
      @Bind("endDate") Date endDate, @Bind("noOfDays") int noOfDays, @Bind("leaveReason") String leaveReason,
      @Bind("leaveAppliedOn") Date leaveAppliedOn, @Bind("leaveStatus") String leaveStatus, @Bind("empId") int empId);
  /**
   * return all the details of the selected employee.
   * @param id the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM leave_details WHERE LEAVE_STATUS='PENDING' AND EMP_ID IN (SELECT E2.EMP_ID FROM EMPLOYEE E1,EMPLOYEE E2 WHERE E2.EMP_MANAGER_ID=E1.EMP_ID AND E1.EMP_ID= :empId)")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> list(@Bind("empId") int id);
  /**
   * return manager Id's from employee table.
   * @param mgrId the manager Id
   * @return the employee array
   */
  @SqlQuery("select * from employee where EMP_MANAGER_ID = :mgrId group by EMP_MANAGER_ID ")
  @Mapper(EmployeeMapper.class)
  Employee check(@Bind("mgrId") int mgrId);
  /**
   * update leave balance in employee table.
   * @param empID the manager Id
   * @return the employee array
   */
  @SqlQuery("select * from leave_details where EMP_ID = :empID ")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> leaveHistory(@Bind("empID") int empID);
  /**
   * update leave balance in employee table.
   * @param empId the manager Id
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM leave_details WHERE EMP_ID = :empId and leave_status = 'PENDING' ")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails checkIdss(@Bind("empId") int empId);
  /**
   * returns details of particular employee Id for leave approval processing.
   * @param empIDForleave the id of the employee
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empIDLeave")
  @Mapper(EmployeeMapper.class)
  Employee getLeaveBalance(@Bind("empIDLeave") int empIDForleave);
  /**
   * return all the details of leaveDetails based on leaveId for leave approval processing.
   * @param leaveId the employee array
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM leave_details WHERE LEAVE_ID = :leaveId")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails getStatus(@Bind("leaveId") int leaveId);
  /**
   * update leave balance in employee table.
   * @param noOfleaves leaveBalance
   * @param empID the employee array
   * @return the employee array
   */
  @SqlUpdate("Update employee set emp_leave_balance = :NoOfLeaves where EMP_ID = :appEmpID")
  int updateEmployee(@Bind("NoOfLeaves")int noOfleaves, @Bind("appEmpID") int empID);
  /**
   * update contents in leavedetails table.
   * @param status the status
   * @param mgrcomments the manager comments
   * @param leaveId the leaveId
   * @return the employee array
   */
  @SqlUpdate("Update leave_details set leave_status = :status , MANAGER_COMMENTS = :mgrcomments where Leave_id = :leaveId")
  int updateApproveOrDenial(@Bind("status")String status, @Bind("mgrcomments") String mgrcomments, @Bind("leaveId") int leaveId);
    /**
   * update contents in leavedetails table.
   * @param leaveType the status
   * @param sDate the start date
   * @param eDate the end date
   * @param diffInDays the no of days
   * @param leaveStatus the leave status
   * @param leaveReason the reason for leave
   * @param appliedDate the leave applied date
   * @param leaveId the leaveId
   * @param empId the employee Id
   * @return the employee array
   */
  @SqlUpdate("Update leave_details set Leave_TYPE = :leaveType, START_DATE = :sDate, END_DATE = :eDate, NO_OF_DAYS = :diffInDays, LEAVE_STATUS = :leaveStatus, LEAVE_REASON = :leaveReason, LEAVE_APPLIED_ON = :appliedDate WHERE LEAVE_ID = :leaveId AND EMP_ID = :empId")
  int updateLeaveDetails(@Bind("leaveType") String leaveType, @Bind("sDate") Date sDate, @Bind("eDate") Date eDate, @Bind("diffInDays") int diffInDays,
        @Bind("leaveStatus") String leaveStatus,  @Bind("leaveReason") String leaveReason, @Bind("appliedDate") Date appliedDate, @Bind("empId") int empId, @Bind("leaveId") int leaveId);
  /**
   * return all the details of the selected employee.
   * @param id the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM leave_details WHERE LEAVE_STATUS!='PENDING' AND START_DATE > CURDATE() AND EMP_ID IN (SELECT E2.EMP_ID FROM EMPLOYEE E1,EMPLOYEE E2 WHERE E2.EMP_MANAGER_ID=E1.EMP_ID AND E1.EMP_ID= :empId)")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> listal(@Bind("empId") int id);
  /**
   * update leave balance in employee table.
   * @param leaveId the manager Id
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM leave_details WHERE LEAVE_ID = :leaveId ")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails checkStatus(@Bind("leaveId") int leaveId);
  /**
   * update contents in leavedetails table.
   * @param status the status
   * @param mgrcomments the manager comments
   * @param leaveId the leaveId
   * @return the employee array
   */
  @SqlUpdate("Update leave_details set leave_status = :status , MANAGER_COMMENTS = :mgrcomments where Leave_id = :leaveId")
  int reEditApproveOrDenial(@Bind("leaveId") int leaveId, @Bind("status")String status, @Bind("mgrcomments") String mgrcomments);
  /**
   * update contents in leavedetails table.
   * @param leaveId the status
   * @return leaveId the status
   */
  @SqlUpdate("DELETE FROM LEAVE_DETAILS WHERE LEAVE_ID = :leaveId")
  int deleteLeaveRequest(@Bind("leaveId") final int leaveId);
  /**
  * close with no args is used to close the connection.
  */
  void close();
}
