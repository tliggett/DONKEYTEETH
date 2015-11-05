package football;

import static java.lang.System.out;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.soap.Text;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_1_00 extends JFrame {

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
					GUI_1_00 frame = new GUI_1_00();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_1_00() throws FileNotFoundException {
		
		
		
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
		lblYardline.setBounds(49, 425, 445, 16);
		contentPane.add(lblYardline);
		
		
		
		
		JLabel lblResult  = new JLabel(Result);
		lblResult.setBounds(49, 425, 445, 16);
		contentPane.add(lblResult);
		
		txtChooseYourPlay = new JTextField();
		txtChooseYourPlay.setText("Choose Your Play");
		txtChooseYourPlay.setBounds(159, 164, 130, 26);
		contentPane.add(txtChooseYourPlay);
		txtChooseYourPlay.setColumns(10);
		
		
		JButton btnNewButton = new JButton("GO!!!!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JTextField.(txtChooseYourPlay))
				PLAY.equals(txtChooseYourPlay);
				Scoreboard1.setPower();
				yds = donkeyteeth.nextPlay(PLAY, Scoreboard1.yardline);
				Result = Scoreboard1.UpdateScoreboardAfterPlay(yds,PLAY);
			}
		
			
			
		});
		
		
		
		btnNewButton.setBounds(304, 164, 117, 29);
		contentPane.add(btnNewButton);
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(20);
		comboBox.setBounds(33, 164, 270, 27);
		for(int i =0; i >18; i++){
		comboBox.addItem(Playbook.playlist[i]);
		
		
		
		contentPane.add(comboBox);
		
		
		}}
}
		
		
		
		
		/*
		
		
		while (Scoreboard1.GameIsAlive()){
			
			
			Scoreboard1.FieldGraphic();
			
			
			
			//JLabel lblNewLabel = new JLabel(Scoreboard1.ReportQuarter());
			//JLabel lblNewLabel = new JLabel(Scoreboard1.ReportClock());
			//JLabel lblNewLabel = new JLabel(Scoreboard1.ReportDownAndDistance());			
			//JLabel lblNewLabel = new JLabel(Scoreboard1.ReportYardsToEndzone());
			//JLabel lblNewLabel = new JLabel(Scoreboard1.PromptForPlay());
			PLAY = Scoreboard1.nextPlay();
			Scoreboard1.setPower();
			yds = donkeyteeth.nextPlay(PLAY, Scoreboard1.yardline);
			String Result = Scoreboard1.UpdateScoreboardAfterPlay(yds,PLAY);
			out.println(Result);
			Scoreboard1.CheckForQuarterChange();
			if(Scoreboard1.Jumbotron.length()> 0){
				out.println("===============");
				out.println(Scoreboard1.ReportDriveResult());
				out.println(Scoreboard1.ReportScore());
				out.println("Press Enter to Continue");
				gage.next();
				
			}
		}
		
		out.println("Final Score: " + Scoreboard1.ReportScore());
	}
	
		
		
			
		
		// Create a text field
	 
	
	public void DoAGame() throws FileNotFoundException

	{
		Playbook Playbook1 = new Playbook();
		footballSimMethods donkeyteeth = new footballSimMethods();
		Scoreboard Scoreboard1 = new Scoreboard();
		
		
		
		Playbook1.readfile();
		Scoreboard1.StartGame();
		
		
		while (Scoreboard1.GameIsAlive()){
			
			
			Scoreboard1.FieldGraphic();
			JLabel Score = new JLabel(Scoreboard1.ReportScore());
			Score.setBounds(200, 200, 106, 16);
			contentPane.add(Score);
			
			
			//JLabel lblNewLabel = new JLabel(Scoreboard1.ReportQuarter());
			//JLabel lblNewLabel = new JLabel(Scoreboard1.ReportClock());
			//JLabel lblNewLabel = new JLabel(Scoreboard1.ReportDownAndDistance());			
			//JLabel lblNewLabel = new JLabel(Scoreboard1.ReportYardsToEndzone());
			//JLabel lblNewLabel = new JLabel(Scoreboard1.PromptForPlay());
			PLAY = Scoreboard1.nextPlay();
			Scoreboard1.setPower();
			yds = donkeyteeth.nextPlay(PLAY, Scoreboard1.yardline);
			String Result = Scoreboard1.UpdateScoreboardAfterPlay(yds,PLAY);
			out.println(Result);
			Scoreboard1.CheckForQuarterChange();
			if(Scoreboard1.Jumbotron.length()> 0){
				out.println("===============");
				out.println(Scoreboard1.ReportDriveResult());
				out.println(Scoreboard1.ReportScore());
				out.println("Press Enter to Continue");
				gage.next();
				
			}
		}
		
		out.println("Final Score: " + Scoreboard1.ReportScore());
	}
	*/
	//}
