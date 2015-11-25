package football;

import static java.lang.System.out;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Panel;
import java.awt.Font;

public class PlayGame  extends JFrame  {

	private JPanel contentPane;
	String run, pass, PLAY, down;
	char r, p;
	String play;
	String Result = "";
	public static String[] info;
	
	Playbook Playbook1 = new Playbook();
	footballSimMethods donkeyteeth = new footballSimMethods();
	Scoreboard Scoreboard1 = new Scoreboard();
	private JTextField txtChooseYourPlay;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws NullPointerException {
		info = args;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayGame frame = new PlayGame();
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
	public PlayGame() throws NumberFormatException, FileNotFoundException, NullPointerException {
		Graphics draw = null;
		
		
		Playbook1.loadPlaybook();
		Scoreboard1.StartGame(info);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1000);
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
		
		
		
		JTextArea Field = new JTextArea(Scoreboard1.FieldGraphic());
		Field.setEditable(false);
		Field.setBounds(347, 892, 900, 50);
		contentPane.add(Field);
		
		
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
		lblYardline.setFont(new Font("Tamil MN", Font.BOLD, 22));
		lblYardline.setBounds(33, 910, 504, 50);
		contentPane.add(lblYardline);
		
		JLabel lblPrompt  = new JLabel(Scoreboard1.PromptForPlay());
		lblPrompt.setBounds(33, 892, 445, 16);
		contentPane.add(lblPrompt);
		
		Panel panel = new Panel();
		panel.setBounds(587, 25, 200, 200);
		contentPane.add(panel);
		
		
		JLabel lblResult  = new JLabel(Result);
		lblResult.setBounds(49, 456, 445, 16);
		contentPane.add(lblResult);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setMaximumRowCount(20);
		comboBox.setBounds(282, 32, 270, 27);
		comboBox.addItem("run");
		comboBox.addItem("counter");
		comboBox.addItem("pass");
		comboBox.addItem("dive");
		comboBox.addItem("pitch");
		comboBox.addItem("powero");
		comboBox.addItem("reverse");
		comboBox.addItem("sweep");
		comboBox.addItem("sneak");
		comboBox.addItem("screen");
		comboBox.addItem("slants");
		comboBox.addItem("verticals");
		comboBox.addItem("curls");
		comboBox.addItem("hailmary");
		comboBox.addItem("flag");
		comboBox.addItem("playaction");
		comboBox.addItem("punt");
		comboBox.addItem("fg");
		
		contentPane.add(comboBox);
		//contentPane.add(Field());
		
		JButton btnNewButton = new JButton("GO!!!!");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void updateStuff() throws NullPointerException{
				lblNewLabel_1.setText(Scoreboard1.ReportScore());
				lblQuarter.setText(Scoreboard1.ReportQuarter());
				lblClock.setText(Scoreboard1.ReportClock());
				lblDownDist.setText(Scoreboard1.ReportDownAndDistance());
				lblYardline.setText(Scoreboard1.ReportYardsToEndzone());
				lblPrompt.setText(Scoreboard1.PromptForPlay());
				Field.setText(Scoreboard1.FieldGraphic());
				//draw.drawImage(Scoreboard1.UBERTRON,587, 25, 200, 200, panel );
				contentPane.add(panel);
				
				
			}
			
			public void actionPerformed(ActionEvent e) {
				
				if(!Scoreboard1.GameIsAlive()){
			
				lblResult.setText("GAME OVER \n" + Scoreboard1.ReportScore());
				
				}else{
				String play = "";
				play = (String) (comboBox.getSelectedItem());
				PLAY = Scoreboard1.nextPlay(play);
				Scoreboard1.setPower();
				yds = donkeyteeth.nextPlay(PLAY, Scoreboard1.yardline);
				String Result = Scoreboard1.UpdateScoreboardAfterPlay(yds,PLAY);
				lblResult.setText(Result);
				Scoreboard1.CheckForQuarterChange();
				updateStuff();
			
				
				
				if(Scoreboard1.Jumbotron.length()> 0){
				
					lblResult.setText(Result + "\n" + Scoreboard1.ReportDriveResult());
			
				
				}
			}
				}
		
			
			
		});
		
		
		btnNewButton.setBounds(361, 59, 117, 29);
		contentPane.add(btnNewButton);
		
		
		
		
	}
}
