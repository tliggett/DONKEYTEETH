//TJ Liggett
//Homework 5
//Dice.java
//Class Dice supports objects representing a pair of throwing dice. Each dice object
//knows the face value of both of its dice.

import java.util.Random;


public class Dice
{
	private int die1, die2;
	private Random r;
	
	//Post: Dice initialized randomly to a value in the range 1-6 each
	public Dice()
	{
		toss();	
	}
	
	//Post: Dice set randomly to a value in the range 1-6 each
	public void toss()
	{
		this.r = new Random();
		this.die1 = this.r.nextInt(6) + 1;
		this.die2 = this.r.nextInt(6) + 1;	
	}
	
	//Return: The summative value of the dice (die1 and die2)
	public int getTotal()
	{
		return die1 + die2;	
	}
	
	//Return: The value of each die, followed by the total value, all in String format.
	public String toString()
	{
		return "Die 1: " + die1 + " Die 2: " + die2 + " Total: " + getTotal();
	}
}