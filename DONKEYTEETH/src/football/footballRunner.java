package football;
import static java.lang.System.*;

import java.awt.Container;
import java.util.Scanner;

import methods.GraphicsRunner;
import methods.ShapePanel;
import javax.swing.JFrame;
public class footballRunner {
	
	int intDist, intDist2, intDist3, intDist4, intDown, yardsGained;
	double yds;
	String run, pass, PLAY;
	char r, p;
	String play;
	Scanner gage = new Scanner(System.in);
	private static final int WIDTH = 800;
	private static final int HEIGHT = 2000;
	
	
	public footballRunner()
	
	{
		
		
		footballSimMethods donkeyteeth = new footballSimMethods();
		//intDown = 1;
		intDown++;
		intDist= 10;
				
		out.println("Down:"+intDown);
		out.println("Distance:"+intDist);
		PLAY = gage.next();
		
		
		if (PLAY.equals("run")) {
             yds = donkeyteeth.yds();
        //} else if (PLAY.equals("pass")) {
        	;
        } else {
            out.print("textError");
        }
		
		intDown++;
		intDist= (int) (10-yds);
		
		if (intDist<=0) {
			out.print("FIRST DOWN!!!!!!");
			getContentPane().add(new ShapePanel());
		} else{
		out.println("Down:"+intDown);
		out.println("Distance:"+intDist);
		gage.next();
		
		if (PLAY.equals("run")) {
            yds = donkeyteeth.yds();
       } else if (PLAY.equals("pass")) {
       		yds = donkeyteeth.yods();
       } else {
           out.print("textError");
       }
		
		
		intDown++;
		intDist2= (int) (intDist-yds);
		
		if (intDist2<=0) {
			out.print("FIRST DOWN!!!!!!");
		} else{		
		out.println("Down:"+intDown);
		out.println("Distance:"+intDist2);
		
		gage.next(); }}
		intDown++;
		intDist3= (int) (intDist2-yds);
		
		if (intDist3<=0) {
			out.print("FIRST DOWN!!!!!!");
		} else{		
		out.println("Down:"+intDown);
		out.println("Distance:"+intDist3);
		gage.next(); }
	intDown++;
	intDist3= (int) (intDist2-yds);
	
	if (intDist3<=0) {
		out.print("FIRST DOWN!!!!!!");
	} else{	
		out.print("TURNOVER");}
	}
	
	private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main( String args[] )
	{
		footballRunner run = new footballRunner();
	}
	}


