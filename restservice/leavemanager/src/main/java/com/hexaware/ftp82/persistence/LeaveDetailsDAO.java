package com.hexaware.ftp82.persistence;
//import com.hexaware.ftp82.model.LeaveDetails;
import com.hexaware.ftp82.model.Employee;


import com.hexaware.ftp82.model.LeaveDetails;

//import com.hexaware.ftp82.persistence.EmployeeDAO;
//import com.hexaware.ftp82.model.Employee;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.sql.Date;
//import java.time.LocalDate;
import java.util.List;

/**
 * The DAO class for leave_details.
 */
public interface LeaveDetailsDAO  {
   /**
   * return the leave details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empID")
  @Mapper(LeaveDetailsMapper.class)
  Employee find(@Bind("empID") int empID);
 /**.
   * return the leave details of selected employee
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
  @SqlUpdate("insert into Leave_Details(LEAVE_TYPE, START_DATE, END_DATE, NO_OF_DAYS, LEAVE_REASON, LEAVE_APPLIED_ON, LEAVE_STATUS, EMP_ID) values (:leaveType, :startDate, :endDate, :noOfDays, :leaveReason, :leaveAppliedOn, :leaveStatus, :empId)")
  int insertLeaveDetails(@Bind("leaveType") String leaveType, @Bind("startDate") Date startDate, @Bind("endDate") Date endDate, @Bind("noOfDays") int noOfDays, @Bind("leaveReason") String leaveReason, @Bind("leaveAppliedOn") Date leaveAppliedOn, @Bind("leaveStatus") String leaveStatus, @Bind("empId") int empId);

  /**
   * return all the details of the selected employee.
   * @param id the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM leave_details WHERE LEAVE_STATUS='PENDING' AND EMP_ID IN (SELECT E2.EMP_ID FROM EMPLOYEE E1,EMPLOYEE E2 WHERE E2.EMP_MANAGER_ID=E1.EMP_ID AND E1.EMP_ID= :empId)")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> list(@Bind("empId") int id);
  /**
   * return all the leave history of the current employee.
   * @param empID to check employee leave history.
   * @return the employee array
   */
  @SqlQuery("select * from leave_details where EMP_ID = :empID ")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> leaveHistory(@Bind("empID") int empID);
  /**
  * close with no args is used to close the connection.
  */
  void close();
}
