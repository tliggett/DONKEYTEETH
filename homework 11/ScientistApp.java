//TJ Liggett
//Homework 11
//Class ScientistApp tests class Scientist.

import java.util.Scanner;

public class ScientistApp
{
	//Input: Scientist's id (int), name (String), salary (double), and
	//	 number of publications (int).
	//Output: Various prompts for the user, and the created Scientist
	//	 with input fields.
	public static void main(String[] args)
	{
		Scientist scientist = new Scientist();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter ID: ");
		scientist.setId(input.nextInt());
		input.nextLine();
		System.out.println("Enter name: ");
		scientist.setName(input.nextLine());
		System.out.println("Enter salary: ");
		scientist.setSalary(input.nextDouble());
		input.nextLine();
		System.out.println("Enter number of publications: ");
		scientist.setNumPub(input.nextInt());
		input.nextLine();
		System.out.println(scientist);
		input.close();
	}		
}