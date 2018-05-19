//TJ Liggett
//Homework 6
//Sphere.java
//Class Sphere supports objects representing a sphere. Each Sphere object
//Knows its radius and volume.



public class Sphere
{

	private double radius;
	
	//Post: radius of this sphere initialized to 0.0.
	public Sphere()
	{
		this.radius = 0.0;
	}

	//Pre: r must be positive.
	//Post: radius of this sphere initialized to r.
	public Sphere(double r)
	{
		this.radius = r;
	}

	//Pre: r must be positive.
	//Post: radius of this sphere initialized to r.
	public void setRadius(double r)
	{
		this.radius = r;
	}
	
	//Return: radius of this Sphere.
	public double getRadius()
	{
		return this.radius;
	}

	//Return: Volume of this Sphere.
	public double getVolume()
	{
		return 4/3 * Math.PI * Math.pow(radius, 3);
	}

	//Return: The name of the author of this class (me, TJ Liggett).
	public String author()
	{
		return "T.J. Liggett";
	}

	//Return: The radius and volume of the sphere, as well as the author of the class.
	public String toString()
	{
		return "Sphere radius: " + getRadius() + " volume: " + getVolume() +
		"\n*Sphere class created by " + author() + "*";
	}
}