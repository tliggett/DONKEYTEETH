package football;

import static java.lang.System.out;

import java.util.Scanner;

public class Scoreboard {
	public int yardline = -1;
	int yardstofirst = -1;
	int down = -1;
	String Megatron = "";
	String Jumbotron = "";
	Team HomeTeam, AwayTeam;
	int HomeScore, AwayScore;
	boolean HomeHasBall = false;
	Scanner gage = new Scanner(System.in);
	public static double clock = 15;
	public static int quarter = 1;
	public int quarterlength = 15;

	public void StartGame() {

		HomeScore = 0;
		AwayScore = 0;
		HomeTeam = new Team();
		HomeTeam.name = "THE Ohio State University";// "Green Bay Packers";
		HomeTeam.isCPU = true;
		AwayTeam = new Team();
		AwayTeam.name = "Rosemount Monsters";// "Minnesota Vikings";
		AwayTeam.isCPU = true;
		HomeHasBall = true;
		Megatron = "";
		Jumbotron = "";
		out.println("How long are the quarters?");
		quarterlength = gage.nextInt();
		clock = 100*quarterlength;
		quarter = 1;
		setQuarterLength(quarterlength);
		out.println("How many players?");
		int players = gage.nextInt();
		SetTeams(players);
		StartDrive();

	}
	
	public void updateClock(double time){
		clock = clock - time;
		if(clock <= 0){
			quarter ++;
			clock =quarterlength;
			QuarterChanged = true;
			
		}
		
		
		
	}
	
	
	private boolean QuarterChanged = false;
	
	
	public void CheckForQuarterChange(){
		if(QuarterChanged){
			
			if(quarter == 3){
				HomeHasBall = false;
				StartDrive();
				Jumbotron += "\n-----( = )-----\nHALFTIME";
				
			}
			
			
			
			QuarterChanged = false;
		}
		
		
		
		
		
	}
	
	
	public void setQuarterLength(int length) {
		while (length < 1 || length > 30) {
			out.println("Sorry, Quarter Length must be between 1 and 30.\n The recommended time is 15 minutes.");
			out.println("How long of quarters in game?");
			length = gage.nextInt();

		}

		this.quarterlength = length*100;
	}

	public void SetTeams(int players) {
		while (players > 2) {
			out.println("This is football, there can only be two teams");
			out.println("How many players?");
			players = gage.nextInt();
		}

		if (players == 1) {
			out.println("You are the Home Team. What is your team name?");
			HomeTeam.name = gage.next();
			HomeTeam.isCPU = false;
			out.println("You are the " + HomeTeam.name + "! Good Luck!!!");

		} else {
			out.print("Home Team Name: ");
			HomeTeam.name = gage.next();
			out.print("Away Team Name:");
			AwayTeam.name = gage.next();

			if (players == 2) {
				HomeTeam.isCPU = false;
				AwayTeam.isCPU = false;

			}

		}

	}

	private void UpdateScore(int ScoreChange) {
		if (HomeHasBall)
			HomeScore += ScoreChange;
		else
			AwayScore += ScoreChange;

	}

	public String nextPlay() {

		if (HomeHasBall) {
			return HomeTeam.nextPlay(this);
		} else {
			return AwayTeam.nextPlay(this);

		}

	}

	public String PromptForPlay() {
		if (HomeHasBall)
			return (HomeTeam.name + " choose your play");
		else
			return (AwayTeam.name + " choose your play");
	}

	public String UpdateScoreboardAfterPlay(int yardsgained, String PLAY) {
		footballSimMethods donkeyteeth = new footballSimMethods();
		double yardsbeforeturnover = 0;
		int yardline1 = 0;

		Jumbotron = "";
		if (yardsgained == -555) {
			yardsbeforeturnover = donkeyteeth.nextPlay(PLAY, yardline);
			yardline -= yardsbeforeturnover;
			yardline1 = 100 - yardline;
			HomeHasBall = !HomeHasBall;
			if (yardline1 < 0) {
				Jumbotron = ("He's gonna take it in for six! Touchdown!");
				Megatron = ("The Fumble was recovered by the defense!");
				UpdateScore(7);
				updateClock(25);
				HomeHasBall = !HomeHasBall;
				StartDrive();
				return Megatron;
			} else {
				Megatron = ("FUMBLE Recovered by the Defense!!!");
				Jumbotron = ("It's going the other way!");
				updateClock(15);
				StartDrive();
				yardline = yardline1;
				return Megatron;
			}
		} else if (yardsgained == -777) {
			yardsbeforeturnover = (int) donkeyteeth.nextPlay(PLAY, yardline);
			yardline -= yardsbeforeturnover;
			yardline1 = 100 - yardline;
			HomeHasBall = !HomeHasBall;
			if (yardline1 < 0) {
				Jumbotron = ("PICK SIX!!!!!");
				Megatron = ("The Pass is intercepted, he's got green grass the other way!");
				UpdateScore(7);
				updateClock(50);
				HomeHasBall = !HomeHasBall;
				StartDrive();
				
				return Megatron;
			} else {
				Megatron = ("Pass is intercepted!!!");
				Jumbotron = ("It's going the other way!");
				updateClock(25);
				StartDrive();
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
				HomeHasBall = !HomeHasBall;
				updateClock(20);
				StartDrive();
			} else {
				Jumbotron = ("Punted for " + yardsgained + " yards.");
				yardline = yardline - yardsgained;
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
				if (yardsgained > 0){
					Megatron = ("Gain of " + (int) yardsgained + " yards on the run");
					updateClock(50);
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
				if (yardsgained > 0){
					Megatron = ("Pass Complete for " + (int) yardsgained + " yards");
					updateClock(35);
				}else if (yardsgained == 0){
					Megatron = ("Incomplete Pass");
					updateClock(10);
				}else if (yardsgained < 0){
					Megatron = ("Quarterback is sacked on the play!!!!!!");
					updateClock(50);
				}
			}

			if (yardline <= 0) {
				Jumbotron = "TOUCHDOWN";
				UpdateScore(7);
				HomeHasBall = !HomeHasBall;
				StartDrive();
			}
			if (yardline >= 100) {
				Jumbotron = ("SAFETY");
				HomeHasBall = !HomeHasBall;
				UpdateScore(2);
				StartDrive();
			}
			if (down > 4) {
				Jumbotron = ("TURNOVER ON DOWNS");
				HomeHasBall = !HomeHasBall;
				yardline1 = 100 - yardline;
				StartDrive();
				yardline = yardline1;
			}
			return Megatron;

		}

	}

	public Boolean GameIsAlive() {

		if (quarter > 4 && HomeScore != AwayScore)
			return false;
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

	

public void FieldGraphic(){
	boolean GoingRight = false;
	String msg = "";
	if(!HomeHasBall){
		if(quarter%2 == 0){
			GoingRight = true;
			msg = ("                     " + AwayTeam.name + "==========>");
			
		}else{
			GoingRight= false;
		msg = ("                     <==========" + AwayTeam.name);
		}
	}else{
		if(quarter%2 == 0){
			GoingRight = false;
			msg = ("                     <==========" + HomeTeam.name);	
			
		}else{
			GoingRight= true;
		msg = ("                     " + HomeTeam.name + "==========>");
		}
		
	}
		
	out.print("||");
	for(int i = 1; i <=99; i++ ){
		if(GoingRight){
			if(i == 100-yardline){
					out.print(">");
				}
			if(i== 100-yardline+yardstofirst){
					out.print("|");	
			
					}
				else{
						out.print("-");
		
					}
		}else{
			if(i == yardline){
				
				
				
				
				out.print("<");
				}
				if(i== yardline-yardstofirst){
				out.print("|");	
					
				}
				else{
				out.print("-");
		}
		}
		
	}
	out.println("||");
	
	out.println("  G        10        20        30        40        50        40        30        20        10         G");
	out.println(msg);
		
	
}


}
