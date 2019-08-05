package hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class jMccants_Assignment3 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner Keyboard = new Scanner(System.in);
		System.out.println("Please enter the name of the input file:");
		System.out.print("(include path if not in current directory) ");
		String NameOfTheInputFile = Keyboard.nextLine();
		Scanner InputFile = new Scanner(new File(NameOfTheInputFile));
		//prompts the user for data file
		
		int[] IntArray = new int[100];
		int IslandNum = InputFile.nextInt();
		int i = 0;
		while(InputFile.hasNext())
		{
			IntArray[i++] = InputFile.nextInt();		
		}
		
		for(int n = 0; n < IntArray.length; n++)
			System.out.println(IntArray[n]);
		//reads in island information into IntArray
		
		int[] CheckPad = new int[100];
		
		for (i = 0; i < 100; i++)
			CheckPad[i] = -1-i;
		
	}
}
