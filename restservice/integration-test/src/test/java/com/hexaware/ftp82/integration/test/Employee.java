package com.hexaware.ftp82.integration.test;

import java.util.Objects;
import java.text.SimpleDateFormat;

import com.hexaware.ftp82.integration.test.CommonUtil;
import javax.management.RuntimeErrorException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Employee {
  private int empId;
  private String empName;
  private long empPh;
  private String empEmail;
  private String empDept;
  private int empManagerId;
  private int empLeaveBalance;
  private String empDoj;

    public Employee() {
    }

    public Employee(final int empId) {
      this.empId = empId;
    }
  /**
   * @param empId to initialize employee table details.
   * @param empName to initialize employee table details.
   * @param empPh to initialize employee table details.
   * @param empEmail to initialize employee table details.
   * @param empDept to initialize employee table details.
   * @param empManagerId to initialize employee table details.
   * @param empLeaveBalance to initialize employee table details.
   * @param empDoj to initialize employee table details.
   */
  public Employee(final int empId, final String empName, final long empPh, final String empEmail, final String empDept, final int empManagerId, final int empLeaveBalance, final String empDoj) {
    this.empId = empId;
    this.empName = empName;
    this.empPh = empPh;
    this.empEmail = empEmail;
    this.empDept = empDept;
    this.empManagerId = empManagerId;
    this.empLeaveBalance = empLeaveBalance;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    final String empDoj1 = dateFormat.format(empDoj);
    this.empDoj = empDoj1;
  }

    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId) && Objects.equals(empName, emp.empName)
        && Objects.equals(empPh, emp.empPh) && Objects.equals(empEmail, emp.empEmail)
        && Objects.equals(empDept, emp.empDept) && Objects.equals(empManagerId, emp.empManagerId)
        && Objects.equals(empLeaveBalance, emp.empLeaveBalance) && Objects.equals(empDoj, emp.empDoj)) {
      return true;
    }
    return false;
  }
  /**
   * @return empId employee id.
   * @return empName employee name.
   * @return empPh employee phone number.
   * @return empEmail employee email id.
   * @return empDept department of employee.
   * @return empManagerId employee id of the manager.
   * @return empLeaveBalance leave balance of the employee.
   * @return empDoj date of joining of the employee.
   */
  public final int hashCode() {
    return Objects.hash(empId, empName, empPh, empEmail, empDept, empManagerId, empLeaveBalance, empDoj);
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
   * @param empId to set employee id.
   */
  public final void setEmpId(final int empId) {
    this.empId = empId;
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
   * @param empName to set employee name.
   */
  public final void setEmpName(final String empName) {
    this.empName = empName;
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
   * @param empPh to set employee PhoneNumber.
   */
  public final void setEmpPh(final long empPh) {
    this.empPh = empPh;
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
   * @param empEmail to set employee email.
   */
  public final void setEmpEmail(final String empEmail) {
    this.empEmail = empEmail;
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
   * @param empDept to set employee department.
   */
  public final void setEmpDept(final String empDept) {
    this.empDept = empDept;
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
  public final void setEmpManagerId(final int empManagerId) {
    this.empManagerId = empManagerId;
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
   * @param empLeaveBalance to set employee leave balance.
   */
  public final void setEmpLeaveBalance(final int empLeaveBalance) {
    this.empLeaveBalance = empLeaveBalance;
  }
/**
   * Gets the EmployeeDoj.
   * @return this Employee's Doj.
   */
  public final String getEmpDoj() {
    return empDoj;
  }

  /**
   *
   * @param empDoj to set employee Doj.
   */
  public final void setEmpDoj(final String empDoj) {
    this.empDoj = empDoj;
  }
  public String toString() {
    try {
      ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
      return ow.writeValueAsString(this);
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }
}
