//child class of Contractor
public class Sales extends Contractor
{
	double totalSales = 0;
	double raiseBaseSalary = 1.05;//the percentage of the employees raise
	//Inherits the constructor to get the employees information and also tells the employees totalSales.
	public Sales(String name, int SSN, String title, double baseSalary, double totalSales)
	{
		super(name, SSN, title, baseSalary);
		this.totalSales = totalSales;
	}
	//keeps track of the amount the employee sells
	public void sell(double salePrice)
	{
		totalSales += salePrice;
	}
	//pays the employee
	public double payment()
	{
		double pastSales = totalSales;
		totalSales = 0;
		return baseSalary + (pastSales * 0.05);
	}
	//adds the employees annual raise
	public void annualraise()
	{
		baseSalary = raiseBaseSalary * baseSalary;
	}
	//prints the employees information
	public String toString()
	{
		return super.toString();
	}
}
