package football;

import static java.lang.System.out;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FootbalGraphicsRunner extends JFrame {
	JPanel DonkeyTeeth = new JPanel();
	footballSimMethods sims = new footballSimMethods();
	Scoreboard Scoreboard1 = new Scoreboard();
	String PLAY;
	private static final int WIDTH = 2000;
	private static final int HEIGHT = 1000;
	JButton btn1 = new JButton("Run");
	JButton btn2 = new JButton("Pass");
	JButton btn3 = new JButton("Punt");
	JButton btn4 = new JButton("Field Goal");
	JTextField prompt = new JTextField();
	DoAGame playgame = new DoAGame();
	
	
	
	public void gameRunner() throws FileNotFoundException {
		boolean playagain = true;
		while (playagain) {
		
		playgame.DoAGame();
		
		}
	}
	
	
	public FootbalGraphicsRunner() {
		super("Graphics Runner");

		setSize(WIDTH, HEIGHT);


		btn1.setBounds(100, 150, 100, 50);
		btn1.setForeground(Color.BLUE);
		btn1.isBorderPainted();
		//btn1.setActionCommand(runner.PLAY= "run");
		//sims.nextPlay(PLAY, Scoreboard1.yardline); 
		btn2.setBounds(200, 150, 100, 50);
		btn2.setForeground(Color.BLUE);
		btn2.isBorderPainted();
		btn3.setBounds(300, 150, 100, 50);
		btn3.setForeground(Color.BLUE);
		btn3.isBorderPainted();
		btn4.setBounds(400, 150, 100, 50);
		btn4.setForeground(Color.BLUE);
		btn4.isBorderPainted();
		prompt.setBounds(100, 50, 100, 100);
		prompt.setForeground(Color.BLUE);
		
		getContentPane().add(btn1);
		getContentPane().add(btn2);
		getContentPane().add(btn3);
		getContentPane().add(btn4);
		getContentPane().add(prompt);
		getContentPane().add(new Field());
	
		setVisible(true);
	   	        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    }

	public void setResizable(boolean resizable) {
	}

	public static void main(String args[]) {
		FootbalGraphicsRunner run = new FootbalGraphicsRunner();
	}
}
