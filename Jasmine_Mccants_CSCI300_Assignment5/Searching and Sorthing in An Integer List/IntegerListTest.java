package homework;
import java.util.Scanner;
public class IntegerListTest 
{
	// ****************************************************************
	// IntegerListTest.java
	//
	// Provide a menu-driven tester for the IntegerList class.
	//
	// ****************************************************************
	static IntegerList list = new IntegerList(10);
	static Scanner scan = new Scanner(System.in);
	//-------------------------------------------------------
	// Create a list, then repeatedly print the menu and do what the
	// user asks until they quit
	//-------------------------------------------------------
	public static void main(String[] args)
	{
		printMenu();
		int choice = scan.nextInt();
		while (choice != 0)
		{
			dispatch(choice);
			printMenu();
			choice = scan.nextInt();
		}
	}
	//-------------------------------------------------------
	// Do what the menu item calls for
	//-------------------------------------------------------
	public static void dispatch(int choice)
	{
		int loc;
		switch(choice)
		{
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			System.out.println("How big should the list be?");
			int size = scan.nextInt();
			list = new IntegerList(size);
			list.randomize();
			break;
		case 2:
			list.selectionSort();
			break;
		case 3:
			System.out.print("Enter the value to look for: ");
			loc = list.search(scan.nextInt());
			if (loc != -1)
				System.out.println("Found at location " + loc);
			else
				System.out.println("Not in list");
			break;
		case 4:
			list.print();
			break;
		case 5:
			System.out.print("Enter an old value ");
			int oldVal = scan.nextInt();
			System.out.print("Enter a new value ");
			int newVal = scan.nextInt();
			list.replaceFirst(oldVal, newVal);
			break;
		case 6:
			System.out.println("Enter an old value to be replaced ");
			int oldVal2 = scan.nextInt();
			System.out.println("Enter new value ");
			int newVal2 = scan.nextInt();
			list.replaceAll(oldVal2, newVal2);
			break;
		case 7:
			System.out.println("Sort List in Decreasing Order ");
			list.sortDecreasing();
			break;
		case 8:
			System.out.println("Enter a target to search for");
			int target = scan.nextInt();
			list.binarySearchD(target);
			break;
		default:
			System.out.println("Sorry, invalid choice");
		}
	}
	//------------------------------------------------------
	// Print the user's choices
	//------------------------------------------------------
	public static void printMenu()
	{
		System.out.println("\n Menu ");
		System.out.println(" ====");
		System.out.println("0: Quit");
		System.out.println("1: Create a new list (** do this first!! **)");
		System.out.println("2: Sort the list using selection sort");
		System.out.println("3: Find an element in the list using linear search");
		System.out.println("4: Print the list");
		System.out.println("5: Replace the first value");
		System.out.println("6: Replace All values");
		System.out.println("7: Sort List in Decreasing Order");
		System.out.println("8: Binary Search, has to be in Decreasing Order");
		System.out.print("\nEnter your choice: ");
	}
}
