/******************************************************************
         Program:        JasmineMccants_Java_Assignment1.java
         Course Info:    CSI 200, section 001
         Author:         Jasmine McCants
         Date:           02/08/2016
         Description:    This program shows the calculations made
                            for the customer of Jasmine's Lawncare.
*******************************************************************/
public class JasmineMccants_Java_Assignment1
{
   public static void main(String[] args)
   {
   /*The variable m shows the approximate amount for one acre in square meters.
     The variable n shows the approximate amount for one foot in meters.*/
   
   double m = 4046.856, n = 0.305;
  
   /*The final variable x shows the amount made per hour.
     The final variable y shows the rate at which grass is cut in square meters.*/
   
   final double x = 21.35, y = 2.56;
  
   //Calculations for the customer printed on a reciept.
  
      System.out.println(" |==================|" + "\n |Jasmine's LawnCare|" + "\n |==================|");
      System.out.println(" Jazzing up your lawn!");
      System.out.println();
      System.out.println("Total yardage: " + (4.52*m) + " square meters" + "\nYardage mowed: " + ((4.52*m)-(((8*n)*(14*n))+((81*n)*(43*n)))) + " square meters");
      System.out.println("Total time of service: " + ((4.52*m)-(((8*n)*(14*n))+((81*n)*(43*n))))/y/60 + " minutes");
      System.out.println();
      System.out.println("At a payment rate of $" + x + " an hour for this service, " + "\n   the payment due is around $" + (int)(((4.52*m)-(((8*n)*(14*n))+((81*n)*(43*n))))/y/60/60*x) + ".");
    }
}