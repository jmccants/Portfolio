//Driver class to test the methods
public class Assignment6Driver 
{
	public static void main(String[] args)
	{
		//creates the staff array
		MaintainEmployees staff = new MaintainEmployees();
		
		//test all methods
		staff.addEmployee(new RegularEmployee("Jazz", 1232324567, "manager", 100));
		staff.addEmployee(new Contractor("Mikey", 928098234, "Manager", 100));
		staff.addEmployee(new Sales("Cliff", 958473625, "manager", 100, 150));
		staff.addEmployee(new RegularEmployee("Woody", 958473625, "Manager", 100));
		staff.addEmployee(new RegularEmployee("Clara", 987654321, "regular", 100));
		staff.annualraise();
		staff.payment();
		staff.toString();
	}
}
