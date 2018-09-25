package com.hexaware.ftp82.persistence;

import com.hexaware.ftp82.model.LeaveDetails;
//import com.hexaware.ftp82.persistence.EmployeeDAO;
//import com.hexaware.ftp82.model.Employee;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for employee.
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
  * close with no args is used to close the connection.
  */
  void close();
}
