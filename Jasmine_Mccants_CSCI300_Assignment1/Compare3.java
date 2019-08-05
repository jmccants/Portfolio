package homework;
/****************************************************
 * 		  Using the Comparable Interface 
 *    		Question 1(Worker Class)
 *  			Jasmine McCants
 *	  		  CSCI 300 Chunyu Ai
 *Using the comparable interface make a method
 *that compares and returns the largest comparable
 *				  interface.
 ***************************************************/
public class Compare3 
{
	//static variable big that will give the final result
	private static Comparable big;
	
	//largest method that accepts 3 comparable parameters
	public static Comparable largest(Comparable input1,Comparable input2,Comparable input3)
	{ 
	  //using the compareTo method go through all inputs and see which hold the biggest value
      big = input1;
      if(input1.compareTo(input2)<0)
      {
    	  big = input2;
      }
      if(big.compareTo(input3)<0)
      {
    	  big = input3;
      }
     
      //print out the static variable big that holds the biggest value of the inputs given 
      System.out.println(big);
      return big;
	}

}
