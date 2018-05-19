//TJ Liggett
//Homework 6
//SphereApp.java
//Class SphereApp tests the methods for the Sphere class.

import java.util.Scanner;

public class SphereApp
{
	//Input: User inputs the radius of Sphere
	//Output: Various prompts for the user; Sphere radius, volume, and author.
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Sphere sphere = new Sphere();
		sphere.setRadius(12.2);
		System.out.println("Enter a radius for the sphere: ");
		sphere = new Sphere(scan.nextDouble());
		System.out.println("" + sphere);		
		
	
	}

}