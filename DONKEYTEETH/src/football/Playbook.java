package football;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Playbook {
	
	public static int isRun = 0;
	public static Play[] playlist = new Play[14];
	
	public static boolean IsValidPlay(String PLAY) {
		Playbook Playbook1 = new Playbook();
		for (int i = playlist.length-1; i >= 0; i--) {
			if (playlist[i].name.equals(PLAY)){
				return true;
			}
			
			

		}
		if (PLAY.equals("fg"))
			return true;
		if (PLAY.equals("punt")){
			return true;
		}
		
		return false;
		}



	public static boolean IsRun(String PLAY ){
		for (int i = playlist.length-1; i >= 0; i--) {
			if (playlist[i].name.equals(PLAY)){
				isRun = playlist[i].isRun;
					if(isRun == 1){
						return true;
						
					}}}
		
		return false;
		
		
		
	}
	public static String bestplay(Scoreboard sb, int yds){
		String chosen = "";
		int bestposition = 100;
		int position = 0;
		for (int i = 0; i < playlist.length; i++) {
			for (int j = 0; j < playlist[i].odds.length; j++){
					String taco = playlist[i].name;
					sb.setPower(taco);
					int pos = 0;
					pos = j+(Scoreboard.power);
					if(pos>99){
						pos = 99;
					}
					if(pos<0){
						pos = 0;
					}
					if(playlist[i].odds[pos] >= yds){
						position = j;
						if(position < bestposition){
							bestposition = position;
							chosen = playlist[i].name;
						}
						
					}}}
		
		return chosen;
		
		
	}
	
	
	public void loadPlaybook() throws NumberFormatException, NullPointerException, FileNotFoundException{
		ArrayList<String[]> mat = new ArrayList<String[]>();
		mat = ReadFile.readfile("data/playslist.txt");
		
		
		for(int i= 0; i<= playlist.length - 1; i++){
			String [] ray = new String[102];
			ray = mat.get(i);
			playlist[i] = new Play();
			
			playlist[i].name = ray[0];
			
			
			int l = 0;
			l = Integer.parseInt(ray[1]);
			playlist[i].isRun = l;
			
			for (int s = 0; s <= 99; s++) {
				 
				String [] list = new String [100];
				 String parsable = "0";
				 list[s] = ray[s+2];
				 parsable = list[s];
				 playlist[i].odds[s] = Integer.parseInt(parsable);
				
			}
			Arrays.sort(playlist[i].odds);
			
			
		}
		
	}
	

}
