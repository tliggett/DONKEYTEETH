//TJ Liggett
//Homework 9
//StudentDB.java
//Class StudentDB stores Student objects and writes them to a file

import java.util.Scanner;
import java.util.Vector;
import java.io.*;
public class StudentDB
{  
	public static Scanner keyboard=new Scanner(System.in);
	//Desc: 	Maintains a database of Student records.  The database is the text file Student.txt.
	//Input:	User enters commands from keyboard to manipulate database.
	//	The database Student.txt, which contains student information as follows:
	//	id
	//	name
	//	age
	//	major
	//	id
	//	name
	//	age
	//	major
	//	…
	//Output:Various messages.
	//	Database Student.txt updated as directed by user.
     	public static void main(String[] args) throws IOException
   	{
		Vector<Student> v=new Vector<Student>();
   		File f=new File("Student.txt");
		if (f.exists()) loadStudent(v);
		int choice=6;					
		do {
			System.out.println("\t1. Add a Student record");	
			System.out.println("\t2. Remove a Student record");	
   			System.out.println("\t3. Print a Student record");	
   			System.out.println("\t4. Print all Student records");	
   			System.out.println("\t5. Update a Student");
			System.out.println("\t6. Quit");
			choice= keyboard.nextInt();					
   			switch (choice)						
			{
				case 1: addStudent(v); break;		
				case 2: removeStudent(v); break;		
				case 3: printStudent(v); break;		
				case 4: printAllStudent(v); break;		
				case 5: updateStudent(v); break;
				default:  break;	
			}
		} while (choice!=6);
 		storeStudent(v); 
	}		
  	//Input: 	Text file Student.txt must exist and contains student records.
	//Post: 	All records in Student.txt loaded into vector v.
    	public static void loadStudent(Vector<Student> v) throws FileNotFoundException
	{
   		System.out.println("Loading database ...");	
		Scanner f=new Scanner(new File("Student.txt"));
		for(Student s : v)
			s.read(f);
		f.close();
	}

	//Input: user enters an integer (id), a string (name), an integer (age),  
	//	and a String (major) from the keyboard all on separate lines
	//Post: The input record added to v if id does not exist
	//Output: various prompts as well as "Student added" or "Add failed: Student already exists" 
	//	printed on the screen accordingly
    	public static void addStudent(Vector<Student> v) 
	{
		Student stu=new Student();
		System.out.print("Student ID:");
		stu.setId(keyboard.nextInt());
		keyboard.nextLine();	
		for(Student s : v)
			if(s.equals(stu))
			{
				System.out.println("Add failed: Student already exists");
				return;
			}				
		System.out.print("Student name:");
		stu.setName(keyboard.nextLine());						
		System.out.print("Student Age:");
		stu.setAge(keyboard.nextInt());	
		keyboard.nextLine();					
		System.out.print("Student Major: ");
		stu.setMajor(keyboard.nextLine());
		v.add(stu);
		System.out.println("Student added");
	}
	
	//Input: user enters an integer (id) from the keyboard	
	//Post: The record in v whose id field matches the input removed from v.
	//Output: various prompts as well as "Student removed" or "Remove failed: Student does not 
	//	exist" printed on the screen accordingly
    	public static void removeStudent(Vector<Student> v) 
	{
		System.out.print("Student ID:");
		int id= keyboard.nextInt();						
		boolean removed = false;
		for(int i = v.size()-1; i >= 0; i--)
		{
			if(v.get(i).getId() == id) 
			{
				v.remove(i);
				removed = true;
				System.out.println("Student removed");
			}	
		}
		if(!removed) System.out.println("Remove failed: Student does not exist");
	}
	//Input: 	user enters an integer (id) from the keyboard	
	//Output: various prompts as well as the record in v whose id field matches the input printed on the 
	//	screen or "Print failed: Student does not exist" printed on the screen accordingly
       	public static void printStudent(Vector<Student> v) 
	{
		System.out.print("Student ID:");
		int id = keyboard.nextInt();						
		for(Student s : v)
			if(s.getId() == id)
			{
				System.out.println(s);
				return;
			}
		System.out.println("Print failed: Student does not exist");
	}
   	//Output: All records in v printed on the screen.
	public static void printAllStudent(Vector<Student> v) 
	{
		for(Student s : v)
			System.out.println(s);
	}
	//Input: Student ID, followed by y\n chars and possible id, name, age, 
	//	 and major fields.
	//Post:  ID, Name, Age, and Major of student changed
	//Output: Various prompts for the user, asking for Student ID and
	//	  which data fields to change
	public static void updateStudent(Vector<Student> v)
	{
		System.out.print("Student ID:");
		int id = keyboard.nextInt();	
		keyboard.nextLine();					
		for(Student s : v)
			if(s.getId() == id)
			{
				System.out.print("ID: " + s.getId() + " Change y/n: ");
				char s1 = keyboard.nextLine().toLowerCase().charAt(0);
				if(s1 == 'y')
				{
					System.out.print("Student ID:");
					s.setId(keyboard.nextLine());
				}				
				System.out.print("Name: " + s.getName() + " Change y/n: ");
				char s1 = keyboard.nextLine().toLowerCase().charAt(0);
				if(s1 == 'y')
				{
					System.out.print("Student name:");
					s.setName(keyboard.nextLine());
				}
				System.out.println("Age: " + s.getAge() + " Change y/n: ");
				s1 =  keyboard.nextLine().toLowerCase().charAt(0);
				if(s1 == 'y')
				{
					System.out.print("Student Age:");
					s.setAge(keyboard.nextInt());	
					keyboard.nextLine();
				}
				System.out.println("Major: " + s.getMajor() + " Change y/n: ");
				s1 =  keyboard.nextLine().toLowerCase().charAt(0);
				if(s1 == 'y')
				{
					System.out.print("Student Major: ");
					s.setMajor(keyboard.nextLine());
				}
				System.out.println("Student updated.");
				return;
			}
		System.out.println("Student does not exist");

	}
	//Output: All records in v written to text file Student.txt.
    	public static void storeStudent(Vector<Student> v) throws FileNotFoundException
	{
  		System.out.println("Saving database ...");	
		PrintWriter f = new PrintWriter("Student.txt");
		for(Student s : v)
			s.write(f);
		f.close();
		System.out.println("Database saved.");
	}
}
