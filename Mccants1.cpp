#include <conio.h>
#include <iostream>
#include <cmath>
#include <iomanip>


using namespace std;



int main()
{
	double	OwedAmount, Intrest, AddPayment;
	

	
	cout << "Please enter credit card amount debt: ";
	cin  >> OwedAmount;
	cout << endl << "Please enter the fixed annual rate of interest charged: ";
	cin  >> Intrest;
	cout << endl << "Please enter the additional amount to be paid each month beyond the minimum payment: ";
	cin  >> AddPayment;
	
	cout << endl << "Page 1:";
	cout << endl << "========";
	cout << endl;
	cout << setprecision(2) << fixed;
   cout << setiosflags(ios::showpoint) << setiosflags(ios::fixed);  
	cout << endl << "Amount Owed: " << OwedAmount;
	cout << endl << "Annual Interest Rate: " << Intrest << "%";
	cout << endl << "Additional Payment Each Month: " << AddPayment;
   cout << endl;
   cout << endl;
	cout << endl << "===================================================================";
   
   

	//sets up the beginning of the report
   
   cout << setprecision(2) << fixed;
   cout << endl << setw(3) << "MONTH" << setw(11) << "PAYMENT" << setw(11) << "PRINCIPAL";
   cout << setw(11) << "INTREST" << setw(11) << "BALANCE";
   cout << endl << setw(3) << "=====" << setw(11) << "=======" << setw(11) << "=========";
   cout << setw(11) << "=======" << setw(11) << "=======";
   cout << endl;
   cout << endl;
	 
   Intrest = Intrest/100;
   double IntrestRate; 
    
   double principle, payment;
   double balance = OwedAmount;
   char Input; 
   bool x = false;
   
   do
   {
       if(x == true)
       { 
         clrscr();
       }
       
       for(int i = 1; i <= 12; i++)
       {
          principle = balance * 0.02;
   
          IntrestRate = balance * (Intrest/12);
   
          payment = principle + IntrestRate;
   
          balance = (balance + AddPayment)- payment;
       
         cout << setprecision(2) << fixed;
      
         cout << endl << setw(3) << i << setw(12) << payment;
         cout << setw(12) << principle << setw(12) << IntrestRate << setw(12) << balance;
       }  
       
       cout << endl << "enter 'c' to continue...";
       cin >> Input;
       x = true;
       
       
   }
   
   while(Input == 'c');
   

	return 0;
	
}
//end function main