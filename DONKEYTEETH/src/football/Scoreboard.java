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
int Drives = 10;


public void StartGame(){
	
	HomeScore = 0;
	AwayScore = 0;
	HomeTeam = new Team();
	HomeTeam.name = "THE Ohio State University";//"Green Bay Packers";
	HomeTeam.isCPU = true;
	AwayTeam = new Team();
	AwayTeam.name = "Rosemount Monsters";//"Minnesota Vikings";
	AwayTeam.isCPU = true;
	HomeHasBall = true;
	Megatron ="";
	Jumbotron = "";
	out.println("How many drives in game?");
	Drives = gage.nextInt();
	SetDrives(Drives);
	out.println("How many players?");
	int players = gage.nextInt();
	SetTeams(players);
	StartDrive();
	
	
	
}

public void SetDrives(int Drives){
	while (Drives < 1 || Drives > 50) {
		out.println("Sorry, Drives must be between 1 and 50.\n The recommended number of drives is 10.");
		out.println("How many drives in game?");
		Drives = gage.nextInt();
		
	}
	
	this.Drives = Drives;
}

public void SetTeams(int players){
	while (players > 2){
		out.println("This is football, there can only be two teams");
		out.println("How many players?");
		players = gage.nextInt();
	}
	
	if(players == 1){
		out.println("You are the Home Team. What is your team name?");
		HomeTeam.name = gage.next();
		HomeTeam.isCPU = false;
		out.println("You are the " + HomeTeam.name + "! Good Luck!!!");
		
	} else {
		out.print("Home Team Name: ");
		HomeTeam.name = gage.next();
		out.print("Away Team Name:");
		AwayTeam.name = gage.next();
		
		if(players == 2){
			HomeTeam.isCPU = false;
			AwayTeam.isCPU = false;
			
		}
		
	}
	
	
	
}

private void UpdateScore(int ScoreChange){
	if(HomeHasBall)
		HomeScore += ScoreChange;
	else
		AwayScore += ScoreChange;
	

}

public String nextPlay(){
	
	if(HomeHasBall){
		return HomeTeam.nextPlay(this);
	}
	else{
		return AwayTeam.nextPlay(this);
		
		
	}
	
}

	
public String PromptForPlay(){
	if(HomeHasBall)
		return (HomeTeam.name + " choose your play");
	else
		return (AwayTeam.name + " choose your play");
}
public String UpdateScoreboardAfterPlay(int yardsgained, String PLAY){
	footballSimMethods donkeyteeth = new footballSimMethods();
	double yardsbeforeturnover = 0;
	int yardline1= 0;
	
	Jumbotron = "";
	if(yardsgained == -555) {
		yardsbeforeturnover = donkeyteeth.run();
		yardline += yardsbeforeturnover;
		yardline1 = 100 - yardline;
		HomeHasBall= !HomeHasBall;
		if (yardline1 < 0) {
			Jumbotron = ("He's gonna take it in for six! Touchdown!");
			Megatron = ("The Fumble was recovered by the defense!");
			UpdateScore(7);
			HomeHasBall = !HomeHasBall;
			StartDrive();
			return Megatron;
		}
		else {
			Megatron = ("FUMBLE Recovered by the Defense!!!");
			Jumbotron = ("It's going the other way!");
			StartDrive();
			yardline = yardline1;
			return Megatron;
		}
	}
	else if(yardsgained == -777)
	{
		yardsbeforeturnover = (int) donkeyteeth.pass();
		yardline += yardsbeforeturnover;
		yardline1 = 100 - yardline;
		HomeHasBall= !HomeHasBall;
		if (yardline1 < 0) {
			Jumbotron = ("PICK SIX!!!!!");
			Megatron = ("The Pass is intercepted, he's got green grass the other way!");
			UpdateScore(7);
			StartDrive();
			return Megatron;
		}
		else {
			Megatron = ("Pass is intercepted!!!");
			Jumbotron = ("It's going the other way!");
			StartDrive();
			yardline = yardline1;
			return Megatron;
		}
	}
	else if(PLAY.equals("fg")){
		Megatron ="Field Goal attempt of " + (yardline + 14) + " yards";
		if(yardsgained == 1){
			Jumbotron =("The Field Goal attempt is good!!!");
			UpdateScore(3);
			HomeHasBall=!HomeHasBall;
			StartDrive();
			
		}
		if(yardsgained == 0){
			Jumbotron =("The Field Goal was missed!!! No good!");
			HomeHasBall=!HomeHasBall;
			yardline1 = 100 - yardline;
			StartDrive();
			yardline = yardline1;
		}
		return Megatron;
	
	}
	else if(PLAY.equals("punt")){
		Megatron ="They Decide to punt with " + (yardline) + " to go to the endzone.";
		if(yardsgained> yardline){
			Jumbotron = ("Punt goes for a touchback.");
			HomeHasBall=!HomeHasBall;
			StartDrive();
		}
		else{
			Jumbotron =("Punted for " + yardsgained + " yards.");
			yardline -= yardsgained;
			HomeHasBall=!HomeHasBall;
			yardline1 = 100 - yardline;
			StartDrive();
			yardline = yardline1;
			
		
		}
		return Megatron;
	
	}
	else { 
		if((yardline-yardsgained)>=100)
		yardsgained = yardline-100;
	if(yardsgained > yardline)
		yardsgained = yardline;
	yardline= (int) (yardline-yardsgained);
	down++;
	yardstofirst = (int) (yardstofirst-yardsgained);
	
	
	if (yardstofirst <= 0) {
		down = 1;
		yardstofirst = 10;
	//GraphicsRunner pictures = new GraphicsRunner();	

	}
	Jumbotron="";
	Megatron= "";
	if(PLAY.equals("pass")){
		if(yardsgained > 0)
			Megatron= ("Pass Complete for " + (int)yardsgained + " yards");
		else if (yardsgained == 0)
			Megatron=("Incomplete Pass");
		else if (yardsgained < 0) 
			Megatron=("Quarterback is sacked on the play!!!!!!");
		}
	else if(PLAY.equals("run")){
		if(yardsgained > 0)
			Megatron=("Gain of " + (int)yardsgained + " yards on the run");
		else if (yardsgained == 0)
			Megatron=("No Gain on the Play");
		else if (yardsgained < 0) 
			Megatron=("Loss of " + Math.abs((int)yardsgained) + " on the play");
			
		}
	
	if (yardline <= 0) {
		Jumbotron ="TOUCHDOWN";
		UpdateScore(7);
		HomeHasBall=!HomeHasBall;
		StartDrive();
	}
	if (yardline >= 100){
		Jumbotron =("SAFETY");
		HomeHasBall=!HomeHasBall;
		UpdateScore(2);
		StartDrive();
	}
	if (down > 4){ 
		Jumbotron =("TURNOVER ON DOWNS");
		HomeHasBall=!HomeHasBall;
		yardline1 = 100 - yardline;
		StartDrive();
		yardline = yardline1;
	}
	return Megatron;	
		
}	
	
}


public Boolean GameIsAlive() {
	
	if(Drives<0 && HomeScore!=AwayScore)
		return false;
	return true;
	
}


public void StartDrive() {
	yardline = 80;
	yardstofirst = 10;
	down = 1;
	Drives --;
}

public String ReportScore(){
	return(HomeTeam.name + ": " + HomeScore + "   " + AwayTeam.name + ": " + AwayScore);
	
	
}

public String ReportDownAndDistance(){
	String msg = ("" + yardstofirst);
	if(yardline <= yardstofirst)
		msg = "goal";
	if(down == 1)
		return ("1st and " + msg);
	if(down == 2)
		return ("2nd and " + msg);
	if(down == 3)
		return ("3rd and " + msg);
	if(down == 4)
		return ("4th and " + msg);
	return ("");
}

public String ReportYardsToEndzone(){
	
	return ("Yards to Endzone: " + yardline);
}


public String ReportDriveResult(){
	
	
	
	
	if(Drives < 0){
		this.Jumbotron = ("OVERTIME");
		
	}
	else{	
	this.Jumbotron += ("\n Drives left: " + (this.Drives+1));
	}
	return Jumbotron;
	}
}
