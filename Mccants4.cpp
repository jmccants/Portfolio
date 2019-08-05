/************************************************
*                                               *
*     Program Filename:  Mccants4.cpp           *
*           Name      :  Jasmine McCants        *
*    	  Due Date    :  11/6/2017             	*
*                                               *
*************************************************/


#include <iostream.h>
#include <cmath>
#include "Point.h"

int main()
{
	//Initialize Constructor
	Point P;
	double Distance;
	
	//create pool table
	Point	Orgin (0, 0);
	Point	Point2(125, 0);
	Point	Point3(125, 45);
	Point	Point4(0, 45);
	
	//get the pool balls coordinates
	double x = 0.0;
	double y = 0.0;
	
	cout << "Enter the coordinates of the pool balls starting position." << endl;
	cin >> x >> y;
	
	P.setX(x);
	P.setY(y);
	
	//get N for the number of collisions 
	int N = 0;
	
	cout << "Enter a positive double N." << endl;
	cin >> N;

	double temp = 0.0;
	double setDirection = 45;
	int counter = 0;
	
	while(counter < N)
	{
	//moveInDirection
		P.moveInDirection(setDirection, 0.001);
	//check bounds
		if(P.getY() > 45)
		{
			//top
			//temp = P.getY() - 45;
			//P.setY((45-temp));
			//cout << endl << "TOP";
			P.setY(45);
		}
		if(P.getX() > 125)
		{
			//right
			//temp = P.getX() - 125;
			//P.setX(125 - temp);
			//cout << endl << "RIGHT";
			P.setX(125);
		}
	   if(P.getY() < 0)
		{
			//bottom
			//P.setY(abs(P.getY()));
			//cout << endl << "BOTTOM";
			P.setY(0);
		}
		if(P.getX() < 0)
		{
			//left
			//P.setX(abs(P.getX()));
			//cout << endl << "LEFT";
			P.setX(0);
		}
		//move the ball	and count
		if(P.getY() == 45)
		{
			counter++;
			if(setDirection == 45)
			{
				setDirection = 315;
			}
			else if(setDirection == 135)
			{
				setDirection = 225;
			}
		}
		else if(P.getY() == 0)
		{
			counter++;
			if(setDirection == 315)
			{
				setDirection = 45;
			}
			else if(setDirection == 225)
			{
				setDirection = 135;
			}
		}
		else if(P.getX() == 125)
		{
			counter++;
			if(setDirection == 315)
			{
				setDirection = 225;
			}
			else if(setDirection == 45)
			{
				setDirection = 135;
			}
		}
		else if(P.getX() == 0)
		{
			counter++;
			if(setDirection == 225)
			{
				setDirection = 315;
			}
			else if(setDirection == 135)
			{
				setDirection = 45;
			}
		}
		else if((P.getX() == 125) && (P.getY() == 45))
		{
			counter++;
			counter++;
			setDirection = 225;
		}	
		else if((P.getX() == 125) && (P.getY() == 0))
		{
			counter++;
			counter++;
			setDirection = 135;
		}
		else if((P.getX() == 0) && (P.getY() == 0))
		{
			counter++;
			counter++;
			setDirection = 45;
		}
		else if((P.getX() == 0) && (P.getY() == 45))
		{
			counter++;
			counter++;
			setDirection = 315;
		}
		//print results
		if((P.getX() == 125) && (P.getY() == 45))
		{
			//top, right
			cout << endl << "TOP";
			cout << endl << "RIGHT";
		}
		else if((P.getX() == 125) && (P.getY() == 0))
		{
			//bottom, right
			cout << endl << "BOTTOM";
			cout << endl << "RIGHT";
		}
		else if((P.getX() == 0) && (P.getY() == 0))
		{
			//bottom, left
			cout << endl << "BOTTOM";
			cout << endl << "LEFT";		
		}
		else if((P.getX() == 0) && (P.getY() == 45))	
		{
			//top, left
			cout << endl << "TOP";
			cout << endl << "LEFT";		
		}
		else if(P.getY() == 0)
			cout << endl << "BOTTOM";
		else if(P.getX() == 0)
			cout << endl << "LEFT";
		else if(P.getX() == 125)
			cout << endl << "RIGHT";
		else if(P.getY() == 45)
			cout << endl << "TOP";
	
	}	
	
}