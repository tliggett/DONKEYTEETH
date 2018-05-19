//TJ Liggett
//Homework 5
//DiceApp.java
//Class DiceApp tests the methods in class Dice, allowing user to roll a pair of dice

import java.util.Scanner;

public class DiceApp
{
	//Input: User inputs enter to roll dice
	//Output: The outcome of each dice roll, including the amount on each die
	//        and the total of the two dice 
	public static void main(String[] args)
	{
		Dice dice = new Dice();
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			System.out.println("Hit enter to throw your dice.");
			scan.nextLine();
			dice.toss();
			System.out.println("Throwing... " + dice);
		}	
	}
}