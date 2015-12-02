package football;

import static java.lang.System.out;

import java.awt.Image;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Scoreboard {
	Scanner gage = new Scanner(System.in);
	public int yardline = 80;
	public static int power =0;
	int yardstofirst = 10;
	int down = 1;
	String Megatron = "";
	String Jumbotron = "";
	Team HomeTeam, AwayTeam;
	int HomeScore, AwayScore;
	boolean HomeHasBall = false;
	public static double clock = 15;
	public static int quarter = 1;
	public int quarterlength = 5;
	
	
	
	public void StartGame(String[][] infotec) {
		
		
		
		
		HomeScore = 0;
		AwayScore = 0;
		
		//Information about the Home Team
		HomeTeam = new Team();
		HomeTeam.name = infotec[0][0];
		HomeTeam.isCPU = Boolean.valueOf(infotec[0][1]);
		HomeTeam.overall = Integer.parseInt(infotec[0][2]);
		HomeTeam.momentum = 0;
		HomeTeam.passO = Integer.parseInt(infotec[0][3]);
		HomeTeam.runO = Integer.parseInt(infotec[0][4]);
		HomeTeam.passD = Integer.parseInt(infotec[0][5]);
		HomeTeam.runD = Integer.parseInt(infotec[0][6]);
	
		
		// Information about the Away Team
		AwayTeam = new Team();
		AwayTeam.name = infotec[1][0];
		AwayTeam.isCPU =  Boolean.valueOf(infotec[1][1]);
		AwayTeam.overall = Integer.parseInt(infotec[1][2]);
		AwayTeam.momentum = 0;
		AwayTeam.passO = Integer.parseInt(infotec[1][3]);
		AwayTeam.runO = Integer.parseInt(infotec[1][4]);
		AwayTeam.passD = Integer.parseInt(infotec[1][5]);
		AwayTeam.runD = Integer.parseInt(infotec[1][6]);
		
		//Setting up Scoreboard
		HomeHasBall = true;
		Megatron = "";
		Jumbotron = "";
		
		//Setting up Clock Mechanism
		clock = 100*quarterlength;
		quarter = 1;
		StartDrive();

	}
	
	public void setPower(String PLAY){
		
		/*This method sets up the "power" of a team.
		* At this point, power is based on the difference in overalls of the teams
		* As well as the momentum a team has. 
		*/
		if(Playbook.IsRun(PLAY)){
			int difference = HomeTeam.runO-AwayTeam.runD;
			HomeTeam.power = difference + HomeTeam.momentum;
			
			difference = AwayTeam.runO - HomeTeam.runD;
			AwayTeam.power = difference + AwayTeam.momentum;
		}else{
			int difference = HomeTeam.passO - AwayTeam.passD;
			HomeTeam.power = difference + HomeTeam.momentum;
			
			difference = AwayTeam.passO - HomeTeam.passD;
			AwayTeam.power = difference + AwayTeam.momentum;
			
			
			
		}
		
		
		
		if(HomeHasBall){
			power = HomeTeam.power/5;
			
		}else{
			power = AwayTeam.power/5;
			
		}
		
		
		
		
	}
	
	public void updateStats(int stat, int increase){
		
		//This method is in place to update the statistics of a team after each play.
		 if(HomeHasBall){
		HomeTeam.stats[stat] += increase;
		}else{
		AwayTeam.stats[stat] += increase;	
		 }
		
		//0 Score
		//1 Rush Yards
		//2 Pass Yards
		//3 TOP
		//4 Turnovers
		
	}

	public int [][] Statbook(){
		//An int array that contains the stats of both teams.
		int[][] ret = new int[2][5];
		ret[0][0] = HomeScore;
		ret[1][0] = AwayScore;
		for(int i = 1; i<5; i++){
			ret[0][i] = HomeTeam.stats[i]; 
		}
		for(int i = 1; i<5; i++){
			ret[1][i] = AwayTeam.stats[i]; 
		}
		
		
		return ret;
	}
	
	public String[] TeamNames(){
		
		//Because Strings don't fit into an int array. Will eventually be used for other String stats.
		String[]ret = new String[2];
		
		ret[0] = HomeTeam.name;
		ret[1] = AwayTeam.name;
		
		return ret;
	}
	
	public void updateMomentum(int sway){
		//Updates the momentum of each team.
		if(HomeHasBall){
			HomeTeam.momentum += sway;
			
		}else{
			
			AwayTeam.momentum += sway;
		
	}
		
		
	}
	
	public void updateClock(double time){
		//Updates the clock after every play.
		clock = clock - time;
		updateStats(3, (int) time);
		if(clock <= 0){
			quarter ++;
			clock =100*quarterlength;
			QuarterChanged = true;
			
		}
		
	
		
	}
	 
	public Team TeamWithBall(){
		//Currently out of use...
		if(HomeHasBall){
			return HomeTeam;
			
		}
		
		return AwayTeam;
	}
	
	private boolean QuarterChanged = false;
	
	public void CheckForQuarterChange(){
		//Sets up Halftime if the time is right
		if(QuarterChanged){
			
			if(quarter == 3){
				HomeHasBall = false;
				StartDrive();
				
				Jumbotron += "\n HALFTIME";
				
				
			}
			
			
			
			QuarterChanged = false;
		}
		
		
		
		
		
	}

	private void UpdateScore(int ScoreChange) {
		//Updates the score during a score change
		if (HomeHasBall)
			HomeScore += ScoreChange;
		else
			AwayScore += ScoreChange;

	}

	public String nextPlay(String play) {

		//Part of the Next play series that determines how a play will be called.
		if (HomeHasBall) {
			return HomeTeam.nextPlay(this, play);
		} else {
			return AwayTeam.nextPlay(this, play);

		}

	}

	public String PromptForPlay() {
		
		//Designed to prompt a user for their next action, based on whether a player or CPU has the ball.
		if (HomeHasBall && HomeTeam.isCPU)
			return (HomeTeam.name + " have the ball. Press GO to Continue.");
		if (HomeHasBall && !HomeTeam.isCPU)
			return (HomeTeam.name + " choose your play");
		if (!HomeHasBall && AwayTeam.isCPU)
			return (AwayTeam.name + " have the ball. Press GO to Continue.");
		else
			return (AwayTeam.name + " choose your play");
	}

	public String UpdateScoreboardAfterPlay(int yardsgained, String PLAY) {
		
		//The grand machismo of all the methods. This updates the Scoreboard after a play.
		footballSimMethods donkeyteeth = new footballSimMethods();
		double yardsbeforeturnover = 0;
		int yardline1 = 0;
		Jumbotron = "";
		
		if (yardsgained == -555) {
			yardsbeforeturnover = donkeyteeth.nextPlay(PLAY, yardline);
			yardline -= yardsbeforeturnover;
			yardline1 = 100 - yardline;
			if(yardline1 >99){
				yardline1 =80;
			}
			updateMomentum(-1);
			updateStats(4, 1);
			HomeHasBall = !HomeHasBall;
			if (yardline1 < 0) {
				Jumbotron = ("He's gonna take it in for six! Touchdown!");
				Megatron = ("The Fumble was recovered by the defense!");
				UpdateScore(7);
				updateClock(25);
				updateMomentum(1);
				HomeHasBall = !HomeHasBall;
				updateMomentum(-1);
				StartDrive();
				return Megatron;
			} else {
				Megatron = ("FUMBLE Recovered by the Defense!!!");
				Jumbotron = ("It's going the other way!");
				updateClock(15);
				updateMomentum(1);
				StartDrive();
				yardline = yardline1;
				return Megatron;
			}
		} else if (yardsgained == -777) {
			yardsbeforeturnover = (int) donkeyteeth.nextPlay(PLAY, yardline);
			yardline -= yardsbeforeturnover;
			yardline1 = 100 - yardline;
			if(yardline1 >99){
				yardline1 =80;
			}
			updateMomentum(-1);
			updateStats(4, 1);
			HomeHasBall = !HomeHasBall;
			if (yardline1 < 0) {
				Jumbotron = ("PICK SIX!!!!!");
				Megatron = ("The Pass is intercepted, he's got green grass the other way!");
				UpdateScore(7);
				updateClock(50);
				updateMomentum(1);
				HomeHasBall = !HomeHasBall;
				updateMomentum(-1);
				StartDrive();
				return Megatron;
			} else {
				Megatron = ("Pass is intercepted!!!");
				Jumbotron = ("It's going the other way!");
				updateClock(25);
				StartDrive();
				updateMomentum(1);
				yardline = yardline1;
				return Megatron;
			}
		} else if (PLAY.equals("fg")) {
			Megatron = "Field Goal attempt of " + (yardline + 14) + " yards";
			if (yardsgained == 1) {
				Jumbotron = ("The Field Goal attempt is good!!!");
				UpdateScore(3);
				updateClock(10);
				HomeHasBall = !HomeHasBall;
				StartDrive();

			}
			if (yardsgained == 0) {
				Jumbotron = ("The Field Goal was missed!!! No good!");
				updateMomentum(-1);
				HomeHasBall = !HomeHasBall;
				yardline1 = 100 - yardline;
				updateClock(10);
				StartDrive();
				yardline = yardline1;
			}
			return Megatron;

		} else if (PLAY.equals("punt")) {
			Megatron = "They Decide to punt with " + (yardline) + " to go to the endzone.";
			if (yardsgained >= yardline) {
				Jumbotron = ("Punt goes for a touchback.");
				updateMomentum(-1);
				HomeHasBall = !HomeHasBall;
				updateClock(20);
				StartDrive();
			} else {
				Jumbotron = ("Punted for " + yardsgained + " yards.");
				yardline = yardline - yardsgained;
				updateMomentum(-1);
				HomeHasBall = !HomeHasBall;
				yardline1 = 100 - yardline;
				updateClock(25);
				StartDrive();
				yardline = yardline1;

			}
			return Megatron;

		} else {
			if ((yardline - yardsgained) >= 100)
				yardsgained = yardline - 100;
			if (yardsgained > yardline)
				yardsgained = yardline;
			yardline = (int) (yardline - yardsgained);
			down++;
			yardstofirst = (int) (yardstofirst - yardsgained);

			if (yardstofirst <= 0) {
				down = 1;
				yardstofirst = 10;
				// GraphicsRunner pictures = new GraphicsRunner();

			}
			Jumbotron = "";
			Megatron = "";
			if (Playbook.IsRun(PLAY)) {
				updateStats(1, yardsgained);
				if (yardsgained > 0){
					Megatron = ("Gain of " + (int) yardsgained + " yards on the run");
					updateClock(50);
					setUBERTRON("Graphics/dvdlogo.png");
				}
				else if (yardsgained == 0){
					Megatron = ("No Gain on the Play");
					updateClock(50);
				}
				else if (yardsgained < 0){
					Megatron = ("Loss of " + Math.abs((int) yardsgained) + " on the play");
					updateClock(50);
				}
			} else {
				updateStats(2, yardsgained);
				if (yardsgained > 0){
					Megatron = ("Pass Complete for " + (int) yardsgained + " yards");
					updateClock(35);
				}else if (yardsgained == 0){
					Megatron = ("Incomplete Pass");
					updateClock(10);
				}else if (yardsgained < 0){
					Megatron = ("Quarterback is sacked on the play!!!!!!");
					updateClock(50);
					updateMomentum(-1);
				}
			}

			if (yardline <= 0) {
				Jumbotron = "TOUCHDOWN";
				UpdateScore(7);
				updateMomentum(1);
				HomeHasBall = !HomeHasBall;
				StartDrive();
			}
			if (yardline >= 100) {
				Jumbotron = ("SAFETY");
				updateMomentum(-1);
				HomeHasBall = !HomeHasBall;
				UpdateScore(2);
				StartDrive();
			}
			if (down > 4) {
				Jumbotron = ("TURNOVER ON DOWNS");
				updateMomentum(-1);
				HomeHasBall = !HomeHasBall;
				updateMomentum(1);
				yardline1 = 100 - yardline;
				StartDrive();
				yardline = yardline1;
			}
			return Megatron;

		}

	}

	public Boolean GameIsAlive() {

		if (quarter > 4 && HomeScore != AwayScore){
			return false;
		}
		return true;

	}

	public void StartDrive() {
		yardline = 80;
		yardstofirst = 10;
		down = 1;
	}

	public String ReportScore() {
		return (HomeTeam.name + ": " + HomeScore + "   " + AwayTeam.name + ": " + AwayScore);

	}

	public String ReportDownAndDistance() {
		String msg = ("" + yardstofirst);
		if (yardline <= yardstofirst)
			msg = "goal";
		if (down == 1)
			return ("1st and " + msg);
		if (down == 2)
			return ("2nd and " + msg);
		if (down == 3)
			return ("3rd and " + msg);
		if (down == 4)
			return ("4th and " + msg);
		return ("");
	}

	public String ReportQuarter(){
		if(quarter < 5)
			return ("Quarter: " + quarter);
		else
			return ("OT");
	
	}
	
	public String ReportClock(){
		double secondstens = (clock%100);
		int minutes = (int)(Math.floor(clock/100));
		int seconds =(int)((secondstens/100)*60);
		
		if(seconds == 0)
			return (minutes + ":" + seconds + "0");
		else if (seconds < 10)
			return (minutes + ":0" + seconds);
		else
		return (minutes + ":" + seconds);
		
		
	}
	
	public String ReportYardsToEndzone() {

		return ("Yards to Endzone: " + yardline);
	}

	public String ReportDriveResult() {

		if (quarter > 4) {
			if (HomeScore == AwayScore) {
				this.Jumbotron += ("\nOVERTIME");
			} else {
				this.Jumbotron += ("\nGAME OVER");
			}

		}
		return Jumbotron;
	}

	

public String FieldGraphic(){
	boolean GoingRight = false;
	String msg = "";
	if(!HomeHasBall){
		if(quarter%2 == 0){
			GoingRight = true;
			msg = ("" + AwayTeam.name + "==========>");
			
		}else{
			GoingRight= false;
		msg = ("<==========" + AwayTeam.name);
		}
	}else{
		if(quarter%2 == 0){
			GoingRight = false;
			msg = ("<==========" + HomeTeam.name);	
			
		}else{
			GoingRight= true;
		msg = ("" + HomeTeam.name + "==========>");
		}
		
	}
	msg = "\n" + msg;
	String yards = "";
	
	yards +=("||");
	for(int i = 1; i <=99; i++ ){
		if(GoingRight){
			if(i == 100-yardline){
					yards +=(">");
				}
			if(i== 100-yardline+yardstofirst){
					yards +=("|");	
			
					}
				else{
						yards+=("-");
		
					}
		}else{
			if(i == yardline){
				
				
				
				
				yards+=("<");
				}
				if(i== yardline-yardstofirst){
					yards+=("|");	
					
				}
				else{
					yards+=("-");
		}
		}
		
	}
	yards+=("||");
	
	String markers = ("\n  G        10        20        30        40        50        40        30        20        10         G");
	
	
	
	return yards + markers + msg;
	
}

public Image UBERTRON;

public void setUBERTRON(String file){

	
	 Image img = null;
    try{
  	  img = ImageIO.read(new File(file));
    } catch (IOException e) {
  	  e.printStackTrace();
    }
    
    UBERTRON = img;
	
}

public ImageProducer producer(){
	
	return (ImageProducer) UBERTRON;
}

}
