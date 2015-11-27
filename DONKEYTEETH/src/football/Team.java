package football;

import static
java.lang.System.out;
import java.util.Scanner;
public class Team {

	public int overall = 5; 
	public int power = 0;
	public int momentum = 0;
	public String name = "";  
	public int[] stats = new int[] {0,0,0,0,0};
	public boolean isCPU = false;
	double rods;
	Scanner gage = new Scanner(System.in);
	
	public String nextPlay(Scoreboard sb, String play){
		
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
		
		String PLAY = play;
			
		
			
			return PLAY;
			
			
			
		}
		
		
	}
	
	

