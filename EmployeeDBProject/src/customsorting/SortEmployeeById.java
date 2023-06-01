package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeById implements Comparator<Employee>
{
	@Override
	public int compare(Employee e1, Employee e2)
	{
		String x=e1.getId();  //->Auto-Boxing
		String y=e2.getId();
		return x.compareTo(y);
	}

}
//e1->object to be inserted
//e2 -> already existing object
