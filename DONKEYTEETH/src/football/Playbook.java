package football;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Playbook {
	
	
	int[] pass={0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	-5,	-5,	-5,	-10,	-10,	-10,	-10,	-10,	-10,	5,	5,	5,	5,	5,	5,	5,	5,	5,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	10,	10,	10,	10,	10,	10,	10,	10,	10,	15,	15,	15,	15,	20,	20,	20,	20,	20,	20,	40,	40,	40,	-777,	-777,	-777,	-777,	-555,	-555,	-555,	-555,	100 };


public int [] pass(){
	
	
	return pass;
}
	public static boolean IsValidPlay(String PLAY) {
		if(PLAY.)
		if (PLAY.equals("fg"))
			return true;
		if (PLAY.equals("punt"))
			return true;
		return false;
	}
		
	public void readfile() throws FileNotFoundException{
		Play Playx,
		String[]playlist ={Playi};	
			// The name of the file to open.
			String fileName = "data/playslist.csv";
		
			        // This will reference one line at a time
			       String line = null;
			
			        try {
		            // FileReader reads text files in the default encoding.
			            FileReader fileReader = 
			              new FileReader(fileName);
			
			            // Always wrap FileReader in BufferedReader.
			            BufferedReader bufferedReader = 
			              new BufferedReader(fileReader);
			
			           while((line = bufferedReader.readLine()) != null) {
			                String []ls = line.split(",");
			                Playx = ls[0] 
			            }   
			
			            // Always close files.
			            bufferedReader.close();         
		        }
			        catch(FileNotFoundException ex) {
			           System.out.println(
			                "Unable to open file '" + 
			               fileName + "'");                
			      }
			        catch(IOException ex) {
			            System.out.println( "Error reading file '" 
			                + fileName + "'");                  
			            // Or we could just do this: 
			            // ex.printStackTrace();
			        
			        }
			     
	return 	"house";
	}

		
		
	}
	
	
	
	

