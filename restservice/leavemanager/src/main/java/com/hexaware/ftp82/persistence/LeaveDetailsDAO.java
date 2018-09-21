package com.hexaware.ftp82.persistence;

import com.hexaware.ftp82.model.LeaveDetails;

//import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for employee.
 */
public interface LeaveDetailsDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM leave_details WHERE LEAVE_STATUS = 'PENDING' ")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> list();

  /**
  * close with no args is used to close the connection.
  */
  void close();
}
