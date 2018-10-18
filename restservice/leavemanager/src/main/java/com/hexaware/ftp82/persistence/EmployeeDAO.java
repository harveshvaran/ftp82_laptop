package com.hexaware.ftp82.persistence;
import com.hexaware.ftp82.model.Employee;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empID") int empID);
 /**
   * return all the details of the selected employee.
   * @param empId the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM Employee WHERE EMP_ID IN (SELECT E2.EMP_ID FROM EMPLOYEE E1,EMPLOYEE E2 WHERE E2.EMP_MANAGER_ID=E1.EMP_ID AND E1.EMP_ID= :empId);")
  @Mapper(EmployeeMapper.class)
  Employee check(@Bind("empId") int empId);

  /**
   * return all the details of the selected employee.
   * @param empId the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM Employee WHERE EMP_ID = :empId ")
  @Mapper(EmployeeMapper.class)
  Employee getBalance(@Bind("empId") int empId);
  /**
   * return manager Id's.
   * @param mgrId the employee array
   * @return the manager Id
   */
  @SqlQuery("select * from employee where EMP_MANAGER_ID = :mgrId ")
  @Mapper(EmployeeMapper.class)
  List<Employee> displayEmployee(@Bind("mgrId") int mgrId);
  /**
   * return all the details of the selected employee.
   * @param empId the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM Employee WHERE EMP_ID = :empId ")
  @Mapper(EmployeeMapper.class)
  Employee getImage(@Bind("empId") int empId);
  /**
  * close with no args is used to close the connection.
  */
  void close();
}
