package homework;
import java.io*;
import java.util.Scanner;
public abstract class Essay extends TestQuestion
{
	static int BlankLines;
	
	public static int Essay(int x)
	{
		BlankLines = x;
		return BlankLines;
	}	
	
	public String toString()
	{
		for(int i = 0; i <= BlankLines; i++)
		{
			System.out.println();
		}
		
	}
	
}
