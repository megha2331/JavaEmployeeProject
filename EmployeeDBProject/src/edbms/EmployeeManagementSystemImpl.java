package edbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.EmployeeNotFoundException;
import customexception.InvalidChoiceException;
import customsorting.SortEmployeeByAge;
import customsorting.SortEmployeeById;
import customsorting.SortEmployeeByName;
import customsorting.SortEmployeeBySalary;


public class EmployeeManagementSystemImpl implements EmployeeManagementSystem 
{
	Scanner sc=new Scanner(System.in);

	Map<String,Employee> db=new LinkedHashMap<String, Employee>();


	@Override
	public void addEmployee()
	{
		System.out.println("Enter Employee Name");
		String name=sc.next();
		System.out.println("Enter Employee Age");
		int age=sc.nextInt();
		System.out.println("Enter Employee Salary");
		double salary=sc.nextDouble();

		Employee emp=new Employee(name,age,salary);
		db.put(emp.getId(), emp);
		System.out.println("Employee Records Inserted Successfully");
		System.out.println("Employee Id is: "+emp.getId());

	}
	@Override
	public void displayEmployee()
	{
		System.out.println("Enter Employee Id");
		String id=sc.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			Employee emp=db.get(id);
			System.out.println("Employee Details are Follows: ");
			System.out.println("Employee Id is: "+emp.getId());
			System.out.println("Employee Name is: "+emp.getName());
			System.out.println("Employee Age is: "+emp.getAge());
			System.out.println("EMployee Salary is: "+emp.getSalary());

		}
		else
		{
			try
			{
				String message="Employee with the id "+id+" is not Found!!";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e)
			{
				System.out.println(e.getMessage());
			}

		}

	}
	@Override
	public void displayAllEmployees()
	{
		if(db.size()!=0)
		{
			System.out.println("Employee Details are Follows");
			System.out.println("*****************************");
			Set<String> keys=db.keySet();
			for(String key:keys)
			{
				Employee emp=db.get(key);
				System.out.println(emp);
			}
		}
		else
		{
			try
			{
				String message="Employee DataBase is Empty Nothing to Display";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e)
			{
				e.getMessage();
			}

		}

	}
	@Override
	public void removeEmployee()
	{
		System.out.println("Enter Employee id");
		String id=sc.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Employee Record Found!!");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Employee Record Deleted Successfully!");
		}
		else
		{
			try
			{
				String message="Employee with the id"+id+"is not Found!";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e)
			{
				e.getMessage();
			}

		}

	}
	@Override
	public void removeAllEmployees()
	{
		if(db.size()!=0)
		{
			System.out.println("Available Employee Records: "+db.size());
			db.clear();
			System.out.println("All the Employees Records Deleted Successfully!");
		}
		else
		{
			try
			{
				String message="Employee Database is Empty, Nothing to Deleted";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e)
			{
				e.getMessage();
			}
		}

	}
	@Override
	public void updateEmployee()
	{
		System.out.println("Enter Employee Id");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id))
		{
			Employee emp=db.get(id);
			System.out.println("1:Update Name\n2:Update Age\n3:Update Salary");
			System.out.println("Enter Choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1: 
				System.out.println("Enter Employee Name:");
				String name=sc.next();
				emp.setName(name);
				System.out.println("Name Update Successfully");
				break;

			case 2:
				System.out.println("Enter Employee Age:");
				int age=sc.nextInt();
				emp.setAge(age);
				System.out.println("Age Updated Successfully");
				break;

			case 3:
				System.out.println("Enter Employee Salary:");
				double salary=sc.nextDouble();
				emp.setSalary(salary);
				System.out.println("Salary Updated Successfully");
				break;
			default:
				try
				{
					throw new InvalidChoiceException("Invalid Choice");
				}
				catch(InvalidChoiceException i)
				{
					System.out.println(i.getMessage());				
				}
			}
		}
		else
		{
			try
			{
				String message="Employee Database is Empty, Nothing to Update";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException s)
			{
				System.out.println(s.getMessage());
			}
		}

	}
	@Override
	public void countEmployees()
	{
		System.out.println("Number of Employees Records "+db.size());

	}
	@Override
	public void sortEmployees()
	{
		if(db.size()>=2)
		{
			List<Employee> list=new ArrayList<Employee>();
			Set<String> keys=db.keySet();
			for(String key:keys)
			{
				list.add(db.get(key));
			}
			System.out.println("1:Sort Employee By Id\n2:Sort Employee By Name");
			System.out.println("3:Sort Employee By Age\n4:Sort Employee By Salary");
			System.out.println("Enter Choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				Collections.sort(list,new SortEmployeeById());
				display(list);
				break;

			case 2:
				Collections.sort(list,new SortEmployeeByName());
				display(list);
				break;
			case 3:
				Collections.sort(list,new SortEmployeeByAge());
				display(list);
				break;
			case 4:
				Collections.sort(list,new SortEmployeeBySalary());
				display(list);
				break;

			default:
				try
				{
					String message="Invalid Choice!, Kindly Enter Valid Choice";
					throw new InvalidChoiceException(message);
				}
				catch(InvalidChoiceException i)
				{
					System.out.println(i.getMessage());
				}

			}

		}
		else
		{
			try
			{
				String message="No Sufficient Employee Records to Sort!!";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}

	}
	private static void display(List<Employee> list)
	{
		for(Employee e:list)
		{
			System.out.println(e);
		}
	}
	@Override
	public void getEmployeeWithHighestSalary() 
	{
		if(db.size()>=2)
		{
			List<Employee> list=new ArrayList<Employee>();
			Set<String> keys=db.keySet();
			for(String key:keys)
			{
				list.add(db.get(key));
			}
			Collections.sort(list,new SortEmployeeBySalary());
			System.out.println(list.get(list.size()-1));

		}
		else
		{
			try
			{
			String message="No Sufficient Employee Records to Compare";
			throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void getEmployeeWithLowestSalary()
	{
		if(db.size()>=2)
		{
			List<Employee> list=new ArrayList<Employee>();
			Set<String> keys=db.keySet();
			for(String key:keys)
			{
				list.add(db.get(key));
			}
			Collections.sort(list,new SortEmployeeBySalary());
			System.out.println(list.get(0));
		}
		else
		{
			try
			{
			String message="No Sufficient Employee Records to Comapre";
			throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}

	}

}
