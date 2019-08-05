#include <fstream.h>
#include <iomanip.h>
#include <conio.h>


struct NameRecord
{
	string LastName;
	string FirstName;
	char   MidInit;
};

struct ProgramTestRecord
{
	int Test1;
	int Test2;
	int Test3;
};

struct StudentRecord
{
	NameRecord Name;
	string SSN;
	string Major;
	int Program1;
	int Program2;
	int Program3;
	int Program4;
	int Program5;
	int Program6;
	ProgramTestRecord PTR[3];
	int FinalExam;
	int Average;
};

void ReadNextStudentRecord(StudentRecord&, ifstream&);
void WriteNextStudentRecord(StudentRecord&, ofstream&);
void Comparable(StudentRecord&, int count);
void BubbleSort(StudentRecord&, int n);

int main()
{
   ifstream InFile;
   ofstream OutFile;
   StudentRecord S;
   int count = 0;
   int max = 0;
   int temp = 0;
   int testAv = 0;
   int programAv = 0;
   int studentAv = 0;
  // ProgramTestRecord PTR[50];
   
   InFile.open("Program3.dat", ios::in);
   OutFile.open("louie.dat", ios::out);

   ReadNextStudentRecord(S, InFile);
   while (!InFile.eof())
   {
	 count++;
	 WriteNextStudentRecord(S, OutFile);
	 ReadNextStudentRecord(S, InFile);
	 
   }
   Comparable(S, count);
   int count2 = count;
   
   //BubbleSort(S, count);
   while(count > 0)
   {
	;
	count--;
	}
     programAv = (S.PTR[0].Program1 + S.PTR[1].Program2 + S.PTR[2].Program3 + S.PTR[3].Program4 + S.PTR[4].Program5 + S.PTR[5].Program6)/6;
	 testAv = (S.PTR[6].Test1 + S.PTR[7].Test2 + S.PTR[8].Test3)/3;
	 studentAv = (programAv*0.30) + (testAv*0.40) + ((S.PTR[9].FinalExam)*0.30);
	 S.PTR[10].Average = studentAv;
	 //cout << S.PTR[10].Average << endl;
   // end while

   return 0;
}

void ReadNextStudentRecord(StudentRecord& R, ifstream& InFile)
{
   string NextRecord;

   getline(InFile, NextRecord);
   if (InFile.eof())
      return;
   // end if

   R.Name.LastName = NextRecord.substr(0, 15);
   R.Name.FirstName = NextRecord.substr(15, 10);
   R.Name.MidInit = NextRecord[25];
   
   R.SSN = NextRecord.substr(26, 9);
   
   R.Major = NextRecord.substr(35, 20);
 
   R.PTR.Program1 = NextRecord.(55, 2);
   R.PTR.Program2 = NextRecord.(57, 2);
   R.PTR.Program3 = NextRecord.(59, 2);
   R.PTR.Program4 = NextRecord.(61, 2);
   R.PTR.Program5 = NextRecord.(63, 2);
   R.PTR.Program6 = NextRecord.(65, 2);
   R.PTR[0].Test1 =	atoi(NextRecord.substr(67, 3).c_str());
   R.PTR[1].Test2 = atoi(NextRecord.substr(70, 3).c_str());
   R.PTR[2].Test3 = atoi(NextRecord.substr(73, 3).c_str());
   R.PTR.FinalExam = NextRecord.substr(76, 3);
   
 // end for

   return;
}
// end function ReadNextStudentRecord

void WriteNextStudentRecord(StudentRecord& R, ofstream& OutFile)
{
   char grade = 'A';
   OutFile << setiosflags(ios::showpoint) << setiosflags(ios::fixed);
   OutFile << setprecision(5) << fixed;
   OutFile << endl << setw(4) << R.SSN.substr(5,4); 
   //OutFile << setw(4) << R.PTR[10].Average;
   switch (R.PTR[10].Average/10)
	 {
		case 0: case 1: case 2: case 3: case 4: case 5:grade = 'F'; OutFile << setw(4) << grade; break;
		case 6:grade = 'D'; OutFile << setw(4) << grade; break;
		case 7:grade = 'C'; OutFile << setw(4) << grade; break;
		case 8:grade = 'B'; OutFile << setw(4) << grade; break;
		case 9: case 10:grade = 'A'; OutFile << setw(4) << grade; break;
	 }

	 
   return;
}
// end function WriteNextStudentRecord

void BubbleSort(StudentRecord& R, int N)
{
	int i, j;
	StudentRecord temp;
	
	for(i = N; i >= 0; i--)
		for (j =1; j <= i; j++)
		{
			if (R.PTR[j-1].Average > R.PTR[j].Average)
			{
				temp.PTR[j] = R.PTR[j];
				R.PTR[j] = R.PTR[j-1];
				R.PTR[j-1] = temp.PTR[j];
			}
			//end if
		}
		//end for
	//end for
	return;
}
//end BubbleSort function

void Comparable(StudentRecord& R, int count)
{
	int max1 = R.PTR[6].Test1;
	int max2 = R.PTR[7].Test2;
	int max3 = R.PTR[8].Test3;
	int temp = 0;
	int bestIndex = 6;
	
	//max
	for (int i = 0; i < count; i++)
		{//cout << max1 << endl;
		// cout << max2 << endl;
		// cout << max3 << endl;
		if(R.PTR[i].Test1 > max1)
		{
			max1 = i;
			bestIndex = i;
			max1 = R.PTR[i].Test1;
			cout << max1 << endl;
		}
		}
		/*if(max1 < 100)
		{
			temp = 100 - max1;
			for (int i = 0; i < count; i++)
				R.PTR[6].Test1 = R.PTR[i].Test1 + temp;
		}
		
		temp = 0;
		
		if(max2 < 100)
		{
			temp = 100 - max2;
			for (int i = 0; i < count; i++)
				R.PTR[6].Test2 = R.PTR[i].Test2 + temp;
		}
		
		temp = 0;
		
		if(max3 < 100)
		{
			temp = 100 - max3;
			for (int i = 0; i < count; i++)
				R.PTR[6].Test3 = R.PTR[i].Test3 + temp;
		}*/
	
	
	return;
}