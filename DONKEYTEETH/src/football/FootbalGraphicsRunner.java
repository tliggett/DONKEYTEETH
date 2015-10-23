package football;
import javax.swing.JFrame;

public class FootbalGraphicsRunner extends JFrame
{
	private static final int WIDTH = 2000;
	private static final int HEIGHT = 1000;

	public FootbalGraphicsRunner()
	{
		super("Graphics Runner");
		
		setSize(WIDTH,HEIGHT);


		getContentPane().add(new Field());
		
		 

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		FootbalGraphicsRunner run = new FootbalGraphicsRunner();
	}
}
