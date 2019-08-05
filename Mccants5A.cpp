/**************************************************************************
*                                                                         *
*     Program Filename:  McCants5A.cpp                                    *
*     Author          :  Jasmine McCants                                  *
*     Date Written    :  December 4, 2017                                 *
*     Purpose         :  To process a file of student records             *
*     Input from      :  program5A.dat                                    *
*     Output to       :  Random.dat                                       *
*                                                                         *
**************************************************************************/
#include <fstream.h>
#include <string.h>
#include <conio.h>
#include <iostream.h>
#include <iomanip.h>

struct  StudentRecord
{
	string SSN;
	string LastName;
	string FirstName;
	string Major;
	int totalCredit;
	double GPA;
};

void ReadNextStudentRecord(StudentRecord&, ifstream&, fstream&);
int hash(string);
string Print(StudentRecord&, fstream&);
void DummyRecord(fstream&);

int main()
{
   //int count = 0;
   
   fstream RandomFile;
   ifstream InFile;
   StudentRecord S;
   
   RandomFile.open("random.dat", ios::in | ios::out);
   InFile.open("Program5A.dat", ios::in);
   
   DummyRecord(RandomFile);
   //Print(S, RandomFile);
	
   for(int i = 0; i < 30; i++)
   {
	ReadNextStudentRecord(S, InFile, RandomFile);
   }
    
   return 0;
}

void ReadNextStudentRecord(StudentRecord& R, ifstream& InFile, fstream& RandomFile)
{
	string NextRecord;
	string CurrentRecord;
	
   getline(InFile, NextRecord);
   if (InFile.eof())
      return;
	
	R.SSN = NextRecord.substr(0, 9);
	R.LastName  = NextRecord.substr(9, 10);
    R.FirstName = NextRecord.substr(19, 10);
    R.Major	    = NextRecord.substr(29, 20);
	R.totalCredit = atoi(NextRecord.substr(49, 3).c_str());
	R.GPA	    = atof(NextRecord.substr(52, 4).c_str());
	
	cout << hash(R.SSN);
	RandomFile.seekg(58*hash(R.SSN), ios::beg);
	RandomFile >> CurrentRecord;
	//for(int i = 0; i < CurrentRecord.length(); i++)
		if(CurrentRecord[0] == '*')
		{
			RandomFile.seekp(58*hash(R.SSN), ios::beg);
			RandomFile << Print(R, RandomFile);
		}
		else
		{
			int AddedHash = hash(R.SSN);
			//if(CurrentRecord[0] != '*')
			//{
				if(AddedHash < 59)
				{
					AddedHash++;
					RandomFile.seekg(58*AddedHash, ios::beg);
				}
				if(AddedHash = 59)
				{
					AddedHash = 0;
					RandomFile.seekg(58+AddedHash, ios::beg);
				}
			//}
		
			RandomFile << Print(R, RandomFile);
				
		}
	/*for(i=0 ;i < a.length(); i++)
		a[i]=-1;
		
	if(a[hash(R.SSN)] == -1)*/
		

	return;
}

int hash(string S)
{
   int Sum = 0;

   for (unsigned int i = 0; i < S.length(); i++)
      Sum = Sum + S[i];
   // end for

   return Sum % 60;
}


string Print(StudentRecord& R, fstream& RandomFile)
{
	RandomFile << setprecision(2) << fixed;
	/*RandomFile << setw(9) << R.SSN; 
	RandomFile << setw(10) << R.LastName; 
	RandomFile << setw(10) << R.FirstName; 
	RandomFile << setw(20) << R.Major; 
	RandomFile << setw(3) << R.totalCredit;
	RandomFile << setw(4) << R.GPA;*/
	
	string SSN2, LastName2, FirstName2, Major2, totalCredit2, GPA2;
	SSN2 = R.SSN;
	LastName2 = R.LastName;
	FirstName2 = R.FirstName;
	Major2 = R.Major;
	totalCredit2 = R.totalCredit;
	GPA2 = R.GPA;
	
	string Output = SSN2 + LastName2 + FirstName2 + Major2 + totalCredit2 + GPA2;
	
	return Output;
}

void DummyRecord(fstream& RandomFile)
{
	int count = 0;
	RandomFile << setprecision(2) << fixed;
	
	while(count < 59)
	{
		RandomFile << setw(9) << "*********";
		RandomFile << setw(42) << "";
		RandomFile << setw(5) << "00.00" << endl;
		count++;
	}
	
}