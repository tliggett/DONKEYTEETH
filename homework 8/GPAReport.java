//TJ Liggett
//Homework 8
//GPAReport.java

import java.io.*;
import java.util.*;



public class GPAReport
{
	//Desc:	The program reads the students' information stored in "data.txt", computes the GPA 
	//	of the students, and produces a report to file "report.txt"
	//Input:The input file "data.txt" contains the following items, one on each line:
	//	Student name (a string such as John Johnson)
	//	Number of course (an int such as 2)
	//	Course Name (a string such as Computer Science I)
	//	Credit hours (an int such as 4)
	//	Grade (any one of A+, A, A-, B+, B, B-, C+, C, C-, D+, D, D-, F)
	//	Course Name (e.g. Introduction to Art)
	//	Credit hours 
	//	Grade
	//Output:A report in the following format is printed to file "report.txt":
	//	Name		Courses			Credit Hours	Grade	
	//	-----------------------------------------------------------------------------------
	//	John Johnson	Computer Science I	4		A
	//			Introduction to Art	3		B
	//	GPA: 3.57
	public static void main(String[] args) throws FileNotFoundException
	{
		
		Scanner input = new Scanner(new File("data.txt"));
		PrintWriter output = new PrintWriter("report.txt");
		output.printf("%-20s%-25s%-15s%-5s\r\n", 
			      "Name", "Courses", "Credit Hours", "Grade");
		output.println("-----------------------------------------------------------------");
		
		while(input.hasNextLine())
		{
			double GP =0.0, totalCreditHr =0.0;
			String name = input.nextLine();
			int count = input.nextInt();
			input.nextLine();
			boolean first = true;
			for(int i = 0; i < count; i++)
			{
				String courseName = input.nextLine();
				int creditHr = input.nextInt();
				input.nextLine();
				String grade = input.nextLine();
				totalCreditHr += creditHr;
				GP += creditHr * findPoint(grade);
				if(first)
				{
					output.printf("%-20s%-25s%-15d%-5s\r\n", 
					              name, courseName, creditHr, grade);
					first = false;
				}	
				else output.printf("%-20s%-25s%-15d%-5s\r\n", 
				                   "", courseName, creditHr, grade);
			}
			output.printf("GPA: %5.2f\r\n" , GP/ totalCreditHr);
		}
		input.close();
		output.close();
	}
	
	//Pre:	ch represents a valid grade, which must be A+, A, A-, B+, B, B-, 
	//	C+, C, C-, D+, D, D-, or F
	//Return:	the grade point of ch
	public static double findPoint (String ch)
	{
		switch(ch)
		{
			case "A+": return 4.0;
			case "A": return 4.0;
			case "A-": return 3.7;
			case "B+": return 3.3;
			case "B": return 3.0;
			case "B-": return 2.7;
			case "C+": return 2.3;
			case "C": return 2.0;
			case "C-": return 1.7;
			case "D+": return 1.3;
			case "D": return 1.0;
			case "D-": return 0.7;
			default: return 0.0;

		}
	}
} 
