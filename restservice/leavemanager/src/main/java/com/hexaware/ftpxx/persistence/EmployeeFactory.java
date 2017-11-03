package com.hexaware.ftpxx.persistence;

import com.hexaware.ftpxx.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * EmployeeFactory allows you to list all employees, or
 * find by id.
 */

public final class EmployeeFactory {
  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao;
  static {
    DbConnection db = new DbConnection();
    dao = db.getConnect().open(EmployeeDAO.class);
  }
  private EmployeeFactory() { }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {
    List<Employee> es = dao.list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao.find(empID);
  }
}

/**
 * The DAO class for employee.
 */
interface EmployeeDAO  {
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
  * close with no args is used to close the connection.
  */
  void close();
}
