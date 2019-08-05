public class Polynomial1
{
	//necessary variables
	private int degree;
	
	//the array of coefficients has a large size for space reasons
	public int arrayCO[];
	
	//result of the evaluation
	private double result;
	
	
	public Polynomial1(int n)
	{
		//number of elements for the array of coefficients
		int numDegrees [] = new int [n + 1];
		arrayCO = numDegrees;
		
		degree = n;
		
		//fills in the empty slots
		for (int index = 0; index < n + 1; index++)
		{
			arrayCO[index] = 0;
		}

	}
	
	public void setCoefficient (int i, int value)
	{
		//sets the coefficient at a certain index in the array of coefficients
		arrayCO[i] = value; 
	}
	
	public double evaluate(int x)
	{
		//calculates the last half of the polynomial
		double lastHalf = arrayCO[degree] * Math.pow(x, degree);
		double firstHalf = 0;
		
		//calculates the first half of the array
		for (int polyIndex = 1; polyIndex < degree-1; ++polyIndex)
		{
			firstHalf +=  (arrayCO[polyIndex] * x);
		}
		
		//returns the final evaluation of the whole polynomial
		return result = arrayCO[0] + firstHalf + lastHalf;
		
	}

}
