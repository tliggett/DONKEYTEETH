//TJ Liggett
//Homework 9
//SortPhoneBook.java

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class SortPhoneBook 
{  
     	//Desc: The program read the phonebook information from "phone.txt," sorts it in 
	//	ascending order, and prints it to "phoneSorted.txt"
	//Input: A file with filename "phone.txt" which contains phone entries in the following format:
	//	Name1 (a String like "John Johnson")
	//	Phone1 (a String like "605-222-2222")
	//	Name2
	//	Phone2
	//	…
	//	NameN
	//	PhoneN
	//Output:The phones entries in the PhoneBook object written to the file with filename 	
	//	"phoneSorted.txt" in the following format:
	//	Name1 (a String like "John Johnson")
	//	Phone1 (a Stirng like "605-222-2222")
	//	Name2
	//	Phone2
	//	…
	//	NameN
	//	PhoneN
	public static void main(String[] args) throws FileNotFoundException
	{		
		PhoneBook p=new PhoneBook();		
		p.load("phone.txt");
		p.sort();
		p.write("phoneSorted.txt");
	}
}

class PhoneBook
{  
	private Vector<String> names;				
	private Vector<String> phones;				
	//Post:	The PhoneBook object constructed.
	public PhoneBook() 
	{
		names = new Vector<String>();
		phones = new Vector<String>();
		System.out.println("Phone book constructed");
	}
	
	//Desc: 	Load the phone entries from a file into the PhoneBook object.
	//Input: 	A file with filename s which contains phone entries in the following format:
	//	Name1 (a String like "John Johnson")
	//	Phone1 (a String like "605-222-2222")
	//	Name2
	//	Phone2
	//	…
	//	NameN
	//	PhoneN
	//Post:	The names from s loaded in this PhoneBook's names Vector, the phones from s loaded in 
	//	this PhoneBook's phones Vector, so that the 2 Vectors are parallel.
	public void load(String s) throws FileNotFoundException	
	{
		Scanner scan = new Scanner(new File(s));
		while(scan.hasNextLine())
		{
			names.add(scan.nextLine());
			phones.add(scan.nextLine());
		}
		scan.close();
		System.out.println("Phone book loaded from file "+s);
	}
	//Desc: 	Sorts the PhoneBook object based on names
	//Post:	The names Vector sorted in ascending order.  The names and phones Vectors remain 
	//	parallel.
	public void sort()				
	{
		for(int pass = names.size()-1; pass >= 0; pass--)
		{
			for(int i = 0; i < pass; i++ )
			{
				if(names.get(i).compareTo(names.get(i+1)) > 0)
				{
					String temp = names.get(i);
					names.set(i, names.get(i+1));
					names.set(i+1, temp);
					String temp2 = phones.get(i);
					phones.set(i, phones.get(i+1));
					phones.set(i+1, temp2);
				}
			}
		}
		System.out.println("Phone book sorted");
	}
	//Desc: Write the phones entries in the PhoneBook object to a file.
	//Pre: 	s is the filename of the data file to be written.
	//Output:The phones entries in the PhoneBook object written to the file with filename s in the 
	//	following format:
	//	Name1 (a String like "John Johnson")
	//	Phone1 (a Stirng like "605-222-2222")
	//	Name2
	//	Phone2
	//	…
	//	NameN
	//	PhoneN
	public void write(String s) throws FileNotFoundException			
	{
		PrintWriter write = new PrintWriter(s);
		for(int i = 0; i < names.size(); i++)
		{
			write.println(names.get(i));
			write.println(phones.get(i));
		}
		write.close();
		System.out.println("Phone book written to file "+s);
	}
}

