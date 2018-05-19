//TJ Liggett
//Homework 4
//RockPaperScissor.java

//Desc: This program simulates the game "rock, paper, scissors". Although 2 or more players can play the
// game, this program will only consider the case when there are 2 players (one is the computer
// itself). The program asks the player to call. The player can enter p for paper, r for rock, s for
// scissors. The winner is determined by the following rule: paper covers rock, rock breaks scissors,
// and scissors cut paper. If both players play the same thing, it is a tie.
//Input: The player enters p for paper, r for rock, s for scissors when prompted.
// The player can keep playing by entering y when prompted.
//Output: Various messages helping the user to play the game.
// A summary report is displayed before the program ends which states how many games the user
// won, how many games the user lost, and how many tie games.
// The duration of the game is also displayed before the program ends.

import java.util.Scanner;
import java.util.Random;
import java.util.Date;
public class RockPaperScissor
{
	public static void main(String[] args)
	{
		Scanner keyboard=new Scanner(System.in);
		Random r=new Random();
		char userCall='p', computerCall='p', again='y', result='u';
		int userWins=0, userLosses=0, userTies=0;
		Date d = new Date();
		System.out.println("Welcome! It is " + d.toString());
		while (again=='y')
		{
			System.out.print("Please call (p, r, s): ");
			userCall= keyboard.nextLine().charAt(0);
			computerCall=generateComputerCall(r);
			result=whoWin(computerCall, userCall);
			switch (result)
			{
				case 'u': 
				System.out.print("\tI have "+ computerCall+", you won. ");
				userWins++;
				break;
				case 'c': 
				System.out.print("\tI have "+ computerCall+", you lost. ");
				userLosses++;
				break;
				case 't': 
				System.out.print("\tI have "+ computerCall+", we tied. ");
				userTies++;
				break;
			}
			System.out.print("Play again? (y/n):");
			again= keyboard.nextLine().charAt(0);
		}
		printReport (userWins, userLosses, userTies);
		printTimeReport (d);
	}
	
	//Desc: returns random char 'r', 'p', or 'c'	
	public static char generateComputerCall(Random r)
	{
		int i = r.nextInt(3);
		char result = 'x';
		switch(i)
		{
			case 0:
			result = 'r';
			break;
			case 1:
			result = 'p';
			break;
			case 2:
			result = 'c';
			break;
		}
		return result;		
	}
	
	//Input: char data for Computer's call, char data for User's call
	//Desc: Receives User's call and Computer's call and returns result of the game
	//Return: 'c' for computer win; 'u' for user win; 't' for tie.
	public static char whoWin(char computerCall, char userCall)
	{
		char result = 'x';
		switch(computerCall)
		{
			case 'r':
			switch(userCall)
			{
				case 'r':
				result = 't';
				break;
				case 'p':
				result ='u';
				break;
				case 's':
				result ='c';
				break;
			}
			break;
			case 'p':
			switch(userCall)
			{	
				case 'r':
				result ='c';
				break;
				case 'p':
				result ='t';
				break;
				case 's':
				result ='u';
				break;
			}
			break;
			case 's':
			switch(userCall)
			{
				case 'r':
				result ='u';
				break;
				case 'p':
				result ='c';
				break;
				case 's':
				result ='t';
				break;
			}
			break;
		}
		return result;
	}
	
	//Input: Number of user wins, number of user losses, number of user ties.
	//Desc: Takes number of user wins, losses, and ties and outputs them to console
	//Output: Users wins, losses, and ties
	public static void printReport(int userWins, int userLosses, int userTies)
	{
		System.out.printf("You won %d games%n", userWins);
		System.out.printf("You lost %d games%n", userLosses);
		System.out.printf("You tied %d games%n", userTies);	
	}	

	//Input: Date d initialized at the beginning of the game.
	//Desc: Computes the seconds elapsed during the game and outputs to console
	//Output: The amount of time (in seconds) elapsed during the game
	public static void printTimeReport(Date d)
	{
		Date c = new Date();
		double seconds = (c.getTime() - d.getTime()) * 1000;
		System.out.printf("The game took %.2f seconds", seconds);
	}


}