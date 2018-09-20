package com.hexaware.ftp82.util;
import java.util.Scanner;

import com.hexaware.ftp82.model.Employee;

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
    System.out.println("3. Leave Details");
    System.out.println("5. Pending Leave Applications");
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
      case 3:
        applyLeave();
        break;
      case 5:
        listPendingApplicatons();
        break;
      case 3:
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
  private void applyLeave() {
    LeaveDetails ls=new LeaveDetails();
    ls.applyforleave();
  }
  private void listPendingApplications() {
    
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
