package football;

import java.util.*;

import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	
	public void ChoosePlay() throws IOException{
		Scanner scan = new Scanner(new File ("data/Plays.txt"));
		while (scan.hasNextLine()){
			String Play = scan.next();
			out.println(Play);
		}
		
		
	}
	
	
	
	public double RegularPlay(){
		double yods, rods;
		rods = (int)(100*(Math.random()));
		if (rods == 1) 
	        return 1;
		if (rods == 2) 
	        return 1;
		if (rods == 3) 
	        return 1;
		if (rods == 4) 
	        return 1;
		if (rods == 5) 
	        return 1;
		if (rods == 6) 
	        return 1;
		if (rods == 7) 
	        return 1;
		if (rods == 8) 
	        return 1;
		if (rods == 9) 
	        return 1;
		if (rods == 10) 
	        return 1;
		if (rods == 11) 
	        return 1;
		if (rods == 12) 
	        return 1;
		if (rods == 13) 
	        return 1;
		if (rods == 14) 
	        return 1;
		if (rods == 15) 
	        return 1;
		if (rods == 16) 
	        return 1;
		if (rods == 17) 
	        return 1;
		if (rods == 18) 
	        return 1;
		if (rods == 19) 
	        return 1;
		if (rods == 20) 
	        return 1;
		if (rods == 21) 
	        return 1;
		if (rods == 22) 
	        return 1;
		if (rods == 23) 
	        return 1;
		if (rods == 24) 
	        return 1;
		if (rods == 25) 
	        return 1;
		if (rods == 26) 
	        return 1;
		if (rods == 27) 
	        return 1;
		if (rods == 28) 
	        return 1;
		if (rods == 29) 
	        return 1;
		if (rods == 30) 
	        return 1;
		if (rods == 31) 
	        return 1;
		if (rods == 32) 
	        return 1;
		if (rods == 33) 
	        return 1;
		if (rods == 34) 
	        return 1;
		if (rods == 35) 
	        return 1;
		if (rods == 36) 
	        return 1;
		if (rods == 37) 
	        return 1;
		if (rods == 38) 
	        return 1;
		if (rods == 39) 
	        return 1;
		if (rods == 40) 
	        return 1;
		if (rods == 41) 
	        return 1;
		if (rods == 42) 
	        return 1;
		if (rods == 43) 
	        return 1;
		if (rods == 44) 
	        return 1;
		if (rods == 45) 
	        return 1;
		if (rods == 46) 
	        return 1;
		if (rods == 47) 
	        return 1;
		if (rods == 48) 
	        return 1;
		if (rods == 49) 
	        return 1;
		if (rods == 50) 
	        return 1;
		if (rods == 51) 
	        return 1;
		if (rods == 52) 
	        return 1;
		if (rods == 53) 
	        return 1;
		if (rods == 54) 
	        return 1;
		if (rods == 55) 
	        return 1;
		if (rods == 56) 
	        return 1;
		if (rods == 57) 
	        return 1;
		if (rods == 58) 
	        return 1;
		if (rods == 59) 
	        return 1;
		if (rods == 60) 
	        return 1;
		if (rods == 61) 
	        return 1;
		if (rods == 62) 
	        return 1;
		if (rods == 63) 
	        return 1;
		if (rods == 64) 
	        return 1;
		if (rods == 65) 
	        return 1;
		if (rods == 66) 
	        return 1;
		if (rods == 67) 
	        return 1;
		if (rods == 68) 
	        return 1;
		if (rods == 69) 
	        return 1;
		if (rods == 70) 
	        return 1;
		if (rods == 71) 
	        return 1;
		if (rods == 72) 
	        return 1;
		if (rods == 73) 
	        return 1;
		if (rods == 74) 
	        return 1;
		if (rods == 75) 
	        return 1;
		if (rods == 76) 
	        return 1;
		if (rods == 77) 
	        return 1;
		if (rods == 78) 
	        return 1;
		if (rods == 79) 
	        return 1;
		if (rods == 80) 
	        return 1;
		if (rods == 81) 
	        return 1;
		if (rods == 82) 
	        return 1;
		if (rods == 83) 
	        return 1;
		if (rods == 84) 
	        return 1;
		if (rods == 85) 
	        return 1;
		if (rods == 86) 
	        return 1;
		if (rods == 87) 
	        return 1;
		if (rods == 88) 
	        return 1;
		if (rods == 89) 
	        return 1;
		if (rods == 90) 
	        return 1;
		if (rods == 91) 
	        return 1;
		if (rods == 92) 
	        return 1;
		if (rods == 93) 
	        return 1;
		if (rods == 94) 
	        return 1;
		if (rods == 95) 
	        return 1;
		if (rods == 96) 
	        return 1;
		if (rods == 97) 
	        return 1;
		if (rods == 98) 
	        return 1;
		if (rods == 99) 
	        return 1;
		if (rods == 100) 
	        return 1;
		return 0;
	}
	
	public boolean PlayIsRun(String PLAY){
		if (PLAY.equals("pass"))
			return false;
		return true;
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
		Playbook myPlaybook=new Playbook();

		int rods, yods;
		rods = 0;
		if (rods == 0 ) 	
			return (double)myPlaybook.pass[1];
		return 1;
		
	}
	
		
		/*double yods, rods;
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
    	yods = 100;*/

    //}
	//return yods;}
	
	
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
