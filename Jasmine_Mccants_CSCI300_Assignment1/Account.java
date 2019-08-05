package homework;
import java.util.Random;
import java.util.Scanner;
	//************************************************************
	// Account.java
	//
	// A bank account class with methods to deposit to, withdraw from,
	// change the name on, and get a String representation
	// of the account.
	//************************************************************
	public class Account
	{
	Random rand = new Random();
	private double balance;
	private String name;
	private long acctNum;
	private static int numAccounts = 0;
	//-------------------------------------------------
	//Constructor -- initializes balance, owner, and account number
	//-------------------------------------------------
	public Account(double initBal, String owner, long number)
	{
		numAccounts++;
		balance = initBal;
		name = owner;
		acctNum = number;
	}
	public Account(double initBal, String owner)
	{
		numAccounts++;
		balance = initBal;
		name = owner;
		acctNum = rand.nextInt(317);
	}
	public Account(String owner)
	{
		numAccounts++;
		name = owner;
		balance = 0;
		acctNum = rand.nextInt(317);
	}
	//-------------------------------------------------
	// Checks to see if balance is sufficient for withdrawal.
	// If so, decrements balance by amount; if not, prints message.
	//-------------------------------------------------
	public void withdraw(double amount)
	{
		if (balance >= amount)
			balance -= amount;
		else
			System.out.println("Insufficient funds");
	}
	public void withdraw(double amount, double fee)
	{
		if(balance >= amount)
		{
			balance -= amount;
			fee -= amount;
		}
		else
		{
			System.out.println("Insufficient funds");
		}
	}
	//-------------------------------------------------
	// Adds deposit amount to balance.
	//-------------------------------------------------
	public void deposit(double amount)
	{
		balance += amount;
	}
	//-------------------------------------------------
	// Returns balance.
	//-------------------------------------------------
	public double getBalance()
	{
		return balance;
	}	//------------------------------------------------
	//Returns number of accounts.
	//------------------------------------------------
	public static int getNumAccounts()
	{
		return numAccounts;
	}
	//------------------------------------------------
	//Method to close the current account
	//------------------------------------------------
	public void close()
	{
		name = "CLOSED";
		balance = 0.0;
		numAccounts--;
	}
	//------------------------------------------------
	//Get account number.
	//------------------------------------------------
	public long getAcctNum()
	{
		return acctNum;
	}
	//------------------------------------------------
	//Get account owner name.
	//------------------------------------------------
	public String getName()
	{
		return name;
	}
	//------------------------------------------------
	//Consolidate two accounts.
	//------------------------------------------------
	public static Account consolidate(Account acct1, Account acct2)
	{
		String acct1Name = acct1.getName();
		String acct2Name = acct2.getName();
		
		if(acct1Name.compareTo(acct2Name) == 0)
		{
			double newBalance = acct1.getBalance() + acct2.getBalance();
			Account newAccount = new Account(newBalance, acct1Name, 317);
			return newAccount;
		}
		else if(acct1.getAcctNum() == acct2.getAcctNum())
		{
			System.out.println("Void Transaction");
			return null;
		}
		return null;
	}
	//-------------------------------------------------
	// Returns a string containing the name, account number, and balance.
	//-------------------------------------------------
	public String toString()
	{
		return "Name:" + name +
				"\nAccount Number: " + acctNum +
				"\nBalance: " + balance;
	}
	
	//--------------------------------------------------
	//Test the Consolidate method.
	//--------------------------------------------------
public class Test
{
	public void main(String[] args)
	{
		System.out.println("Enter three names: ");
		Scanner scan = new Scanner(System.in);
		
		String name1 = scan.nextLine();
		String name2 = scan.nextLine();
		String name3 = scan.nextLine();
		
		Account acct1 = new Account(100, name1, 21);
		Account acct2 = new Account(100, name2, 10);
		Account acct3 = new Account(100, name3, 17);
		
		System.out.println(acct1);
		System.out.println(acct2);
		System.out.println(acct3);
		
		acct1.close();
		System.out.println("Enter another name: ");
		String name4 = scan.nextLine();
		Account testAccount = new Account(100, name4, 62);
		testAccount.consolidate(acct2, acct3);	
		
		System.out.println(acct1);
		System.out.println(acct2);
		System.out.println(acct3);
	}
}

	
}


