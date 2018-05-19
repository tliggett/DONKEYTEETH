//TJ Liggett
//Homework 11
//Class Scientist has id, name, salary, and number of publications of a scientist employee

public class Scientist extends Employee
{

	//Post: Id, name, salary, and number of publications (numPub) of this  
	//	Scientist initialized to -1, "unknown", -1.0, -1.
	private int numPub;
	public Scientist()
	{
		super();
		numPub = -1;
	}
	
	//Post: Id, name, salary, and number of publications (numPub) of this Scientist 
	//	initialized to the parameters id, name, salary, and numPub.
	public Scientist(int id, String name, double salary, int numPub)
	{
		super(id, name, salary);
		this.numPub = numPub;
	}
	
	//Post: Number of publications (numPub) of this Scientists set to numPub.
	public void setNumPub(int numPub)
	{
		this.numPub = numPub;
	}
	
	//Return: Number of publications (numPub) of this Scientist
	public int getNumPub()
	{
		return this.numPub;
	}

	public String toString()
	{
		return super.toString() + " Number of Publications: " + numPub;
	}

}