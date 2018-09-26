package com.hexaware.ftp82.util;
import com.hexaware.ftp82.model.LeaveDetails;
import com.hexaware.ftp82.model.Employee;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
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
        System.out.println("Choose either 1, 2 or 3");
    }
    mainMenu();
  }
  /**
   *
   */
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
   * The main entry point.
   */
  private void listPendingApplications() {
    System.out.println("Enter the Your employee ID:");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    LeaveDetails[] leave = LeaveDetails.listAll(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      Employee emp = Employee.send(empId);
      if (emp == null) {
        System.out.println("You Are not a MANAGER");
      } else {
        if (leave.length == 0) {
          System.out.println("NO PENDING LEAVE FOR NOW");
        } else {
          List hs = new ArrayList();
          for (LeaveDetails l : leave) {
            hs.add(Employee.getLeaveBalance(l.getEmpId()));
          }
          ListIterator ii = hs.listIterator();
          System.out.println("\n--------------------------------------------------------PENDING LEAVE APPLICATIONS-------------------------------------------------\n");
          for (LeaveDetails l : leave) {
            System.out.print("EmployeeId = " + l.getEmpId() + " ");
            System.out.println("LeaveID = " + l.getLeaveId() + " ");
            System.out.print("LeaveType = " + l.getLeaveType() + " ");
            System.out.print("StartDate = " + l.getStartDate() + " ");
            System.out.print("EndDate = " + l.getEndDate() + " ");
            System.out.print("Numberofdays = " + l.getNumberOfDays() + " ");
            System.out.print("LeaveStatus = " + l.getLeaveStatus() + " ");
            System.out.print("LeaveReason = " + l.getLeaveReason() + " ");
            System.out.print("LeaveAppliedOn = " + l.getLeaveAppliedOn() + " ");
            System.out.print("Employee Leave Balance  = " + ii.next() + " ");
            System.out.print("ManagerComments = " + l.getManagerComments() + "\n\n");
          }
          System.out.println("--------------------------------------------------------------------------------------------------------------------------------------" + "\n");
        }
      }
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
   */
  private void acceptOrDeny() {
    LeaveDetails ls = new LeaveDetails();
    System.out.println("Enter Employee ID: ");
    int applyEmpId = option.nextInt();
    System.out.println("Enter Leave ID: ");
    int applyLeaveId = option.nextInt();
    System.out.println("Enter Comments ");
    String applyMgrComments = option.nextLine();
    System.out.println("Approve / Deny ");
    String approveStatus = option.next();
    int applyStatus = ls.applyLeave(applyEmpId, applyLeaveId, applyMgrComments, approveStatus);
    switch (applyStatus) {
      case 1:
        System.out.println("Leave approved !");
        break;
      case 100:
        System.out.println("Leave approval Denied !");
        break;
      case 102:
        System.out.println("Leave process completed !");
        break;
      case 103:
        System.out.println("process unsuccessful ! ");
        break;
      default:
        System.out.println("process unsuccessful !");
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
