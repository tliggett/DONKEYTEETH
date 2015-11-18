package football;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class FileRunner {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		ReadFile.writeFile("TACO TUESDAY\nWINNER WEDNESDAY\nTACO THURSDAY", "data/teh.txt");
	}

}
