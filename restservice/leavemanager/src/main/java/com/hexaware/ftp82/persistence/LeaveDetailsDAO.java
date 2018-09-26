package com.hexaware.ftp82.persistence;
import com.hexaware.ftp82.model.Employee;
import com.hexaware.ftp82.model.LeaveDetails;
import com.hexaware.ftp82.persistence.EmployeeDAO;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.sql.Date;
import java.util.List;

/**
 * The DAO class for leaveDetails.
 */
public interface LeaveDetailsDAO  {
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
   * return all the details of leavedetails table based on empId and pending status.
   * @param empId the employee array
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM leave_details WHERE LEAVE_STATUS = 'PENDING' && EMP_ID = :empId")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> displayLeaveDetails(@Bind("empId") int empId);
   * update leave balance in employee table.
   * @param empId the employee array
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM leave_details WHERE EMP_ID = :empId")
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
   * close with no args is used to close the connection.
   */
  void close();
}
