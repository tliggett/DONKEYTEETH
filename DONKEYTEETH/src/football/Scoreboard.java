package football;

import static java.lang.System.out;

public class Scoreboard {
public int yardline = -1;
int yardstofirst = -1;
int down = -1;
String Megatron = "";
String Jumbotron = "";

public String UpdateScoreboardAfterPlay(int yardsgained, String PLAY){
	if(PLAY.equals("fg")){
		Megatron ="Field Goal attempt of " + (yardline + 14) + " yards";
		if(yardsgained == 1)
			Jumbotron =("The Field Goal attempt is good!!!");
		if(yardsgained == 0)
			Jumbotron =("The Field Goal was missed!!! No good!");
		yardline= 0;
		yardsgained= 0;
		down= 1;
		yardstofirst= 10;
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
	
	if (yardline <= 0) 
		Jumbotron ="TOUCHDOWN";
	
	if (yardline >= 100)
		Jumbotron =("SAFETY");
	
	if (down > 4) 
		Jumbotron =("TURNOVER ON DOWNS");
	
	
	return Megatron;	
		
}	
	
	


public Boolean DriveIsAlive() {
	
	if(down > 4)
		return false;
	if(yardline <= 0)
		return false;
	if(yardline >= 100)
		return false;
	return true;
	
}


public void StartDrive() {
	yardline = 80;
	yardstofirst = 10;
	down = 1;
	
}

public String ReportDownAndDistance(){
	if(down == 1)
		return ("1st and " + yardstofirst);
	if(down == 2)
		return ("2nd and " + yardstofirst);
	if(down == 3)
		return ("3rd and " + yardstofirst);
	if(down == 4)
		return ("4th and " + yardstofirst);
	return ("");
}

public String ReportYardsToEndzone(){
	
	return ("Yards to Endzone: " + yardline);
}


public String ReportDriveResult(){
	
	
	
	
	
	
	return Jumbotron;
	}
}
