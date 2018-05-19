//TJ Liggett
//Homework 5
//Box.java
//Class Box supports objects representing a three-dimensional Box. Each Box object
//Knows its height, width, length, surface area, and volume.



public class Box
{
	private double height, width, length;	
	//Post: Height, width, and length of this box initialized to 0.0;
	public Box()
	{
		setHeight(0.0);
		setWidth(0.0);
		setLength(0.0);	
	}
	//Pre: Height, width, and length must be positive
	//Post: Height, width, and length of this box initialized to 0.0;
	public Box(double height, double width, double length)
	{
		setHeight(height);
		setWidth(width);
		setLength(length);					
	}

	//Pre:	h must be positive.
	//Post:	Height of this Box initialized to h
	public void setHeight(double h)	
	{
		this.height = h;
	}
	
	//Pre:	w must be positive.
	//Post:	Width of this Box initialized to w
	public void setWidth(double w)
	{
		this.width = w;
	}

	//Pre:	l must be positive.
	//Post:	Length of this Box initialized to l
	public void setLength(double l)
	{
		this.length = l;
	}

	//Return: height of this Box
	public double getHeight()
	{
		return this.height;
	}


	//Return: width of this Box
	public double getWidth()
	{
		return this.width;
	}

	//Return: length of this Box
	public double getLength()
	{
		return this.length;
	}


	//Return: Surface Area of this Box (SA = 2hw + 2hl + 2lw)
	public double getSurfaceArea()
	{
		return (2*this.height*this.width) + (2*this.height*this.length) + (2*this.length*this.width);
	}
	
	//Return: Volume of this Box (V = hlw)
	public double getVolume()
	{
		return this.height * this.width * this.length;
	}

	//Return: The height, width, length, surface area, volume in String format
	public String toString()
	{
		return "Box height: " + height + " width: " + width + " length: " + length + 
			" surface area: " + getSurfaceArea() + " volume: " + getVolume();
	}


}