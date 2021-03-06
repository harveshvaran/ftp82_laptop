package com.hexaware.ftp82.util;
import com.hexaware.ftp82.model.LeaveDetails;
import com.hexaware.ftp82.model.Employee;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import java.sql.Date;
/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
  private void mainMenu() {
    System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("\nLEAVE MANAGEMENT SYSTEM");
    System.out.println("\n");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply for leave !");
    System.out.println("4. Leave history");
    System.out.println("5. Pending Leave Applications");
    System.out.println("6. Apply / Deny leave");
    System.out.println("7. View Employee Image");
    System.out.println("8. Update exsisting leave");
    System.out.println("9. delete the leave request");
    System.out.println("10. Exit");
    System.out.println(Date.valueOf(java.time.LocalDate.now()));
    System.out.println("-----------------------");
    System.out.println("Enter your choice:");
    int menuOption = 0;
    do {
      menuOption = getInteger();
    } while (menuOption == 0);
    mainMenuDetails(menuOption);
  }
  /**
   * The main entry point.
   * @param selectedOption the list of arguments
   */
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
        disEmpImage();
        break;
      case 8:
        updateLeave();
        break;
      case 9:
        deleteLeave();
        break;
      case 10:
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
    System.out.println("Enter an Employee Id");
    int empId = 0;
    do {
      empId = getInteger();
    } while (empId == 0);
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("\n----------------------------------------------------SORRY!!!!There is NO such employee ID-------------------------------------------------");
    } else {
      System.out.println("\n---------------------------------------------------------------EMPLOYEE DETAIL-------------------------------------------------------------");
      System.out.println("\n");
      System.out.print("Employee ID = " + employee.getEmpId() + " | ");
      System.out.print("Employee Name = " + employee.getEmpName() + " | ");
      System.out.print("Employee Phone number = " + employee.getEmpPh() + " | ");
      System.out.print("Employee Email ID = " + employee.getEmpEmail() + " | ");
      System.out.print("Employee Department = " + employee.getEmpDept() + " | ");
      System.out.print("Employee Manager ID = " + employee.getEmpManagerId() + " | ");
      System.out.print("Employee Leave Balance = " + employee.getEmpLeaveBalance() + " | ");
      System.out.print("Employee Date of Joining = " + employee.getEmpDoj() + " ");
      System.out.println("\n");
    }
  }
  /**
   *
   */
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    System.out.println("\n--------------------------------------------------------------------EMPLOYEES INFORMATION---------------------------------------------------");
    for (Employee e : employee) {
      System.out.println("\n");
      System.out.print("Employee ID = " + e.getEmpId() + " | ");
      System.out.print("Employee Name = " + e.getEmpName() + " | ");
      System.out.print("Employee Phone number = " + e.getEmpPh() + " | ");
      System.out.print("Employee Email ID = " + e.getEmpEmail() + " | ");
      System.out.print("Employee Department = " + e.getEmpDept() + " | ");
      System.out.print("Employee Manager ID = " + e.getEmpManagerId() + " | ");
      System.out.print("Employee Leave Balance = " + e.getEmpLeaveBalance() + " | ");
      System.out.print("Employee Date of Joining = " + e.getEmpDoj() + " ");
      System.out.println("\n");
    }
    System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------\n");
  }
 /**
  * The main entry point for leave history method.
  */
  private void applyLeave() {
    int i = 1;
    System.out.println("Employee Id : ");
    int empId = 0;
    int overlap = 0;
    do {
      empId = getInteger();
    } while (empId == 0);
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
      i = LeaveDetails.dateExpiryOfedate(endDate, startDate);
      if (i == 0) {
        System.out.println("entered date is invalid");
        applyLeave();
      }
    } while (i == 0);
    overlap = LeaveDetails.overLapCheck(startDate, empId);
    if  (overlap == 1) {
      System.out.println("LEAVE TYPE : 1.Earned/Privileged Leave(EL)  2.Sick Leave(SL)  3.Maternity/Paternity Leave(MPL) ");
      String leaveType = option.next();
      System.out.println("LEAVE REASON : ");
      String leaveReason = option.next();
      int status = LeaveDetails.applyLeave(empId, leaveType, startDate, endDate, leaveReason);
      if (status > 0) {
        System.out.print("leave applied");
      //Employee.sendMail(empId);
      } else {
      System.out.print("<<<<<<<<<<<<<<<< UNABLE TO APPLY FOR LEAVE >>>>>>>>>>>>>>>>>>>\n");
      }
    } else {
      System.out.println("\n <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<----Dates are overlaping !..PLEASE try again----->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      mainMenu();
    }
  }
   /**
   * The main entry point for leave history method.
   */
  private void leaveHistoryDetails() {
    System.out.println("Enter the Employee ID to get the leave History: ");
    int empId = 0;
    do {
      empId = getInteger();
    } while (empId == 0);
    LeaveDetails[] leaveHistory = LeaveDetails.history(empId);
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("\n---------------------------------------------SORRY!!!..There is NO such employee ID------------------------------------------------\n");
    }
    System.out.println("\n---------------------------------------------------EMPLOYEE LEAVE HISTORY------------------------------------------------------------\n");
    for (LeaveDetails lh : leaveHistory) {
      System.out.print("Employee Id = " + lh.getEmpId() +  " | ");
      System.out.print("Leave ID = " + lh.getLeaveId() +  " | ");
      System.out.print("Leave Type = " + lh.getLeaveType() +  " | ");
      System.out.print("Start Date = " + lh.getStartDate() +  " | ");
      System.out.print("End Date = " + lh.getEndDate() +  " | ");
      System.out.print("Number of days = " + lh.getNoOfDays() +  " | ");
      System.out.print("Leave Status = " + lh.getLeaveStatus() +  " ");
      System.out.println("\n");
    }
    System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------\n");
  }
  /**
   * The main entry point.
   */
  private void listPendingApplications() {
    System.out.println("Enter the Your employee ID:");
    int empId = 0;
    do {
      empId = getInteger();
    } while (empId == 0);
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
            System.out.print("EmployeeId = " + l.getEmpId() + " | ");
            System.out.println("LeaveID = " + l.getLeaveId() + " | ");
            System.out.print("LeaveType = " + l.getLeaveType() + " | ");
            System.out.print("StartDate = " + l.getStartDate() + " | ");
            System.out.print("EndDate = " + l.getEndDate() + " | ");
            System.out.print("Numberofdays = " + l.getNoOfDays() + " | ");
            System.out.print("LeaveStatus = " + l.getLeaveStatus() + " | ");
            System.out.print("LeaveReason = " + l.getLeaveReason() + " | ");
            System.out.print("LeaveAppliedOn = " + l.getLeaveAppliedOn() + " | ");
            System.out.print("Employee Leave Balance  = " + ii.next() + " | ");
            System.out.print("ManagerComments = " + l.getManagerComments() + "\n\n");
          }
          System.out.print("\n--------------------------------------------------------------------------------------------------------------------------------------" + "\n");
        }
      }
    }
  }
  /**
   * The main entry point.
   */
  private void acceptOrDeny() {
    LeaveDetails ls = new LeaveDetails();
    System.out.println("Enter Employee ID: ");
    int applyEmpId = 0;
    do {
      applyEmpId = getInteger();
    } while (applyEmpId == 0);
    System.out.println("Enter Leave ID: ");
    int applyLeaveId = 0;
    do {
      applyLeaveId = getInteger();
    } while (applyLeaveId == 0);
    System.out.println("Enter Comments: ");
    String applyMgrComments = option.nextLine();
    System.out.println("Approve / Deny: ");
    String approveStatus = option.nextLine();
    //System.out.println(LeaveDetails.checkIds(applyEmpId, applyLeaveId));
    if (LeaveDetails.checkIds(applyEmpId, applyLeaveId) == 1) {
      int applyStatus = ls.applyForLeave(applyEmpId, applyLeaveId, applyMgrComments, approveStatus);
      switch (applyStatus) {
        case 1:
          System.out.println("Leave approved !");
          break;
        case 100:
          System.out.println("Leave approval Denied !");
          break;
        case 101:
          System.out.println("Leave cannot be processed !");
          break;
        default:
          System.out.println("process unsuccessful !");
      }
    } else {
      System.out.println("Enter corresponding Employee Id and leave ID ");
    }
  }
  /**
   * The main entry point.
   * @return the list of arguments
   */
  private int getInteger() {
    try {
      String msg = option.next();
      int num = Integer.parseInt(msg);
      return num;
    } catch (Exception e) {
      System.out.println("Enter integer !");
    }
    return 0;
  }
  /**
  * The main entry point for updateLeave method.
  */
  private void updateLeave() {
    int i = 1;
    System.out.println("Employee Id : ");
    int empID = 0;
    do {
      empID = getInteger();
    } while (empID == 0);
    System.out.println("Leave Id : ");
    int leaveId = option.nextInt();
    System.out.println("Start Date : YYYY-MM-DD");
    String sDate = option.next();
    do {
      i = LeaveDetails.dateExpiryOfsdate(sDate);
      if (i == 1) {
        System.out.println("entered date is invalid");
        applyLeave();
      }
    } while (i == 1);
    System.out.println("End Date : YYYY-MM-DD");
    String eDate = option.next();
    do {
      i = LeaveDetails.dateExpiryOfedate(eDate, sDate);
      if (i == 0) {
        System.out.println("entered date is invalid");
        applyLeave();
      }
    } while (i == 0);
    System.out.println(" LEAVE TYPE : 1.Earned/Privileged Leave(EL)  2.Sick Leave(SL)  3.Maternity/Paternity Leave(MPL) ");
    String lType = option.next();
    System.out.println("LEAVE REASON : ");
    String lReason = option.next();
    int status = LeaveDetails.editLeave(empID, lType, sDate, eDate, lReason, leaveId);
    if (status > 0) {
      System.out.print("\n LEAVE APPLIED ");
    } else {
      System.out.print("\n UNABLE TO INSERT RECORD ");
    }
    mainMenu();
  }
  private void deleteLeave() {
    System.out.println("Enter the leaveId:");
    int leaveId = getInteger();
    System.out.println("Enter the Employee ID:");
    int empId = getInteger();
    int res = LeaveDetails.removeLeaveRequest(leaveId, empId);
    if (res > 0) {
      System.out.println("deleted sucessfully");
    } else {
      System.out.println("error occured during deletion try again");
    }
  }
  /**
   * The main entry point.
   * @return the list of arguments
   */
  public void disEmpImage() {
    System.out.println("Enter Employee ID: ");
    int applyEmpId = 0;
    do {
      applyEmpId = getInteger();
    } while (applyEmpId == 0);
    System.out.println(Employee.displayEmpImage(applyEmpId));
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
