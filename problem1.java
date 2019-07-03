package random;

/*How to write a program that prints numbers from 1-100 , but
for multiples of 3 print the word "Fizz". For multiples of 5
print the word "Buzz". For multiples of 3 and 5 print the word
"FizzBuzz".*/

public class problem1 
{

	public static void main(String[] args) 
	{
		for(int i = 1; i <= 100; i++)
		{
			if(i % 3 == 0 && i % 5 == 0)
			{
				System.out.println("FizzBuzz");
			}
			else if(i % 3 == 0)
			{
				System.out.println("Fizz");
			}
			else if(i % 5 == 0)
			{
				System.out.println("Buzz");
			}
			else
			{
				System.out.println(i);
			}
		}

	}

}
