//Maintenance Class 
public class MaintainEmployees
{
	Contractor[] staff;
	int counter = 0;
	//creates and array of 9000 employes
	public MaintainEmployees()
	{
		staff = new Contractor[9000];
	}
	//add employees to the array and also counts how many employees are being added
	public void addEmployee(Contractor newEmployee)
	{
		staff[counter] = newEmployee;
		counter++;
	}
	//pays the employees
	public void payment()
	{
		for(int i = 0; i < counter; i++)
		{
			staff[i].payment();
		}
	}
	// adds the employees annual raise
	public void annualraise()
	{
		for(int i = 0; i < counter; i++)
		{
			staff[i].annualraise();
		}
	}
	//prints the employees information and payment
	public String toString()
	{
		for(int i = 0; i < counter; i ++)
		{
			System.out.print(staff[i]);
			System.out.println(staff[i].payment() + "\n");
		}
		return "";
	}
}
