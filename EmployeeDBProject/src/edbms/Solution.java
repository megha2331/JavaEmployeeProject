package edbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("Welcome to Employee DB Management System");
		System.out.println("***************************************");

		EmployeeManagementSystem ems=new EmployeeManagementSystemImpl();

		while(true)
		{
			System.out.println("1:Add Employee\n2:Display Employee\n3:Display All Employee\n4:Remove Employee\n5:Remove all Employee");
			System.out.println("6:Update Employee\n7:Count Employees\n8:sort Employees\n9:Get Employee with Highest Salary\n10:Get Employee with Lowest Salary\n11:Exit\nEnter Choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1: 
				ems.addEmployee();
				break;

			case 2:
				ems.displayEmployee();
				break;

			case 3:
				ems.displayAllEmployees();
				break;

			case 4:
				ems.removeEmployee();
				break;

			case 5:
				ems.removeAllEmployees();
				break;

			case 6:
				ems.updateEmployee();
				break;

			case 7:
				ems.countEmployees();
				break;

			case 8:
				ems.sortEmployees();
				break;

			case 9:
				ems.getEmployeeWithHighestSalary();
				break;

			case 10:
				ems.getEmployeeWithLowestSalary();
				break;

			case 11:
				System.out.println("Thank You!!");
				System.exit(0);
				break;

			default:
				try
				{ 
					throw new InvalidChoiceException("Invalid choice");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}

			} //end of switch
			System.out.println("*******************************************");

		}

	}
}

