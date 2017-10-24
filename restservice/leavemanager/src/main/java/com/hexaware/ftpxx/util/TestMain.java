package com.hexaware.ftpxx.util;
import java.util.Scanner;

import com.hexaware.ftpxx.model.Employee;
import com.hexaware.ftpxx.persistence.EmployeeFactory;

public class TestMain
{
	private Scanner option = new Scanner(System.in);

	public void mainMenu() {
		System.out.println("Leave Management System");
		System.out.println("-----------------------");
		System.out.println("1. List All Employees Info");
		System.out.println("2. Display Employee Info");
		System.out.println("3. Exit");
		System.out.println("Enter your choice:");
		int menuOption = option.nextInt();
		mainMenuDetails(menuOption);		

	}
	public void mainMenuDetails(final int selectedOption) {
		if (selectedOption == 1) {
			listEmployeesDetails();
		}
		else if(selectedOption == 2){
			listEmployeeDetail();
		}
		}
	public void listEmployeeDetail()
	{
		System.out.println("Enter Your Employee Id");
		int empId=option.nextInt();
		Employee employee = EmployeeFactory.listById(empId);
		System.out.println(employee.getEmpId());
	}
	public void listEmployeesDetails()
	{
		Employee employee[]=EmployeeFactory.listAll();
        for(Employee e:employee)
        {
            System.out.println(e.getEmpId());
        }
	}
    public static void main(String ar[])
    {
    	final TestMain mainObj = new TestMain();
    	mainObj.mainMenu();
    }
}
