//TJ Liggett
//Homework 6
//RealApp.java
//Class RealApp tests the methods in class Real.

import java.util.Scanner;

public class RealApp
{
	//Input: User inputs Real a and b
	//Output: Various prompts for the user; Real a, Real b, a+b, and 
	//	  whether a is greater than b.
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Real (double) a:");
		Real a = new Real(scan.nextDouble());
		System.out.println("Enter Real (double) b:");
		Real b = new Real(scan.nextDouble());
		System.out.println("Real a: " + a + " Real b: " + b);
		Real c = new Real(a.doubleValue() + b.doubleValue());
		System.out.println("a + b = " + c);
		int x = a.compareTo(b);
		switch(x)
		{
			case 1: System.out.println("a is greater than b.");
			break;
			case 0: System.out.println("a equals b.");
			break;
			case -1: System.out.println("a is less than b.");			
			break;
		}		

	}
}