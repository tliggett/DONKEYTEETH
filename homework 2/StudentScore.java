//TJ Liggett
//Homework 2
//StudentScore.java

import java.util.Scanner;
public class StudentScore
{
	//Desc: 	Calculates the total score for 1 student in a class. The scores are stored in a 3-dim array 
	//	named scores. The first index in scores refers to a student, the second refers to an exam, 
	//	and the third refers to the part of the exam. There are 7 students, 5 exams, and each exam 
	//	has 2 parts--the multiple-choice part and the programming part. So, scores[i][j][0] 
	//	represents the score on the multiple-choice part for the i’s student on the j’s exam
	//input:	The id of a student, must be in range 0-6
	//output:The total score of student id printed on the screen.
	public static void main(String[] args)
	{
    		double[][][] scores = {	{{7.5, 20.5}, {9.0, 22.5}, {15, 33.5}, {13, 21.5}, {15, 2.5}},
      					{{4.5, 21.5}, {9.0, 22.5}, {15, 34.5}, {12, 20.5}, {14, 9.5}},
      					{{6.5, 30.5}, {9.4, 10.5}, {11, 33.5}, {11, 23.5}, {10, 2.5}},
      					{{6.5, 23.5}, {9.4, 32.5}, {13, 34.5}, {11, 20.5}, {16, 7.5}},
      					{{8.5, 26.5}, {9.4, 52.5}, {13, 36.5}, {13, 24.5}, {16, 2.5}},
      					{{9.5, 20.5}, {9.4, 42.5}, {13, 31.5}, {12, 20.5}, {16, 6.5}},
      					{{1.5, 29.5}, {6.4, 22.5}, {14, 30.5}, {10, 30.5}, {16, 6.0}}};
		Scanner f=new Scanner(System.in);
		System.out.print("Student id (0-6): ");
		int id=f.nextInt();
		while (!legal(id))
		{
			System.out.print("0-6 please: ");
			id=f.nextInt();
		}
		double totalScore = getScores(scores, id);
		System.out.println("Student " + id + " score: " + totalScore);
  	}
	

	//Desc: 	Compute the total score of a student
	//Return:	the total score of student id
	public static double getScores(double[][][] scores, int id)
	{
		double result = 0;
		for(int i = 0; i < scores[id].length; i++)
			for(int j = 0; j < scores[id][i].length; j++)
				result += scores[id][i][j];
		return result;
	}
	//Desc: 	Check if an id is legal
	//Return:	True if id is in [0..6], false otherwise
	public static boolean legal(int id)
	{
		if(id >= 0 && id < 7)
			return true;
		return false;
	}
	}
