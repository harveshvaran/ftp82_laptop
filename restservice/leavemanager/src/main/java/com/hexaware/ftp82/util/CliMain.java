package com.hexaware.ftp82.util;
import java.util.Scanner;

import com.hexaware.ftp82.model.Employee;
import com.hexaware.ftp82.model.LeaveDetails;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Leave detail");
    System.out.println("6. Apply / Deny leave");
    System.out.println("7. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }
  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 6:
        acceptOrDeny();
        break;
      case 7:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose either 1, 2 or 3");
    }
    mainMenu();
  }
  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.println("----------------------------------------------");
      System.out.println("Employee ID = " + employee.getEmpId() + "\n");
      System.out.print("Employee Name = " + employee.getEmpName() + "\n");
      System.out.print("Employee Phone number = " + employee.getEmpPh() + "\n");
      System.out.print("Employee Email ID = " + employee.getEmpEmail() + "\n");
      System.out.print("Employee Department = " + employee.getEmpDept() + "\n");
      System.out.print("Employee Manager ID = " + employee.getEmpManagerId() + "\n");
      System.out.print("Employee Leave Balance = " + employee.getEmpLeaveBalance() + "\n");
      System.out.print("Employee Date of Joining = " + employee.getEmpDoj() + "\n");
    }
  }
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    for (Employee e : employee) {
      System.out.println("----------------------------------------------");
      System.out.println("Employee ID = " + e.getEmpId() + "\n");
      System.out.print("Employee Name = " + e.getEmpName() + "\n");
      System.out.print("Employee Phone number = " + e.getEmpPh() + "\n");
      System.out.print("Employee Email ID = " + e.getEmpEmail() + "\n");
      System.out.print("Employee Department = " + e.getEmpDept() + "\n");
      System.out.print("Employee Manager ID = " + e.getEmpManagerId() + "\n");
      System.out.print("Employee Leave Balance = " + e.getEmpLeaveBalance() + "\n");
      System.out.print("Employee Date of Joining = " + e.getEmpDoj() + "\n");
    }
  }
  /**
   * The main entry point.
   */
  private void acceptOrDeny() {
    LeaveDetails[] leave = LeaveDetails.listAll();
    for (LeaveDetails l : leave) {
      System.out.println("----------------------------------------------");
      System.out.println("Leave ID = " + l.getLeaveId() + " ");
      System.out.print("Leave Type = " + l.getLeaveType() + " ");
      System.out.print("Start Date = " + l.getStartDate() + " ");
      System.out.print("End Date = " + l.getEndDate() + " ");
      System.out.print("Number of days = " + l.getNumberOfDays() + " ");
      System.out.print("Leave Status = " + l.getLeaveStatus() + " ");
      System.out.print("Leave reason = " + l.getLeaveReason() + " ");
      System.out.print("Leave Applied On = " + l.getLeaveAppliedOn() + " ");
      System.out.print("Manager Comments = " + l.getManagerComments() + " ");
      System.out.print("Employee Id = " + l.getEmpId() + " ");
      System.out.println("----------------------------------------------" + "\n");
    }
  }
  /**
   * The main entry point.
   * @param ar the list of arguments
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
