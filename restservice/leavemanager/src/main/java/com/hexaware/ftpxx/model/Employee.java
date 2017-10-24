package com.hexaware.ftpxx.model;

import java.util.Objects;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

    /**
     * empId to store employee id.
     */
    private int empId;

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
      return false;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(empId);
    }

    /**
     * default constructor Employee.
     */
    public Employee() {
    }


    /**
     * @param argEmpId to initialize employee id.
     */
    public Employee(final int argEmpId) {
        this.empId = argEmpId;
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
}
