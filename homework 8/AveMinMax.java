//TJ Liggett
//Homework 8
//AveMinMax.java
//Class AveMinMax reads from file of doubles "number.txt" and finds the min, max, and average.

import java.io.*;
import java.util.*;

public class AveMinMax
{
	
	//Desc: Takes in double values from file "number.txt" and prints them, then finds 
	//	minimum, maximum, and average values.
	//Pre: File "number.txt" must exist and contain only doubles
	//Input: takes double values from "number.txt"
	//Output: The file contents, followed by the average, min, and max values.
	public static void main(String[] args) throws FileNotFoundException
	{
						
		File number = new File("number.txt");
		Scanner scan = new Scanner(number);
		Vector<Double> list = new Vector<Double>();
		boolean first = true;
		while(scan.hasNextLine())
		{
			if(first) first = false;
			else scan.nextLine();
			while(scan.hasNextDouble())
			{
				Double d = scan.nextDouble();
				list.add(d);
				System.out.println(d);
			}
			
		}
		System.out.println("The file has: " + fileContent(list));
		System.out.println("The average is " + findAverage(list));
		System.out.println("The min is " + findMin(list));
		System.out.println("The max is " + findMax(list));

	}
	
	//Return: Maximum double value in Vector<Double> list.
	public static double findMax(Vector<Double> list)
	{
		double max = Double.MIN_VALUE;
		for(Double d : list)
			if(d > max) max = d;
		return max;		
	}	
	
	//Return: Minimum double value in Vector<Double> list.
	public static double findMin(Vector<Double> list)
	{	
		double min = Double.MAX_VALUE;
		for(Double d : list)
			if(d < min) min = d;
		return min;
	}
	
	//Return: Average double value in Vector<Double> list.
	public static double findAverage(Vector<Double> list)
	{
		double sum = 0.0;
		for(Double d : list)
			sum += d;
		return sum/list.size();
	}

	//Return: String of doubles in list separated by white space.
	public static String fileContent(Vector<Double> list)
	{
		String s = "";	
		for(Double d : list)
			s += d + " ";
		return s;
	}

}