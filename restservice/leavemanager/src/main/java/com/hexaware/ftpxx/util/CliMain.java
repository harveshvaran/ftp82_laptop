package com.hexaware.ftpxx.util;
import java.util.Scanner;

import com.hexaware.ftpxx.model.Employee;
import com.hexaware.ftpxx.persistence.EmployeeFactory;

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
    System.out.println("3. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }
  private void mainMenuDetails(final int selectedOption) {
    if (selectedOption == 1) {
      listEmployeesDetails();
    } else if (selectedOption == 2) {
      listEmployeeDetail();
    }
  }
  private void listEmployeeDetail() {
    System.out.println("Enter Your Employee Id");
    int empId = option.nextInt();
    Employee employee = EmployeeFactory.listById(empId);
    System.out.println(employee.getEmpId());
  }
  private void listEmployeesDetails() {
    Employee[] employee = EmployeeFactory.listAll();
    for (Employee e : employee) {
        System.out.println(e.getEmpId());
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
