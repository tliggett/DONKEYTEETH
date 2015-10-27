package football;

public class Playbook {
	
	
	int[] pass={0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	-5,	-5,	-5,	-10,	-10,	-10,	-10,	-10,	-10,	5,	5,	5,	5,	5,	5,	5,	5,	5,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	10,	10,	10,	10,	10,	10,	10,	10,	10,	15,	15,	15,	15,	20,	20,	20,	20,	20,	20,	40,	40,	40,	-777,	-777,	-777,	-777,	-555,	-555,	-555,	-555,	100 };


public int [] pass(){
	
	
	return pass;
}
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
	
	
	
	
	


