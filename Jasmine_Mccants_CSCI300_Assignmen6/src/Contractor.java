//Parent class of employees
public class Contractor
{
	String name, title;
	int SSN;
	double baseSalary;
	double raiseBaseSalary = 1.03; //percentage added to baseSalary
	public Contractor(String name, int SSN, String title, double baseSalary)
	{
		this.name = name;
		this.title = title;
		this.SSN = SSN;
		this.baseSalary = baseSalary;
	}
	//payment method
	public double payment()
	{
		return baseSalary;
	}
	//raises the baseSalary 
	public void annualraise()
	{
		baseSalary = raiseBaseSalary * baseSalary;
	}
	//prints the Employees information
	public String toString()
	{
		return "Employee: " + name + "\nTitle: " + title + "\nSSN: " + SSN + "\n";
	}
}
