package football;

import static java.lang.System.*;

import java.awt.Container;
import java.util.Scanner;
import javax.swing.JFrame;

public class footballRunnerII {

	int yds2go, intDist, intDist2, intDist3, intDist4, intDown, yardsGained, intDist2Touch;
	double yds, yardsgained;
	String run, pass, PLAY;
	char r, p;
	String play;
	Scanner gage = new Scanner(System.in);

	public footballRunnerII()

	{

		footballSimMethods donkeyteeth = new footballSimMethods();
		// intDown = 1;
		intDown++;
		intDist = 10;
		yds2go = 80;

		while (intDown <= 4 && yds2go >= 0) {
			out.println("Down: " + intDown);
			out.println("Distance: " + intDist);
			out.println("Yards Gained: " + yardsgained);
			out.println("Yard Until Touchdown: " + yds2go);
			PLAY = gage.next();
			
			

			if (PLAY.equals("run")) {
				yds = donkeyteeth.yds();
			} else if (PLAY.equals("pass")) {
				yds = donkeyteeth.yods();
			} else {
				out.println("Text Error: Please Retry");
				PLAY = gage.next();
			}
			
			intDist= (int) (intDist-yds);
			/*if(intDown <= 1){
				intDist = intDist2 = (int) (10 - yds);
			} else if (intDown<= 2) {
				intDist = intDist3 = (int) (intDist2- yds);
			} else if (intDown<= 3) {
				intDist = intDist4 = (int) (intDist3- yds);
			} else if (intDown<= 4) {
				intDist = (int) (intDist3- yds);
			}*/
			intDown++;
			yardsgained = (yds);
			yds2go = (int) (yds2go-yds);
			
			
			if (intDist <= 0) {
				intDown = 1;
				intDist = 10;

			}
			
		}
		if (yds2go <= 0) {
			out.print("TOUCHDOWN");
			
		}
		if (intDown > 4) {
			out.print("TURNOVER");
		}
	}

	public static void main(String args[]) {
		footballRunnerII run = new footballRunnerII();
	}
}
