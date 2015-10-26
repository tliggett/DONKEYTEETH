package football;

import java.util.*;
import java.math.*;

public class footballSimMethods {

	
	public int nextPlay(String PLAY, int yardline)
	{ 
		
		if (PLAY.equals("run")) {
		return (int) this.run();
		} else if (PLAY.equals("pass")) {
		return (int) this.pass();
		} else if (PLAY.equals("fg")) {
			return this.FGResult(yardline);
		}else if (PLAY.equals("punt")){
			return (int) this.PuntResult();
		} else {
		return -999;
		}
		
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


	public double run() {
	double yds, rds;
	rds = 100*(Math.random());
	if (rds <= 1) {
        yds = -5;
	} else if (rds <=3 ) {
        yds = -3;
    } else if (rds <=8) {
         yds = -2;
    } else if (rds <=15) {
        yds = -1;
    } else if (rds <=25) {
        yds = 0;
    } else if (rds <=35) {
    	yds = 1;
    } else if (rds <=50) {
    	yds = 3;
    } else if (rds <=65) {
    	yds = 5;
    } else if (rds <=75) {
    	yds = 7;
    } else if (rds <=85) {
    	yds = 10;
    } else if (rds <=90) {
    	yds = 25;
    } else if (rds <=92) {
    	yds = 35;
    } else if (rds <=94) {
    	yds = 50;
    } else if (rds <=96) {
    	yds = 75;
    } else if (rds <=99) {
    	yds = -555;
    	
    } else  {
    	yds = 100;

    }
	return yds;}
	


	public double pass() {
	double yods, rods;
	rods = 100*(Math.random());
	if (rods <=40 ) {
        yods = 0;
    } else if (rods <=43) {
         yods = -5;
    } else if (rods <=45) {
        yods = -10;
    } else if (rods <=50) {
        yods = 2;
    } else if (rods <=58) {
        yods = 5;
    } else if (rods <=68) {
        yods = 8;
    } else if (rods <=78) {
        yods = 10;
    } else if (rods <=82) {
        yods = 15;
    } else if (rods <= 88) {
        yods = 20;
    } else if (rods <= 91) {
        yods = 40;  
    } else if (rods <= 95) {
        yods = -777;  
    } else if (rods <= 99) {
        yods = -555;  
    } else  {
    	yods = 100;

    }
	return yods;}
	
	
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
