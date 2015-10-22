package football;
import static java.lang.System.*;

import java.awt.Container;
import java.util.Scanner;
import javax.swing.JFrame;
public class footballRunnerII {
	
	int intDist, intDist2, intDist3, intDist4, intDown, yardsGained;
	double yds;
	String run, pass, PLAY;
	char r, p;
	String play;
	Scanner gage = new Scanner(System.in);
	
	
	public footballRunnerII()
	
	{
		
		
		footballSimMethods donkeyteeth = new footballSimMethods();
		//intDown = 1;
		intDown++;
		intDist= 10;
				
		while(intDown<=4){
		out.println("Down:"+intDown);
		out.println("Distance:"+intDist);
		PLAY = gage.next();
		
		
		if (PLAY.equals("run")) {
             yds = donkeyteeth.yds();
        } else if (PLAY.equals("pass")) {
        	 yds = donkeyteeth.yods();
        } else {
            out.print("textError");
        }
		
		intDown++;
		intDist= (int) (10-yds);
		
		if (intDist<=0) {
			intDown = 1;
			intDist = 10;
			
		}}
		if(intDown>4){
			out.print("TURNOVER");
	}}
			
		

	public static void main( String args[] )
	{
		footballRunnerII run = new footballRunnerII();
	}
	}


