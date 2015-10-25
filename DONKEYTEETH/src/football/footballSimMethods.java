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
    } else if (rds <=13) {
         yds = -2;
    } else if (rds <=23) {
        yds = -1;
    } else if (rds <=33) {
        yds = 0;
    } else if (rds <=45) {
    	yds = 1;
    } else if (rds <=57) {
    	yds = 3;
    } else if (rds <=70) {
    	yds = 5;
    } else if (rds <=83) {
    	yds = 7;
    } else if (rds <=88) {
    	yds = 10;
    } else if (rds <=92) {
    	yds = 25;
    } else if (rds <=95) {
    	yds = 35;
    } else if (rds <=97) {
    	yds = 50;
    } else if (rds <=99) {
    	yds = 75;
    } else  {
    	yds = 100;

    }
	return yds;}
	


	public double pass() {
	double yods, rods;
	rods = 100*(Math.random());
	if (rods <=30 ) {
        yods = 0;
    } else if (rods <=33) {
         yods = -5;
    } else if (rods <=37) {
        yods = -10;
    } else if (rods <=40) {
        yods = 2;
    } else if (rods <=45) {
        yods = 5;
    } else if (rods <=55) {
        yods = 8;
    } else if (rods <=60) {
        yods = 10;
    } else if (rods <=75) {
        yods = 15;
    } else if (rods <=85) {
        yods = 20;
    } else if (rods <=95) {
        yods = 40;   
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