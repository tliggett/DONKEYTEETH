package football;

import static java.lang.System.*;

import java.awt.Container;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import football.footballSimMethods;
import football.GraphicsRunner;

public class footballRunnerII {

	int yds, yds2go, intDist, intDist2, intDist3, intDist4, intDown, yardsGained, intDist2Touch;
	double yardsgained;
	String run, pass, PLAY, down;
	char r, p;
	String play;
	Scanner gage = new Scanner(System.in);
	public footballRunnerII() {
		boolean playagain = true;
		while (playagain) {
		DoAGame();
		out.println("Exit Game?");
		if(gage.next().toLowerCase().equals("yes"))
			playagain=false;
		}
		
		out.println("Quitter");
	}
	
	public void DoAGame()

	{

		footballSimMethods donkeyteeth = new footballSimMethods();
		Scoreboard Scoreboard1 = new Scoreboard();
		//FootbalGraphicsRunner project = new FootbalGraphicsRunner();
		//GraphicsRunner pictures = new GraphicsRunner();
		// intDown = 1;
		/*intDown++;
		intDist = 10;
		yds2go = 80;
		down = "1st";
		PLAY = "nothing";
		yds = 0;*/
		
		Scoreboard1.StartGame();
		
		while (Scoreboard1.GameIsAlive()){
			out.println("--------------");
			out.println(Scoreboard1.ReportScore());
			out.println(Scoreboard1.ReportDownAndDistance());			
			out.println(Scoreboard1.ReportYardsToEndzone());
			out.println(Scoreboard1.PromptForPlay());
			PLAY = Scoreboard1.nextPlay();
			yds = donkeyteeth.nextPlay(PLAY, Scoreboard1.yardline);
			String Result = Scoreboard1.UpdateScoreboardAfterPlay(yds,PLAY);
			out.println(Result);
			if(Scoreboard1.Jumbotron.length()> 0){
				out.println("===============");
				out.println(Scoreboard1.ReportDriveResult());
				out.println(Scoreboard1.ReportScore());
				out.println("Press Enter to Continue");
				gage.next();
				
			}
		}
		
		out.println("Final Score: " + Scoreboard1.ReportScore());
	}

	
	
	private void Switch(String down2) {
		// TODO Auto-generated method stub
		
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
