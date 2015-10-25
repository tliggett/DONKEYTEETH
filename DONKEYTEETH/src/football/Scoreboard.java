package football;

import static java.lang.System.out;

public class Scoreboard {
public int yardline = -1;
int yardstofirst = -1;
int down = -1;
String Megatron = "";
String Jumbotron = "";
Team HomeTeam, AwayTeam;
int HomeScore, AwayScore;
boolean HomeHasBall = false;

public void StartGame(){
	
	HomeScore = 0;
	AwayScore = 0;
	HomeTeam = new Team();
	HomeTeam.name = "THE Ohio State University";//"Green Bay Packers";
	HomeTeam.isCPU = false;
	AwayTeam = new Team();
	AwayTeam.name = "Jake's Restaurant";//"Minnesota Vikings";
	AwayTeam.isCPU = false;
	HomeHasBall = false;
	Megatron ="";
	Jumbotron = "";
	StartDrive();
	
	
	
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
	Jumbotron = "";
	if(PLAY.equals("fg")){
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
			int yardline1 = 100 - yardline;
			StartDrive();
			yardline = yardline1;
		}
		return Megatron;
	
	}
	if(PLAY.equals("punt")){
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
			int yardline1 = 100 - yardline;
			StartDrive();
			yardline = yardline1;
			
		
		}
		return Megatron;
	
	}
	
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
		int yardline1 = 100 - yardline;
		StartDrive();
		yardline = yardline1;
	}
	return Megatron;	
		
}	
	
	
int Drives = 0;

public Boolean GameIsAlive() {
	
	if(Drives>10)
		return false;
	return true;
	
}


public void StartDrive() {
	yardline = 80;
	yardstofirst = 10;
	down = 1;
	Drives ++;
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
	
	
	
	
	
	
	return Jumbotron;
	}
}
