/**************************************************************************
*                                                                         *
*     Program Filename:  McCants5B.cpp                                    *
*     Author          :  Jasmine McCants                                  *
*     Date Written    :  December 4, 2017                                 *
*     Purpose         :  To process a file of student records             *
*     Input from      :  Random.dat                                   	  *
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

void AddARecord(StudentRecord&, fstream&);
void DeleteARecord(StudentRecord&, fstream&);
void DisplayRecord(StudentRecord&, fstream&);
void ChangeLastName(StudentRecord&, fstream&);
void ChangeMajor(StudentRecord&, fstream&);
void ChangeHours(StudentRecord&, fstream&);
void ChangeGPA(StudentRecord&, fstream&);
int SSN(StudentRecord&, fstream&);

int main()
{
	fstream RandomFile;
	StudentRecord S;
   
	RandomFile.open("random.dat", ios::in | ios::out);
   
	char selection;
	
	do 
	{
	cout << "\n\t Menu";
	cout << "\n======================";
	cout << "\n A - Add a record";
	cout << "\n D - Delete a record";
	cout << "\n S - Display a record";
	cout << "\n N - Change last name";
	cout << "\n M - Change major";
	cout << "\n H - Change hours";
	cout << "\n G - Change GPA";
	cout << "\n X - Stop the program";
	cout << "\n Enter selection: ";
	
	
	cin >> selection;
	switch(selection)
	{
		case 'A' :
		case 'a' :{AddARecord(S, RandomFile);}
		break;
		case 'D' :
		case 'd' :{DeleteARecord(S, RandomFile);}
		break;
		case 'S' :
		case 's' :{DisplayRecord(S, RandomFile);}
		break;
		case 'N' :
		case 'n' :{ChangeLastName(S, RandomFile);}
		break;
		case 'M' :
		case 'm' :{ChangeMajor(S, RandomFile);}
		break;
		case 'H' :
		case 'h' :{ChangeHours(S, RandomFile);}
		break;
		case 'G' :
		case 'g' :{ChangeGPA(S, RandomFile);}
		break;		
		case 'X' :
		case 'x' : {return 0;}
		default : cout<<"\n Invalid selection";
	}
	}
	while(selection == 'A' || selection == 'D' || selection == 'S' || selection == 'N' || selection == 'M' || selection == 'H' || selection == 'G' || selection == 'X' ||selection == 'a'||selection == 'd'||selection == 's'||selection == 'n'||selection == 'm'||selection == 'h'||selection == 'g'||selection == 'x');
	
	cout<<"\n";
	 
	return 0;
}

int hash(string S)
{
   int Sum = 0;

   for (unsigned int i = 0; i < S.length(); i++)
      Sum = Sum + S[i];
   // end for

   return Sum % 60;
}

void AddARecord(StudentRecord& R, fstream& RandomFile)
{
	string CurrentRecord;
	string SSN1, LastName1, FirstName1, Major1, totalCredit1, GPA1;
	cout << "Enter a new student record: Social Security Number, Last Name, First Name, Major, Total Credit Hours, GPA." << endl;
	cin >> SSN1 >> LastName1 >> FirstName1 >> Major1 >> totalCredit1 >> GPA1;
	R.SSN = SSN1;
	R.LastName = LastName1;
	R.FirstName = FirstName1;
	R.Major = Major1;
	R.totalCredit = atoi(totalCredit1.c_str());
	R.GPA = atof(GPA1.c_str());
	
	int Hash = 0;
	for (int i = 0; i < R.SSN.length(); i++)
	{
		Hash = Hash + R.SSN[i];
	}
	Hash = Hash % 60;

	RandomFile.seekg(58*Hash, ios::beg);
	RandomFile >> CurrentRecord;
	if(CurrentRecord[0] == '*')
		{
			RandomFile << R.SSN;
			RandomFile.seekp(58 * Hash + 9, ios::beg);
			RandomFile << R.LastName;
			RandomFile.seekp(58 * Hash + 19, ios::beg);
			RandomFile << R.FirstName;;
			RandomFile.seekp(58 * Hash + 29, ios::beg);
			RandomFile << R.Major;
			RandomFile.seekp(58 * Hash + 49, ios::beg);
			RandomFile << R.totalCredit;
			RandomFile.seekp(58 * Hash + 52, ios::beg);
			RandomFile << R.GPA;
		}
	else
	{
		while (CurrentRecord[0] != '*')
         {
            Hash++;
            if (Hash == 60)
            {
               Hash = 0;
            }
            RandomFile.seekg(58 * Hash, ios::beg);
            RandomFile >> CurrentRecord;
         }
		RandomFile.seekp(58 * Hash, ios::beg);
        RandomFile << R.SSN;
		RandomFile.seekp(58 * Hash + 9, ios::beg);
		RandomFile << R.LastName;
		RandomFile.seekp(58 * Hash + 19, ios::beg);
		RandomFile << R.FirstName;;
		RandomFile.seekp(58 * Hash + 29, ios::beg);
		RandomFile << R.Major;
		RandomFile.seekp(58 * Hash + 49, ios::beg);
		RandomFile << R.totalCredit;
		RandomFile.seekp(58 * Hash + 52, ios::beg);
		RandomFile << R.GPA;
	}
	return;
}

void DeleteARecord(StudentRecord& R, fstream& RandomFile)
{
	int count;
	count = SSN(R, RandomFile);
	string NewLastName;
	string NewRecord;

	RandomFile.seekg(58*count, ios::beg);
	RandomFile >> NewRecord;
	RandomFile.seekp(58*count, ios::beg);
	RandomFile <<  "*********                                          00.00";
	return;
}

void DisplayRecord(StudentRecord& R, fstream& RandomFile)
{
	int index;
	index = SSN(R, RandomFile);
	cout << R.SSN << R.LastName << R.FirstName << R.Major << R.totalCredit << R.GPA << endl;
	
	return;
}

void ChangeLastName(StudentRecord& R, fstream& RandomFile)
{
	int count;
	count = SSN(R, RandomFile);
	string NewLastName;
	string NewRecord;

	cout << "Please Enter a new last name that is up to 10 characters" << endl;
	cin >> NewLastName;
	RandomFile.seekg(58*count, ios::beg);
	RandomFile >> NewRecord;
	RandomFile.seekp(58*count + 9, ios::beg);
	RandomFile << NewLastName;
	
	return;
}

void ChangeMajor(StudentRecord& R, fstream& RandomFile)
{
	int count;
	count = SSN(R, RandomFile);
	string NewMajor;
	string NewRecord;

	cout << "Please Enter a new major that is up to 20 characters" << endl;
	cin >> NewMajor;
	RandomFile.seekg(58*count, ios::beg);
	RandomFile >> NewRecord;
	RandomFile.seekp(58*count + 29, ios::beg);
	RandomFile << NewMajor;
	
	return;
}

void ChangeHours(StudentRecord& R, fstream& RandomFile)
{
	int count;
	count = SSN(R, RandomFile);
	string NewCreditHours;
	string NewRecord;

	cout << "Please Enter a new total number of credit hours that is up to 3 characters" << endl;
	cin >> NewCreditHours;
	RandomFile.seekg(58*count, ios::beg);
	RandomFile >> NewRecord;
	RandomFile.seekp(58*count + 49, ios::beg);
	RandomFile << NewCreditHours;
	
	return;
}

void ChangeGPA(StudentRecord& R, fstream& RandomFile)
{
	int count;
	count = SSN(R, RandomFile);
	string NewGPA;
	string NewRecord;

	cout << "Please Enter a new GPA that is up to 4 characters" << endl;
	cin >> NewGPA;
	RandomFile.seekg(58*count, ios::beg);
	RandomFile >> NewRecord;
	RandomFile.seekp(58*count + 52, ios::beg);
	RandomFile << NewGPA;
	
	return;
}

int SSN(StudentRecord& R, fstream& RandomFile)
{	
	string SSNSearch;
	string CurrentRecord;
	string CurrentSSN;
	int count = 0;
	
	cout << "Please Enter a SSN" << endl;
	cin >> SSNSearch;
	
	while(getline(RandomFile, CurrentRecord)) 
	{ 
    if (CurrentRecord.find(SSNSearch, 0) != string::npos) 
	{
        cout << "found: " << SSNSearch << "line: " << count << endl;
		R.SSN = CurrentRecord.substr(0, 9);
		R.LastName  = CurrentRecord.substr(9, 10);
		R.FirstName = CurrentRecord.substr(19, 10);
		R.Major	    = CurrentRecord.substr(29, 20);
		R.totalCredit = atoi(CurrentRecord.substr(49, 3).c_str());
		R.GPA	    = atof(CurrentRecord.substr(52, 4).c_str());
		break;
    }
	count++;
	}
	
	return count;
}