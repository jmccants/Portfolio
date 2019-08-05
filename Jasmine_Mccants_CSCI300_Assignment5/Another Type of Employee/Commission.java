package homework;

public class Commission extends Hourly
{
	protected double totalSales;
	protected double commissionRate;
	
	public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate, int commissionRate)
	{
		super (eName, eAddress, ePhone, socSecNumber, rate);
		this.commissionRate = commissionRate/100;	
	}
	
	public void addSales(double totalSales)
	{
		this.totalSales =+ totalSales;
	}
	
	public double pay()
	{
		double commissionPay = totalSales * commissionRate;
		double pay = super.pay() + commissionPay;
		totalSales = 0;
		return pay;
	}
	
	public String toString()
	{
		return super.toString() + "\nTotal Sales: " + totalSales;
	}
}
