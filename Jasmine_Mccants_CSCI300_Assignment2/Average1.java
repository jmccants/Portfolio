package homework;

public class Average1 
{
	public static void main(String[] args)
	{
		for(int i = 0; i > 0; i++)
		{
			if(args.length > 0)	
			{	
				double average;
				int sum = 0;
				sum = sum + Integer.parseInt(args[i]);
				average = sum/args.length;
				System.out.println(average);
			}
			else
			{
				System.out.println("No Arguments");
			}
		}
	}
}

