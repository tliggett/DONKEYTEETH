package football;

import static
java.lang.System.out;
import java.util.Scanner;
public class Team {

	public int overall = 5; 
	public int power = 0;
	public int momentum = 0;
	public String name = "";  
	public int runO = 0;
	public int passO = 0;
	public int runD = 0;
	public int passD = 0;
	public int[] stats = new int[] {0,0,0,0,0};
	public boolean isCPU = false;
	double rods;
	Scanner gage = new Scanner(System.in);
	
	public String nextPlay(Scoreboard sb, String play){
		
		if(isCPU){
			if(sb.down == 4 && Scoreboard.quarter != 4){
				if(sb.yardline < 45)
					return "fg";
				else if(sb.yardline > 54)
					return "punt";
			}
			
		
			int div = 1;
			int send = 0;
			div =sb.down;
			if(sb.down>3){
				div = 1;
			}
			send = (10)/(4-div);
			if(Scoreboard.quarter == 4 && ((sb.HomeHasBall && sb.AwayScore > sb.HomeScore)||(!sb.HomeHasBall && sb.AwayScore < sb.HomeScore))){
				if(sb.down<4){
				send = (int) ((sb.yardline)/(Scoreboard.clock/50));
				}else{
				send = sb.yardstofirst;	
					
				}
				
			}
			
			
			
			
			return Playbook.bestplay(sb,send);
		}
		
		String PLAY = play;
			
		
			
			return PLAY;
			
			
			
		}
		
		
	}
	
	

