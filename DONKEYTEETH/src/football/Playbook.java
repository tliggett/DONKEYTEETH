package football;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Playbook {
	public Play[] playlist = new Play[30];

	public boolean IsValidPlay(String PLAY) {
		Playbook Playbook1 = new Playbook();
		for (int i = playlist.length - 1; i >= 0; i--) {
			if (playlist[i].name.equals(PLAY))
				return true;

		}
		if (PLAY.equals("fg"))
			return true;
		if (PLAY.equals("punt"))
			return true;
		return false;
	}

	public void readfile() throws FileNotFoundException {
		Scanner scan = new Scanner(new File ("data/playslist.txt"));
		// The name of the file to open.
		String fileName = "data/playslist.txt";
		int i = 0;
		// This will reference one line at a time
		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				
				String[] ls = line.split(",");
				
				
				playlist[i] = new Play();
				playlist[i].name = ls[0];
				String run = ls[1];
				playlist[i].isRun = Integer.parseInt(run);
				
				
				for (int s = 0; s <= 99; s++) {
					playlist[i].odds[s] = ls[s + 2];

				}
				i++;
			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			

		}
		System.out.println("Super Sim Football!!!!");

	}

}
