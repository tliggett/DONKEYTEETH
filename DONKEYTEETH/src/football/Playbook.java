package football;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Playbook {
	public Play[] playlist = new Play[30];

	public static boolean IsValidPlay(String PLAY) {
		Playbook Playbook1 = new Playbook();
		Play[] plays = Playbook1.playlist;
		for (int i = plays.length - 1; i >= 0; i--) {
			if (plays[i].name.equals(PLAY))
				return true;

		}
		if (PLAY.equals("fg"))
			return true;
		if (PLAY.equals("punt"))
			return true;
		return false;
	}

	public void readfile() throws FileNotFoundException {
		Scanner scan = new Scanner(new File ("data/playslist.csv"));
		// The name of the file to open.
		String fileName = "data/playslist.csv";
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
				System.out.println(ls[6]);
				String name = ls[i];
				
				playlist[i] = new Play();
				playlist[i].name = ls[i];
				System.out.println(playlist[i].name);
				
				/*if (ls[i + 1] == "0") {
					playlist[i].isRun = false;
				} else {
					playlist[i].isRun = true;
				}
				for (int s = 1; s < 101; s++) {
					playlist[i].odds[s] = ls[s + 1];

				}
				i++;*/
			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();

		}
		System.out.println("Super Sim Football!!!!");

	}

}
