package football;

import java.util.*;
import java.math.*;

public class footballSimMethods {


	public double yds() {
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
    	yds = 2;
    } else if (rds <=70) {
    	yds = 3;
    } else if (rds <=83) {
    	yds = 4;
    } else if (rds <=88) {
    	yds = 5;
    } else if (rds <=92) {
    	yds = 6;
    } else if (rds <=95) {
    	yds = 7;
    } else if (rds <=97) {
    	yds = 8;
    } else if (rds <=99) {
    	yds = 9;
    } else  {
    	yds = 10;

    }
	return yds;}
	


	public double yods() {
	double yods, rods;
	rods = 100*(Math.random());
	if (rods <= 1) {
        yods = -5;
	} else if (rods <=35 ) {
        yods = 0;
    } else if (rods <=45) {
         yods = -5;
    } else if (rods <=50) {
        yods = -10;
    } else if (rods <=55) {
        yods = 2;
    } else if (rods <=60) {
        yods = 5;
    } else if (rods <=70) {
        yods = 8;
    } else if (rods <=80) {
        yods = 10;
    } else if (rods <=90) {
        yods = 15;
    } else if (rods <=98) {
        yods = 20;
    } else  {
    	yods = 100;

    }
	return yods;}
	
}