package football;

import static
java.lang.System.out;
import java.util.Scanner;
public class Team {

	
	public String name = "";   
	public boolean isCPU = false;
	double rods;
	Scanner gage = new Scanner(System.in);
	
	public String nextPlay(Scoreboard sb){
		
		if(isCPU){
			if(sb.down == 4){
				if(sb.yardline < 45)
					return "fg";
				else if(sb.yardline > 54)
					return "punt";
			}
			
			
			
			rods = 100*Math.random();			
			if(rods <= 50)
				return "run";
			else
				return "pass";
		}
		else{
			String PLAY = gage.next().toLowerCase();
		
			while(!Playbook.IsValidPlay(PLAY)){
				out.println("Text Error: Please Retry");
				out.println("Eligible Plays: run, pass, or fg");
				PLAY = gage.next().toLowerCase();
			}
			
			return PLAY;
			
			
			
		}
		
		
	}
	
	
}
