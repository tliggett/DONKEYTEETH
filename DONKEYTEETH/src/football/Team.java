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
			if(sb.down == 4){
				if(sb.yardline < 45)
					return "fg";
				else if(sb.yardline > 54)
					return "punt";
			}
			
		if(sb.down == 1){
			return Playbook.bestplay(sb, 5);
		}
			
			return Playbook.bestplay(sb, sb.yardstofirst);
		}
		
		String PLAY = play;
			
		
			
			return PLAY;
			
			
			
		}
		
		
	}
	
	

