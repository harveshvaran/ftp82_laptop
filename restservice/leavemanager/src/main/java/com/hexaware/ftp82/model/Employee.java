package com.hexaware.ftp82.model;

import com.hexaware.ftp82.persistence.DbConnection;
import com.hexaware.ftp82.persistence.EmployeeDAO;

import java.util.Objects;
import java.util.List;
import java.util.Date;
/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   * empName to store employee name.
   * empPh to store employee phone number.
   * empEmail to store employee Email.
   * empDept to store employee Dept.
   * empManagerId to store employee managerid.
   * empLeaveBalance to store employee leavebalance.
   * empDoj to store employee doj.
   */
  private int empId;
  private String empName;
  private long empPh;
  private String empEmail;
  private String empDept;
  private int empManagerId;
  private int empLeaveBalance;
  private Date empDoj;
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)) {
      return true;
    }
    if (Objects.equals(empName, emp.empName)) {
      return true;
    }
    if (Objects.equals(empPh, emp.empPh)) {
      return true;
    }
    if (Objects.equals(empEmail, emp.empEmail)) {
      return true;
    }
    if (Objects.equals(empDept, emp.empDept)) {
      return true;
    }
    if (Objects.equals(empManagerId, emp.empManagerId)) {
      return true;
    }
    if (Objects.equals(empLeaveBalance, emp.empLeaveBalance)) {
      return true;
    }
    if (Objects.equals(empDoj, emp.empDoj)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empName, empPh, empEmail, empDept, empManagerId, empLeaveBalance, empDoj);
  }
  /**
   *
   */
  public Employee() { }
  /**
   * @param argEmpId to initialize employee id.
   */
  public Employee(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * @param argEmpId to initialize employee table details.
   * @param argEmpName to initialize employee table details.
   * @param argEmpPh to initialize employee table details.
   * @param argEmpEmail to initialize employee table details.
   * @param argEmpDept to initialize employee table details.
   * @param argEmpManagerId to initialize employee table details.
   * @param argEmpLeaveBalance to initialize employee table details.
   * @param argEmpDoj to initialize employee table details.
   */
  public Employee(final int argEmpId, final String argEmpName, final long argEmpPh, final String argEmpEmail, final String argEmpDept, final int argEmpManagerId, final int argEmpLeaveBalance, final Date argEmpDoj) {
    this.empId = argEmpId;
    this.empName = argEmpName;
    this.empPh = argEmpPh;
    this.empEmail = argEmpEmail;
    this.empDept = argEmpDept;
    this.empManagerId = argEmpManagerId;
    this.empLeaveBalance = argEmpLeaveBalance;
    this.empDoj = argEmpDoj;
  }
  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
 /**
   * Gets the Employeename.
   * @return this Employee's name.
   */
  public final String getEmpName() {
    return empName;
  }

  /**
   *
   * @param argEmpName to set employee name.
   */
  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }
  /**
   * Gets the EmployeePhoneNumber.
   * @return this Employee's PhoneNumber.
   */
  public final long getEmpPh() {
    return empPh;
  }

  /**
   *
   * @param argEmpPh to set employee PhoneNumber.
   */
  public final void setEmpPh(final long argEmpPh) {
    this.empPh = argEmpPh;
  }
  /**
   * Gets the EmployeeEmail.
   * @return this Employee's Email.
   */
  public final String getEmpEmail() {
    return empEmail;
  }

  /**
   *
   * @param argEmpEmail to set employee email.
   */
  public final void setEmpEmail(final String argEmpEmail) {
    this.empEmail = argEmpEmail;
  }
  /**
   * Gets the Employeedepartment.
   * @return this Employee's department.
   */
  public final String getEmpDept() {
    return empDept;
  }
  /**
   *
   * @param argEmpDept to set employee department.
   */
  public final void setEmpDept(final String argEmpDept) {
    this.empDept = argEmpDept;
  }
  /**
   * Gets the EmployeeManagerId.
   * @return this Employee's ManagerID.
   */
  public final int getEmpManagerId() {
    return empManagerId;
  }
  /**
   *
   * @param argEmpManagerId to set employee ManagerId.
   */
  public final void setEmpManagerId(final int argEmpManagerId) {
    this.empManagerId = argEmpManagerId;
  }
  /**
   * Gets the EmployeeLeaveBalance.
   * @return this Employee's LeaveBalance.
   */
  public final int getEmpLeaveBalance() {
    return empLeaveBalance;
  }

  /**
   *
   * @param argEmpLeaveBalance to set employee leave balance.
   */
  public final void setEmpLeaveBalance(final int argEmpLeaveBalance) {
    this.empLeaveBalance = argEmpLeaveBalance;
  }
/**
   * Gets the EmployeeDoj.
   * @return this Employee's Doj.
   */
  public final Date getEmpDoj() {
    return empDoj;
  }

  /**
   *
   * @param argEmpDoj to set employee Doj.
   */
  public final void setEmpDoj(final Date argEmpDoj) {
    this.empDoj = argEmpDoj;
  }
  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }
   /**
   * list employee details by id.
   * @param id to get employee details.
   * @return Employee
   */
  public static Employee send(final int id) {
    return dao().check(id);
  }
  /**
   * list employee details by id.
   * @param id to get employee details.
   * @return Employee
   */
  public static Employee getLeaveBalance(final int id) {
    return dao().get(id);
  }
}
