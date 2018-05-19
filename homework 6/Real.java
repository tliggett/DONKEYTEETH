//TJ Liggett
//Homework 6
//Real.java
//Class Real wraps a double in an object. This class contains a single field of type double.


public class Real 
{
	private double dub;
	
	//Post: The newly allocated Real object initialized to d.  
	public Real (double d)
	{
		this.dub = d;
	}
	
	//Post: The double value of the Real object is set to d.
	public void set(double d)
	{
		this.dub = d;
	}
	
	//Return: The double value of the Real object.
	public double doubleValue()
	{
		return this.dub;
	}

	//Return: A String that represents the double value of the Real object.
	public String toString()
	{
		return "" + this.dub;
	}

	//Return: Comparison of this Real object to r.	
	public int compareTo(Real r)
	{
		if(this.doubleValue() > r.doubleValue())			
			return 1;
		if(this.doubleValue() < r.doubleValue())
			return -1;
		return 0;
	}

	
}