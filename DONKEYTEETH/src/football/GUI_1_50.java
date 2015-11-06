package football;

import static java.lang.System.out;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUI_1_50 extends JFrame {

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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_1_50 frame = new GUI_1_50();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 * @throws NumberFormatException 
	 */
	public GUI_1_50() throws NumberFormatException, FileNotFoundException {
		Playbook1.readfile();
		Scoreboard1.StartGame();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSuperSimFootball = new JLabel("Super Sim Football!!!");
		lblSuperSimFootball.setBounds(33, 36, 183, 16);
		contentPane.add(lblSuperSimFootball);
		
		JLabel lblNewLabel = new JLabel("-----( = )-----");
		lblNewLabel.setBounds(33, 17, 106, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(Scoreboard1.ReportScore());
		lblNewLabel_1.setBounds(33, 64, 445, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblQuarter = new JLabel(Scoreboard1.ReportQuarter());
		lblQuarter.setBounds(32, 92, 445, 16);
		contentPane.add(lblQuarter);
		
		JLabel lblClock = new JLabel(Scoreboard1.ReportClock());
		lblClock.setBounds(33, 108, 445, 16);
		contentPane.add(lblClock);
		
		JLabel lblDownDist = new JLabel(Scoreboard1.ReportDownAndDistance());
		lblDownDist.setBounds(33, 144, 122, 16);
		contentPane.add(lblDownDist);
		
		JLabel lblYardline  = new JLabel(Scoreboard1.ReportYardsToEndzone());
		lblYardline.setBounds(49, 390, 445, 16);
		contentPane.add(lblYardline);
		
		
		
		
		JLabel lblResult  = new JLabel(Result);
		lblResult.setBounds(49, 456, 445, 16);
		contentPane.add(lblResult);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setMaximumRowCount(20);
		comboBox.setBounds(33, 164, 270, 27);
		comboBox.addItem("run");
		comboBox.addItem("pass");
		comboBox.addItem("punt");
		comboBox.addItem("fg");
		
		
		
		contentPane.add(comboBox);
		
		
		JButton btnNewButton = new JButton("GO!!!!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String play = "";
				play.equals(comboBox.getSelectedItem());
				PLAY = Scoreboard1.nextPlay(play);
				Scoreboard1.setPower();
				yds = donkeyteeth.nextPlay(PLAY, Scoreboard1.yardline);
				String Result = Scoreboard1.UpdateScoreboardAfterPlay(yds,PLAY);
				lblResult.setText(Result);
				Scoreboard1.CheckForQuarterChange();
				lblNewLabel_1.setText(Scoreboard1.ReportScore());
				lblQuarter.setText(Scoreboard1.ReportQuarter());
				lblClock.setText(Scoreboard1.ReportClock());
				lblDownDist.setText(Scoreboard1.ReportDownAndDistance());
				lblYardline.setText(Scoreboard1.ReportYardsToEndzone());
				
				
				if(Scoreboard1.Jumbotron.length()> 0){
				
					lblResult.setText(Result + "\n" + Scoreboard1.ReportDriveResult());
			
				
			}}
		
			
			
		});
		
		
		
		btnNewButton.setBounds(304, 164, 117, 29);
		contentPane.add(btnNewButton);
		
		
		
		
		
	}

}
