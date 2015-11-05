package football;

import static java.lang.System.out;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FootbalGraphicsRunner extends JFrame {
	JPanel DonkeyTeeth = new JPanel();
	footballSimMethods sims = new footballSimMethods();
	Scoreboard Scoreboard11 = new Scoreboard();
	String PLAY1;
	private static final int WIDTH = 2000;
	private static final int HEIGHT = 1000;
	JButton btn1 = new JButton("Run");
	JButton btn2 = new JButton("Pass");
	JButton btn3 = new JButton("Punt");
	JButton btn4 = new JButton("Field Goal");
	JTextField prompt = new JTextField();
	DoAGame playgame = new DoAGame();
	private JPanel contentPane;
	int yds, yds2go, intDist, intDist2, intDist3, intDist4, intDown, yardsGained, intDist2Touch;
	double yardsgained;
	String run, pass, PLAY, down;
	char r, p;
	String play;
	String Result = "";
	Scanner gage = new Scanner(System.in);
	
	Playbook Playbook1 = new Playbook();
	footballSimMethods donkeyteeth = new footballSimMethods();
	Scoreboard Scoreboard1 = new Scoreboard();
	private JTextField txtChooseYourPlay;
	
	
	
	public void gameRunner() throws FileNotFoundException {
		boolean playagain = true;
		while (playagain) {
		
		playgame.DoAGame();
		
		}
	}
	
	
	public FootbalGraphicsRunner() throws NumberFormatException, FileNotFoundException {
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

		Playbook1.readfile();
		Scoreboard11.StartGame();
			
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JLabel lblSuperSimFootball = new JLabel("Super Sim Football!!!");
		lblSuperSimFootball.setBounds(500, 500, 183, 16);
		lblSuperSimFootball.setOpaque(true);
		lblSuperSimFootball.setBackground(Color.GREEN);
		contentPane.add(lblSuperSimFootball);
		
		JLabel lblNewLabel = new JLabel("-----( = )-----");
		lblNewLabel.setBounds(33, 17, 106, 16);
		contentPane.add(lblNewLabel);
			
		JLabel lblNewLabel_1 = new JLabel(Scoreboard11.ReportScore());
		lblNewLabel_1.setBounds(33, 64, 445, 16);
		contentPane.add(lblNewLabel_1);
			
		JLabel lblQuarter = new JLabel(Scoreboard11.ReportQuarter());
		lblQuarter.setBounds(32, 92, 445, 16);
		contentPane.add(lblQuarter);
			
		JLabel lblClock = new JLabel(Scoreboard11.ReportClock());
		lblClock.setBounds(33, 108, 445, 16);
		contentPane.add(lblClock);
			
		JLabel lblDownDist = new JLabel(Scoreboard11.ReportDownAndDistance());
		lblDownDist.setBounds(33, 144, 122, 16);
		contentPane.add(lblDownDist);
			
		JLabel lblYardline  = new JLabel(Scoreboard11.ReportYardsToEndzone());
		lblYardline.setBounds(49, 425, 445, 16);
		contentPane.add(lblYardline);
			
			
			
			
		JLabel lblResult  = new JLabel(Result);
		lblResult.setBounds(49, 425, 445, 16);
		contentPane.add(lblResult);
			
		
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

	public static void main(String args[]) throws NumberFormatException, FileNotFoundException {
		FootbalGraphicsRunner run = new FootbalGraphicsRunner();
	}
}
