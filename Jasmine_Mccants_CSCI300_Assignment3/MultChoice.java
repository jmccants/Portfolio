package homework;
import java.io.*;
import java.util.Scanner;
public abstract class MultChoice extends TestQuestion
{
	Scanner scan = new Scanner(System.in);
	
	public void readQuestion(char m, char e)
	{
		if(e == 0)
		{
			Essay.Essay(scan.nextInt());
			//Essay.toString();
			
		}
	}
	
	public void TestQuestion()
	{
		String[] QandA;
		QandA = new String[] {scan.nextLine()};
	}
	
	public int choiceLines(int x)
	{
		for(int i = 0; i <= x; i++)
			System.out.println();
		return x;
	}
	
}
