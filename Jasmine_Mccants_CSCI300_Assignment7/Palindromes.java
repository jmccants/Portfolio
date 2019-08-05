import java.util.Scanner;
public class Palindromes 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a string: ");
		
		String input = scan.nextLine();
		System.out.println(palindromes(input));
		
	}
	
	public static boolean palindromes(String x)
	{
		if(x.length() <= 1)
		{
			return true;
		}
		else if(x.charAt(0) == x.charAt(x.length()-1))
		{
			String newX = x.substring(1, (x.length()-1));
			return palindromes(newX);
		}
		
		return false;

	}
}
