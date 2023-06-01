package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeByAge implements Comparator<Employee> 
{

	@Override
	public int compare(Employee e1, Employee e2) 
	{
		Integer x=e1.getAge(); //21 ->Auto-Boxing
		Integer y=e2.getAge(); //22
		return x.compareTo(y); // 21.compareTo(22) -> -1
	}
	

}
// e1->object to be inserted
//e2 -> already existing object
