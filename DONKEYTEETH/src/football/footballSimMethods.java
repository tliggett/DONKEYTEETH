package football;

import java.util.*;

import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.*;

public class footballSimMethods {
	Playbook Playbook1 = new Playbook();
	Play [] plays = Playbook1.playlist;
	
	public int nextPlay(String PLAY, int yardline)
	{ 
		
		for (int i = plays.length - 1; i >= 0; i--) {
			if (plays[i].name.equals(PLAY))
				return RegularPlay(i);
		}
		if (PLAY.equals("fg")) {
			return this.FGResult(yardline);
		}else if (PLAY.equals("punt")){
			return (int) this.PuntResult();
		} else {
		return -999;
		}
		
	}
	
		
		
	
	
	
	
	public int RegularPlay(int i){
		int yods, rods;
		String sods = "";
		rods = (int)(100*(Math.random()));
		for(int o = 0; o <= 100; o++)
		if (rods == o) 
	        
			sods = plays[i].odds[o];
			yods = Integer.parseInt(sods);
			return yods;
		
	}


	public double PuntResult() {
		double yods, rods;
		rods = 100*(Math.random());
		if (rods <= 1) {
	        yods = -10;
		} else if (rods <=2 ) {
	        yods = 0;
	    } else if (rods <=5) {
	         yods = 20;
	    } else if (rods <=10) {
	        yods = 30;
	    } else if (rods <=30) {
	        yods = 40;
	    } else if (rods <=50) {
	        yods = 50;
	    } else if (rods <=70) {
	        yods = 60;
	    } else if (rods <=80) {
	        yods = 70;
	    } else if (rods <=90) {
	        yods = 80;
	    } else if (rods <=98) {
	        yods = 90;
	    } else  {
	    	yods = 100;
	    }
	  return yods;
	}
	
	
	public int FGResult(int yardline){
		double rods;
		rods = 100*(Math.random());
		if (yardline>50)
			return 0;
		if (yardline>45)
			if(rods<20)
				return 1;
			else return 0;
		if (yardline>40)
			if(rods<50)
				return 1;
			else return 0;
		if (yardline>30)
			if(rods<75)
				return 1;
			else return 0;
		if (yardline>20)
			if(rods<90)
				return 1;
			else return 0;
		if (yardline>10)
			if(rods<95)
				return 1;
			else return 0;
		else
			if(rods<99)
				return 1;
			else return 0;
		
	}
	
		
	}
