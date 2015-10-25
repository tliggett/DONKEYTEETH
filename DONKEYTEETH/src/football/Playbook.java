package football;

public class Playbook {
	public static boolean IsValidPlay(String PLAY) {
		if (PLAY.equals("run"))
			return true;
		if (PLAY.equals("pass"))
			return true;
		if (PLAY.equals("fg"))
			return true;
		if (PLAY.equals("punt"))
			return true;
		return false;
	}
}
