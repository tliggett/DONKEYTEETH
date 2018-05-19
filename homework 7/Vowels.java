//TJ Liggett
//Homework 7
//Vowels.java
//Class Vowels reads a line from the keyboard and displays the number of each vowel in the input line.

import java.util.Scanner;


public class Vowels
{
	//Desc : Reads a line from the keyboard and displays the number of vowels in the input line. 
	//	 The program continues to process another line and so on until the user selects to quit.
	//Input :  Repeatedly, a line entered from the keyboard followed by either 'y' or 'n' to repeat.
	//Output:The number of each vowel (lowercase and uppercase combined) in the input line just read  
	//	 printed on the screen, along with appropriate prompt messages.
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		boolean playing = true;
		while(playing)
		{	
			System.out.println("Enter a line: ");
			String s = scan.nextLine();
			printNumOfVowels(s);
			char c = ' ';
			while(c != 'y' && c != 'n')
			{
				System.out.println("Again? <y/n>: ");
				c = scan.nextLine().toLowerCase().charAt(0);
			}
			if(c == 'n'){
				playing = false;
			}
		}
	}

	
	//Output:The number of each vowel (lowercase and uppercase combined) in String s printed
	//	 on the screen.
	public static void printNumOfVowels(String s)
	{
		s = s.toLowerCase();
		System.out.printf("There are %d a's\n", NumOfChar(s, 'a'));
		System.out.printf("There are %d e's\n", NumOfChar(s, 'e'));
		System.out.printf("There are %d i's\n", NumOfChar(s, 'i'));
		System.out.printf("There are %d o's\n", NumOfChar(s, 'o'));
		System.out.printf("There are %d u's\n", NumOfChar(s, 'u'));
			
	}
	
	//Return: Count of character c in String s.
	public static int NumOfChar(String s, char c)
	{
		int count = 0;
		for(int i = 0; i < s.length(); i++)
		{
			if(c == s.charAt(i)) count++;		
		}
		return count;
	}


}