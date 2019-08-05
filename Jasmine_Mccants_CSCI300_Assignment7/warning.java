import java.util.Scanner;
import java.io.*;
public class warning 
{
	// -------------------------------------------------------------------
	// Reads student data (name, semester hours, quality points) from a
	// text file, computes the GPA, then writes data to another file
	// if the student is placed on academic warning.
	// -------------------------------------------------------------------
	public static void main (String[] args)
	{
		int creditHrs; // number of semester hours earned
		double qualityPts; // number of quality points earned
		double gpa; // grade point (quality point) average
		String line, name, inputName = "students.dat";
		String outputName = "warning.dat";
		try
		{
			Scanner scan = new Scanner(new File(inputName));
			PrintWriter outFile = new PrintWriter(new File (outputName));
			// Set up the output file stream
			// Print a header to the output file
			outFile.println ();
			outFile.println ("Students on Academic Warning");
			outFile.println ();
			// Process the input file, one token at a time
			while (scan.hasNextLine())
			{
				// Get the credit hours and quality points and
				// determine if the student is on warning. If so,
				// write the student data to the output file.
				
				line = scan.nextLine();
				String[] array = line.split(" ");
				
				name = array[0];
				
				creditHrs = Integer.parseInt(array[1]);
				qualityPts = Double.parseDouble(array[2]);

				gpa = qualityPts/creditHrs;

				if(creditHrs < 30)
				{
					if(gpa < 1.5)
					{
						outFile.println (name + " " + creditHrs + " " + gpa);
					}
				}
				else if(creditHrs < 60)
				{
					if(gpa < 1.75)
					{
						outFile.println (name + " " + creditHrs + " " + gpa);
					}
				}
				else
				{
					if(gpa < 2.0)
					{
						outFile.println (name + " " + creditHrs + " " + gpa);
					}
				}
			}
			
			// Close output file
			scan.close();
			outFile.close();
		}
		catch (FileNotFoundException exception)
		{
			System.out.println ("The file " + inputName + " was not found.");
		}
		catch (IOException exception)
		{
			System.out.println (exception + "Something wrong with the input or output stream.");
		}
		catch (NumberFormatException e)
		{
			System.out.println ("Format error in input file: " + e + ". Cannot parse and int or double when it tries to.");
		}
	}
}
