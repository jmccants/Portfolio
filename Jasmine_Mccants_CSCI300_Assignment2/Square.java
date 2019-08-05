package homework;
import java.util.Scanner;
//***************************************************************
//Square.java
//
//Define a Square class with methods to create and read in
//info for a square matrix and to compute the sum of a row,
//a col, either diagonal, and whether it is magic.
//
//***************************************************************
public class Square
{
	int[][] square;
//--------------------------------------
//create new square of given size
//--------------------------------------
	public Square(int size)
	{
		square = new int[size][size];
	}
//--------------------------------------
//return the sum of the values in the given row
//--------------------------------------
	public int sumRow(int row)
	{
		int sum = 0;
		for(int i = 0; i < square.length; i++)
		{
			sum = sum + square[row][i];
		}
		return sum;
	}
//--------------------------------------
//return the sum of the values in the given column
//--------------------------------------
	public int sumCol(int col)
	{
		int sum = 0;
		for(int i = 0; i < square.length; i++)
		{
			sum = sum + square[i][col];
		}
		return sum;
	}
//--------------------------------------
//return the sum of the values in the main diagonal
//--------------------------------------
	public int sumMainDiag()
	{
		int sumMD = 0;
		for(int i = 0; i < square.length; i++)
		{
			sumMD = sumMD + square[i][i];
		}
		return sumMD;
	}
//--------------------------------------
//return the sum of the values in the other ("reverse") diagonal
//--------------------------------------
	public int sumOtherDiag()
	{
		int sumOD = 0;
		for(int i = 0; i < square.length; i++)
		{
			sumOD = sumOD + square[square.length - (i+1)][i];
		}
		return sumOD;
	}
//--------------------------------------
//return true if the square is magic (all rows, cols, and diags have
//same sum), false otherwise
//--------------------------------------
	public boolean magic()
	{
		boolean result = false;
		for(int i = 0; i < square.length; i++)
		{
			int sumR = sumRow(i);
			int sumC = sumCol(i);
			int sumMD = sumMainDiag();
			int sumOD = sumOtherDiag();
			
			if((sumR == sumC) && (sumR == sumMD) && (sumR == sumOD))
			{
				result = true;
			}
			else
			{
				result = false;
			}
		}
		return result;
		
	}
//--------------------------------------
//read info into the square from the input stream associated with the
//Scanner parameter
//--------------------------------------
	public void readSquare(Scanner scan)
	{
		for (int row = 0; row < square.length; row++)
			for (int col = 0; col < square.length; col ++)
				square[row][col] = scan.nextInt();
	}
//----------------------------------------
//print the contents of the square, neatly formatted
//----------------------------------------
	public void printSquare()
	{
		for(int i = 0; i < square.length; i++)
		{
			for(int x = 0; x < square.length; x++)
			{
				System.out.print(square[i][x] + "\t");
			}
			System.out.println();
		}
	}
}

