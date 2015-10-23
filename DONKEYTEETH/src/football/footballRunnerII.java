package football;

import static java.lang.System.*;

import java.awt.Container;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;

public class footballRunnerII {

	int yds2go, intDist, intDist2, intDist3, intDist4, intDown, yardsGained, intDist2Touch;
	double yds, yardsgained;
	String run, pass, PLAY;
	char r, p;
	String play;
	Scanner gage = new Scanner(System.in);

	public footballRunnerII()

	{

		footballSimMethods donkeyteeth = new footballSimMethods();
		// intDown = 1;
		intDown++;
		intDist = 10;
		yds2go = 80;
		
		while (intDown <= 4 && yds2go >= 0) {
			out.println("Down: " + intDown);
			out.println("Distance: " + intDist);
			out.println("Yards Gained: " + yardsgained);
			out.println("Yard Until Touchdown: " + yds2go);
			PLAY = gage.next();
			
			

			if (PLAY.equals("run")) {
				yds = donkeyteeth.yds();
			} else if (PLAY.equals("pass")) {
				yds = donkeyteeth.yods();
			} else {
				out.println("Text Error: Please Retry");
				PLAY = gage.next();
			}
			
			intDist= (int) (intDist-yds);
			intDown++;
			yardsgained = (yds);
			yds2go = (int) (yds2go-yds);
			
			
			if (intDist <= 0) {
				intDown = 1;
				intDist = 10;

			}
			
		}
		if (yds2go <= 0) {
			out.print("TOUCHDOWN");
			
		}
		if (intDown > 4) {
			out.print("TURNOVER");
		}
	}

	public static void main(String args[]) {
		
		
		// The name of the file to open.
        String fileName = "data/temp.txt";

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
                System.out.println(line);
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
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        footballRunnerII run = new footballRunnerII();
	}
}
