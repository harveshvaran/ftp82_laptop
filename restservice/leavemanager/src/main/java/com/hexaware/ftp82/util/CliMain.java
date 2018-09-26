package com.hexaware.ftp82.util;
import java.util.Scanner;
import com.hexaware.ftp82.model.LeaveDetails;
import com.hexaware.ftp82.model.Employee;
//import com.hexaware.ftp82.model.persistence.EmployeeDAO;
//import com.hexaware.ftp82.model.persistence.LeaveDetailsDAO;
//import java.util.*;
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
    System.out.println("3. Apply for leave !");
    System.out.println("4. Leave history");
    System.out.println("5. Pending Leave Applications");
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
      case 3:
        applyLeave();
        break;
      case 4:
        leaveHistoryDetails();
        break;
      case 5:
        listPendingApplications();
        break;
      case 6:
        acceptOrDeny();
        break;
      case 7:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose either 1 to 6");
    }
    mainMenu();
  }
  /**
   *
   */
  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id: ");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("----There is NO such employee ID-----");
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
  /**
   *
   */
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
   * The main entry point for leave history method.
   */
  private void leaveHistoryDetails() {
    System.out.println("Enter the Employee ID to get the leave History: ");
    int empId = option.nextInt();
    LeaveDetails[] leaveHistory = LeaveDetails.history(empId);
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("\n--------There is NO such employee ID----------\n");
    }
    System.out.println("\n-------------Employee Leave History-----------\n");
    for (LeaveDetails lh : leaveHistory) {
      System.out.print("Employee Id = " + lh.getEmpId() +  " | ");
      System.out.print("Leave ID = " + lh.getLeaveId() +  " | ");
      System.out.print("Leave Type = " + lh.getLeaveType() +  " | ");
      System.out.print("Start Date = " + lh.getStartDate() +  " | ");
      System.out.print("End Date = " + lh.getEndDate() +  " | ");
      System.out.print("Number of days = " + lh.getNumberOfDays() +  " | ");
      System.out.print("Leave Status = " + lh.getLeaveStatus() +  " ");
      System.out.println("\n");
    }
    System.out.println("\n-----------------------------------------------\n");
  }
  /**
   * The main entry point.
   */
  private void listPendingApplications() {
    System.out.println("Enter the Your employee ID:");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      Employee emp = Employee.send(empId);
      if (emp == null) {
        System.out.println("You Are not a MANAGER");
      } else {
        LeaveDetails[] leave = LeaveDetails.listAll(empId);
        if (leave.length == 0) {
          System.out.println("NO PENDING LEAVE FOR NOW");
        }
      }
    }
    LeaveDetails[] leave = LeaveDetails.listAll(empId);
    for (LeaveDetails l : leave) {
      System.out.println("----------------------------------------------");
      System.out.println("PENDING LEAVE APPLICATIONS");
      System.out.println("LeaveID = " + l.getLeaveId() + " ");
      System.out.print("LeaveType = " + l.getLeaveType() + " ");
      System.out.print("StartDate = " + l.getStartDate() + " ");
      System.out.print("EndDate = " + l.getEndDate() + " ");
      System.out.print("Numberofdays = " + l.getNumberOfDays() + " ");
      System.out.print("LeaveStatus = " + l.getLeaveStatus() + " ");
      System.out.print("LeaveReason = " + l.getLeaveReason() + " ");
      System.out.print("LeaveAppliedOn = " + l.getLeaveAppliedOn() + " ");
      System.out.print("ManagerComments = " + l.getManagerComments() + " ");
      System.out.print("EmployeeId = " + l.getEmpId() + " ");
      System.out.println("----------------------------------------------" + "\n");
    }
  }

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
      System.out.println("---------------------------------------------");
      System.out.println("----------------------------------------------" + "\n");
    }
  }
  private void applyLeave() {
    int i = 1;
    System.out.println("Employee Id : ");
    int empId = option.nextInt();
    System.out.println("Start Date : YYYY-MM-DD");
    String startDate = option.next();
    do {
      i = LeaveDetails.dateExpiryOfsdate(startDate);
      if (i == 1) {
        System.out.println("entered date is invalid");
        applyLeave();
      }
    } while (i == 1);
    System.out.println("End Date : YYYY-MM-DD");
    String endDate = option.next();
    do {
      i = LeaveDetails.dateExpiryOfedate(endDate);
      if (i == 0) {
        System.out.println("entered date is invalid");
        applyLeave();
      }
    } while (i == 0);
    System.out.println("Leave Type : ");
    String leaveType = option.next();
    System.out.println("Leave Reason : ");
    String leaveReason = option.next();
    int status = LeaveDetails.applyLeave(empId, leaveType, startDate, endDate, leaveReason);
    if (status > 0) {
      System.out.print("leave applied");
    } else {
      System.out.print("unable to insert record");
    }
  }
  /**
   * The main entry point.
   * @param ar list of arguments
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
