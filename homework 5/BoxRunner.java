//TJ Liggett
//Homework 5
//BoxRunner.java
//Class BoxRunner tests the methods for the Box class

import java.util.Scanner;

public class BoxRunner
{
	
	//Input: User inputs the height, width, and length for the Box
	//Output: Various prompts for the user; Box height, width, length,
	//	  surface area, and volume.
	//Note: I found it inefficient to use both constructors, but the assignment
	//stated a point would be docked for each untested method, so I tested both.
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Box box = new Box();
		double height, width, length;
		height = width = length = 0.0;
		System.out.print("Please enter height: ");
		height = scan.nextDouble();
		System.out.print("Please enter width: ");
		width = scan.nextDouble();
		System.out.print("Please enter length ");
		length = scan.nextDouble();
		box = new Box(height, width, length);
		System.out.println("" + box);
		
	}

}