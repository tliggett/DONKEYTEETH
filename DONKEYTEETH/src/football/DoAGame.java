package football;

import static java.lang.System.*;

import java.awt.Container;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import football.footballSimMethods;


public class DoAGame{
	

	int yds, yds2go, intDist, intDist2, intDist3, intDist4, intDown, yardsGained, intDist2Touch;
	double yardsgained;
	String run, pass, down;
	public String PLAY;
	char r, p;
	String play;
	Scanner gage = new Scanner(System.in);
	
		
		
	
	
	public void DoAGame() throws FileNotFoundException

	{
		Playbook Playbook1 = new Playbook();
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
		
		
		Playbook1.readfile();
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

	
	
}
