package homework;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ComparePlayers extends Player 
{
	// **************************************************************
	// ComparePlayers
	//
	// Reads in two Player objects and tells whether they represent
	// the same player.
	// **************************************************************
	public static void main(String[] args)
	{
//		Player p1 = new Player{super(name), super(team), super(jerseyNumber));
//		Scanner scan = new Scanner(new File("Player.java"));
	//Prompt for and read in information for player 1
	Scanner scan = new Scanner(System.in);
		Player[] p1;
	String p1name = scan.next();
	String p1team = scan.next();
	Integer p1jerseyNum = scan.nextInt();
//	p1 = new Player{p1name, p1team, p1jerseyNum};
	//Prompt for and read in information for player 2
		Player p2;
	String p2name = scan.next();
	String p2team = scan.next();
	Integer p2jerseyNum = scan.nextInt();
	
//	p2 = new Player{p2name, p2team, p2jerseyNum};
	//Compare player1 to player 2 and print a message saying
	//whether they are equal
	
	if(p1name.equals(p2name) == true)
	{
		if(p1team.equals(p2team) == true)
		{
			if(p1jerseyNum.equals(p2jerseyNum) == true)
			{
				System.out.println("Same Player");
			}
		}
	}
	else
	{
		System.out.println("Different Player");
	}
	}
}

