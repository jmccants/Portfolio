public class RegularEmployee extends Contractor
{
	double raiseBaseSalary = 1.05;//precentage of the employees raise
	//sets the employees information based of the Contractor class
	public RegularEmployee(String name, int SSN, String title, double baseSalary)
	{
		super(name, SSN, title, baseSalary);
	}
	//pays the employes their award amount based off their title
	public double payment()
	{
		double award = 500.00;
		if(title.toLowerCase().equals("manager"))
		{
			award = 1000.00;
		}
		return baseSalary + award;
	}
	//raises the employees annual raise
	public void annualraise()
	{
		baseSalary = raiseBaseSalary * baseSalary;
	}
	//prints out the employees information
	public String toString()
	{
		return super.toString();
	}
}
