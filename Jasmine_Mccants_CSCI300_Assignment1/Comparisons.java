package homework;
/************************************
 * 	Using the Comparable Interface 
 * 		   Question 2(Driver Class)
 *  	Jasmine McCants
 *	  CSCI 300 Chunyu Ai
 *This is the Driver class that will scan 
 *the readers inputs of 3 names and will
 *use the largest method of the Compare3
 *class to print the largest value of the
 *		 users inputs.
 ************************************/
import java.util.Scanner;
public class Comparisons
{
   public static void main(String[] args)
   {
      //create a scanner method to take in the readers inputs
      Scanner scan = new Scanner(System.in);
      
      //prompt the reader to input three names and set them as input values
      System.out.println("Enter three names: ");
      String input = scan.next();
      scan.nextLine();
      String input2 = scan.next();
      scan.nextLine();
      String input3 = scan.next();
   
      //call the largest method that allows to print the input with the largest value
      Compare3.largest(input, input2, input3);
     
      //prompt the user to input three whole numbers and set them as number values
      System.out.println("Enter three whole numbers: ");
      int num1 = scan.nextInt();
      scan.nextLine();
      int num2 = scan.nextInt();
      scan.nextLine();
      int num3 = scan.nextInt();
      
      //test the largest method to see if it works with numbers as well
      Compare3.largest(num1, num2, num3);
   }
}