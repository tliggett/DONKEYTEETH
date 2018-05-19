//TJ Liggett
//Homework 9
//Student.java
//Class Student hold a student's id, name, age, and major. Student can be written to a text file.

import java.util.Scanner;
import java.io.PrintWriter;

public class Student
	{

      	private int id;
   	private String name;
	private int age;
	private String major;

	//Post:	Id, name, age, major of this Student initialized to -1, "unknown", -1, "unknown" 
	public Student () 
	{ 
		id = -1; 
		name="unknown"; 
		age = -1; 
		major = "unknown";
	}
	//Post:	Id, name, age, major of this Student initialized to the parameters id, name,
	//	age, and major.
	public Student (int id, String name, int age, String major) 
	{ 
		this.id = id; 
		this.name=name; 
		this.age = age; 
		this.major = major;
	}
	//Post:	Id of this Student set to s
	public void setId( int s ) 
	{ 
		id = s; 
	}
	//Return:	Id of this Student
   	public int getId() 
	{ 
		return id; 
	}
	//Post:	Name of this Student set to s
	public void setName(String s) 
	{ 
		name=s;
	}
	//Return:	Name of this Student
   	public String getName() 
	{ 
		return name; 				
	}
	//Post:	Age of this Student set to s
	public void setAge( int s ) 
	{ 
		age = s; 
	}
	//Return:	Age of this Student
   	public int getAge()
	{ 
		return age; 
	}
	//Post: Major of this Student set to m
	public void setMajor( String m )
	{
		major = m;
	}
	//Return:	Major of this Student
	public String getMajor()
	{
		return major;
	}
	//Return:	true if id of this Student == id of obj, false otherwise
	public boolean equals(Object obj)	
	{
		Student s = (Student) obj;
		if(this.id == s.id) return true;
		return false;
	}
	//Return:	1 if id of this Student > id of stu
	//	0 if id of this Student == id of stu
	//	-1 if id of this Student < id of stu
	public int compareTo(Student stu)				
	{
		if(this.id == stu.id) return 0;
		if(this.id > stu.id) return 1;
		return -1;			
	}
	//Return:The id, name, age, major of this Student in the format "ID: id Name: 
	//	 name Age: age Major: major" 
	public String toString()
	{
                return "ID: "+ id +" Name: "+name+" Age: "+age+" Major: "+major;
	}
	//Pre: 	f is a text file ready to be read with 4 lines of input: id, name, age, and major.
	//Post:	The 4 lines of input from f read into this Student object.
	public void read(Scanner f) 
	{ 
		id = Integer.parseInt(f.nextLine());
		name = f.nextLine();
		age = Integer.parseInt(f.nextLine());
		major = f.nextLine();	
	}
	//Pre: 	f is a text file ready to be written 
	//Post:	This Student object written to f as 4 lines: id, name, age, and major.
	public void write(PrintWriter f) 
	{ 
		f.println(id);
		f.println(name);
		f.println(age);
		f.println(major);
	}
}
