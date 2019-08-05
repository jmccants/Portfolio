/**************************************************************************
*                                                                         *
*     Program Filename:  TicTacToe.cpp                                    *
*     Author          :  John B. Student                                  *
*     Date Written    :  September 21, 2017                               *
*     Purpose         :  To play a version of Tic-Tac-Toe interactively   *
*     Input from      :  Keyboard                                         *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/
#include <iostream.h>
#include <conio.h>
#include <time.h>
#include "louie.h"

typedef int ExternalBoard[12][12];
void initializeBoard(ExternalBoard);
void printBoard(ExternalBoard);
void playerTakesTurn(ExternalBoard);
bool validMove(int, int);

int main()
{
   ExternalBoard B;
   initializeBoard(B);
   printBoard(B);
   playerTakesTurn(B);
	
   return 0;
}
// end function main

/**************************************************************************
*                                                                         *
*     Function Name   :  initializeBoard                                  *
*     Purpose         :  To place stars in the Tic-Tac-Toe board          *
*     Called by       :  Main                                             *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

void  initializeBoard(ExternalBoard x)
{
   int i,j;

   for (i = 2; i <= 9; i++)
      for (j = 2; j <= 9; j++)
			x[i][j] = 0;
      // end for
   // end for

   return;
}
// end function initializeBoard


/**************************************************************************
*                                                                         *
*     Function Name   :  printBoard                                       *
*     Purpose         :  To print the current state of the board          *
*     Called by       :  Main                                             *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

void  printBoard(ExternalBoard x)
{
   int i,j;

   clrscr();

   for (i = 2; i <= 9; i++)
   {
      for (j = 2; j <= 9; j++)
	  {
		cout << x[i][j] << " ";
	  }
      // end for
	  cout <<"\n\n";
   }
   // end for

   return;
}
// end function printBoard

/**************************************************************************
*                                                                         *
*     Function Name   :  playerTakesTurn                                  *
*     Purpose         :  To get the player's next move                    *
*     Called by       :  Main                                             *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

void  playerTakesTurn(ExternalBoard x)
{
	int row = 0;
	int column = 0;
	int counter = 1;
	
		cout << endl << endl << endl  << endl;
		cout << "Please enter the row and column of your Knights first move (2 - 9): ";
		cin  >> row >> column;
		 x[row][column] = -2;
	
	//for (int row = 2; row <= 9; row++)
	//{
	//	for(int column = 2; column <= 9; column++)
	//	{
		//while(validMove(row, column) == true)
		//{
			
			for (int row = 2; row <= 9; row++)
			{
			for(int column = 2; column <= 9; column++)
			{
			if (x[row][column] == 0)
				x[row][column] = counter;
			else if (x[row-1][column+2] == 0)
				x[row-1][column+2] = counter;
			else if (x[row-2][column+1] == 0)
				x[row-2][column+1] = counter;
			else if (x[row-1][column-2] == 0)
				x[row-1][column-2] = counter;
			else if (x[row-2][column-1] == 0)
				x[row-2][column-1] = counter;
			else if (x[row+1][column+2] == 0)
				x[row+1][column+2] = counter;
			else if (x[row+1][column-2] == 0)
				x[row+1][column-2] = counter;
			else if (x[row+2][column-1] == 0)
				x[row+2][column-1] = counter;
			counter++;
		}
		}
		printBoard(x);


  return;
}
// end function playerTakesTurn

bool validMove(int row, int column)
{
	if (row >= 2 && row <= 9)
		if (column >= 2 && column <= 9)
			return true;
			
	return false;
			
}





