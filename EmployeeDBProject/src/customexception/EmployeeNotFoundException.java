package customexception;

public class EmployeeNotFoundException extends Exception
{
	private String message;
	public EmployeeNotFoundException(String message)
	{
		this.message=message;
	}
	@Override
	public String getMessage()
	{
		return message;
	}

}
