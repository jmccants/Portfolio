/**************************************************************************
*                                                                         *
*     Program Filename:  picupstx.java                                    *
*     Author          :  Jasmine McCants                                  *
*     Date Written    :  February 27, 2017                                 *
*     Purpose         :  To play a game of Pick-up Sticks                 *
*     Input from      :  keyboard and a file named at keyboard            *
*     Output to       :  screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Scanner;
import java.io.*;

public class McCants2
{

public static class Stick
{

}

public static void main(String[] args) throws IOException
{
   String[][] Nodes = new String[25][2];
   int[][]  A = new int[25][25], C = new int [25][25];
   int      i, j; 
   int n, m;
   Scanner  InputFile = null;

   InputFile = PromptUserForInputFile(InputFile);
   n = InputFile.nextInt();
   m = InputFile.nextInt();
   ReadTheSticks(InputFile, Nodes, m);
   for(i = 0; i < 25; i++)
	   for(j = 0; j < 2; j++)
		   System.out.println(Nodes[i][j]);

   
   BuildAdjacencyMatrix(A, Nodes, n);
//   BuildConnectivityMatrix(A, n);
//   ProcessTheStickPairs(InputFile, A);
}
// end function main


/**************************************************************************
*                                                                         *
*     Function Name   :  PromptUserForInputFile                           *
*     Purpose         :  To get the input filename from the user          *
*     Called by       :  Main                                             *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

public static Scanner PromptUserForInputFile(Scanner InputFile) throws IOException
{
   Scanner Keyboard = new Scanner(System.in);
   String  NameOfTheInputFile;

   System.out.println("Please enter the name of the input file:");
   System.out.print("(include path if not in current directory) ");

   NameOfTheInputFile = Keyboard.nextLine();
   InputFile = new Scanner(new File(NameOfTheInputFile));

   return InputFile;
}
// end function PromptUserForInputFile


/**************************************************************************
*                                                                         *
*     Function Name   :  ReadTheSticks                                    *
*     Purpose         :  To read the endpoints of the given sticks        *
*     Called by       :  Main                                             *
*     Functions Called:  None                                             *
*                                                                         *
 * @param s 
 * @param nodes 
**************************************************************************/

public static int ReadTheSticks(Scanner InputFile, String[][] nodes, int M) throws IOException
{

   for (int i = 0; i < M ; i++)
   {
	   for(int j = 0; j < 2; j++)
		   nodes[i][j] = InputFile.next();
   }
   
   // end for

   return M*2;
}
// end function ReadTheSticks

/**************************************************************************
*                                                                         *
*     Function Name   :  BuildAdjacencyMatrix                             *
*     Purpose         :  To determine which sticks touch                  *
*     Called by       :  Main                                             *
*     Functions Called:  DoSticksIntersect                                *
*                                                                         *
**************************************************************************/

public static void BuildAdjacencyMatrix(int[][] A, String[][] Nodes, int N)
{
	System.out.println(A.length);
   for (int i = 0; i < N; i++)
      for (int j = 0; j < 1; j++)
    	  for(int k = 0; k < N; k++)
         if (Nodes[i][j] != Nodes[i][j+1])
            A[i][j] = 1;
         else
            A[i][j] = 0;
         
         // end if
      // end for
   // end for
   MatrixPrint(A, N);
   return;
}
// end function BuildAdjacencyMatrix

/**************************************************************************
*                                                                         *
*     Function Name   :  BuildConnectivityMatrix                          *
*     Purpose         :  To see extent of stick connectivity              *
*     Called by       :  Main                                             *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

public static void BuildConnectivityMatrix(int[][] A, int N)
{
 /*  int[][] B = new int[26][26], C = new int[26][26], D = new int[26][26];
   int h, i, j, k;

   if (N == 2)
      return;
   // end if

   for (i = 1; i <= N; i++)
      for (j = 1; j <= N; j++)
         B[i][j] = A[i][j];
      // end for
   // end for

   for (h = 1; h < N-1; h++)
   {
      for (i = 1; i <= N; i++)
         for (j = 1; j <= N; j++)
         {
            C[i][j] = 0;
            for (k = 1; k <= N; k++)
               C[i][j] = C[i][j] + A[i][k]*B[k][j];
            // end for
         }
         // end for
      // end for

      for (i = 1; i <= N; i++)
         for (j = 1; j <= N; j++)
         {
            B[i][j] = C[i][j];
            D[i][j] = D[i][j] + C[i][j];
         }
         // end for
      // end for
   }
   // end for

   for (i = 1; i <= N; i++)
      for (j = 1; j <= N; j++)
         if (C[i][j]+D[i][j] == 0)
            A[i][j] = 0;
         else
            A[i][j] = 1;
         // end if
      // end for
   // end for

   return; */
}
// end function BuildConnectivityMatrix

/**************************************************************************
*                                                                         *
*     Function Name   :  DoSticksIntersect                                *
*     Purpose         :  To determine if two given sticks touch           *
*     Called by       :  BuildAdjacenctMatrix                             *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

/*public static int  DoSticksIntersect(int nodes, int nodes2)
{
   int a, b, c, d;

   a = (nodes.y1 - nodes2.y1)*(nodes2.x2 - nodes2.x1) - (nodes2.y2 - nodes2.y1)*(nodes.x1 - nodes2.x1);
   b = (nodes.y2 - nodes2.y1)*(nodes2.x2 - nodes2.x1) - (nodes2.y2 - nodes2.y1)*(nodes.x2 - nodes2.x1);
   c = (nodes2.y1 - nodes.y1)*(nodes.x2 - nodes.x1) - (nodes.y2 - nodes.y1)*(nodes2.x1 - nodes.x1);
   d = (nodes2.y2 - nodes.y1)*(nodes.x2 - nodes.x1) - (nodes.y2 - nodes.y1)*(nodes2.x2 - nodes.x1);

   if (a == 0 && b == 0)
   {
      if ((((nodes2.x1<=nodes.x1 && nodes.x1<=nodes2.x2) || (nodes2.x2<=nodes.x1 && nodes.x1<=nodes2.x1))  &&
           ((nodes2.y1<=nodes.y1 && nodes.y1<=nodes2.y2) || (nodes2.y2<=nodes.y1 && nodes.y1<=nodes2.y1))) ||
          (((nodes2.x1<=nodes.x2 && nodes.x2<=nodes2.x2) || (nodes2.x2<=nodes.x2 && nodes.x2<=nodes2.x1))  &&
           ((nodes2.y1<=nodes.y2 && nodes.y2<=nodes2.y2) || (nodes2.y2<=nodes.y2 && nodes.y2<=nodes2.y1)))) 
         return 1;
      // end if

      if ((((nodes.x1<=nodes2.x1 && nodes2.x1<=nodes.x2) || (nodes.x2<=nodes2.x1 && nodes2.x1<=nodes.x1))  &&
           ((nodes.y1<=nodes2.y1 && nodes2.y1<=nodes.y2) || (nodes.y2<=nodes2.y1 && nodes2.y1<=nodes.y1))) ||
          (((nodes.x1<=nodes2.x2 && nodes2.x2<=nodes.x2) || (nodes.x2<=nodes2.x2 && nodes2.x2<=nodes.x1))  &&
           ((nodes.y1<=nodes2.y2 && nodes2.y2<=nodes.y2) || (nodes.y2<=nodes2.y2 && nodes2.y2<=nodes.y1)))) 
         return 1;
      // end if

      return 0;
   }
   // end if

   if (a*b <= 0 && c*d <= 0)
      return 1;
   else
      return 0;
   // end if
}*/
// end function DoSticksIntersect

/**************************************************************************
*                                                                         *
*     Function Name   :  ProcessTheStickPairs                             *
*     Purpose         :  To determine if pairs of sticks are connected    *
*     Called by       :  Main                                             *
*     Functions Called:  None                                             *
*                                                                         *
**************************************************************************/

public static void ProcessTheStickPairs(Scanner InputFile, int[][] C) throws IOException
{
 /*  String FirstStick, SecondStick;

   FirstStick  = InputFile.next();
   SecondStick = InputFile.next();

   while (FirstStick != 0)
   {
      System.out.print("Stick # " + FirstStick + " and Stick # " + SecondStick);

      if (C[FirstStick][SecondStick] == 0)
         System.out.println(" are not connected.");
      else
         System.out.println(" are connected.");
      // end if

      FirstStick  = InputFile.next();
      SecondStick = InputFile.next();
   }
   // end while

   return; */
}
// end function ProcessTheStickPairs
public static void MatrixPrint(int[][] A, int size)
{
   int i, j;

   for (i = 0; i < size; i++)
   {
      for (j = 0; j < size; j++)
         System.out.format("%5d", A[i][j]);
      // end for

      System.out.println();
   }
   // end for

   return;
}
// end public method MatrixPrint
}
// end class picupstx

