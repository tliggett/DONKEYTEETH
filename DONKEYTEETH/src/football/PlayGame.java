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
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

public class PlayGame  extends JFrame  {

	private JPanel contentPane;
	String run, pass, PLAY, down;
	char r, p;
	String play;
	String Result = "";
	public static String[][] info;
	int yds;
	Playbook Playbook1 = new Playbook();
	footballSimMethods donkeyteeth = new footballSimMethods();
	Scoreboard Scoreboard1 = new Scoreboard();
	private JTextField txtChooseYourPlay;
	private JTextField textField;
	public static boolean isOn = true;
	private JList playlist;
	/**
	 * Launch the application.
	 */
	public static void main(String[][] args) throws NullPointerException {
		info = args;
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayGame frame = new PlayGame();
					
					frame.setVisible(true);
					
					
					}
				 catch (Exception e) {
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
	@SuppressWarnings("deprecation")
	public PlayGame() throws NumberFormatException, FileNotFoundException, NullPointerException {
		Graphics draw = null;
		
		
		Playbook1.loadPlaybook();
		Scoreboard1.StartGame(info);
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1025, 725);
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
		Field.setFont(new Font("Courier New", Font.PLAIN, 13));
		Field.setEditable(false);
		Field.setBounds(21, 207, 933, 90);
		contentPane.add(Field);
		
		
		JLabel lblNewLabel_1 = new JLabel(Scoreboard1.ReportScore());
		lblNewLabel_1.setBounds(21, 65, 445, 16);
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
		lblYardline.setBounds(27, 351, 504, 50);
		contentPane.add(lblYardline);
		
		JLabel lblPrompt  = new JLabel(Scoreboard1.PromptForPlay());
		lblPrompt.setBounds(32, 289, 445, 51);
		contentPane.add(lblPrompt);
		
		
		JLabel lblResult  = new JLabel(Result);
		lblResult.setBounds(49, 456, 445, 16);
		contentPane.add(lblResult);
		
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setMaximumRowCount(20);
		comboBox.setBounds(226, 31, 270, 27);
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
		
		
		
		/*playlist = new JList();
		playlist.setLayoutOrientation(JList.VERTICAL_WRAP);
		playlist.setVisibleRowCount(4);
		playlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		playlist.setModel(new AbstractListModel() {
			
			String[] values = new String[] {"asfsad", "asdsad", "dsds", "dsdsffrgtfd", "gfdgfdg", "gfdgfdg"};

			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		playlist.setBounds(278, 331, 122, 126);
		contentPane.add(playlist);*/
		
		
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
				
				
				
			}
			
			public void actionPerformed(ActionEvent e) {
				
				
				String play = "";
				play = (String) (comboBox.getSelectedItem());
				PLAY = Scoreboard1.nextPlay(play);
				Scoreboard1.setPower();
				yds = donkeyteeth.nextPlay(PLAY, Scoreboard1.yardline);
				String Result = Scoreboard1.UpdateScoreboardAfterPlay(yds,PLAY);
				lblResult.setText(Result);
				Scoreboard1.CheckForQuarterChange();
				updateStuff();
				
				if((Scoreboard1.HomeHasBall && Scoreboard1.HomeTeam.isCPU) || (!Scoreboard1.HomeHasBall && Scoreboard1.AwayTeam.isCPU) ){
					comboBox.setEnabled(false);
				}else{
					comboBox.setEnabled(true);
				}
				
				
				if(Scoreboard1.Jumbotron.length()> 0){
				
					lblResult.setText(Result + "\n" + Scoreboard1.ReportDriveResult());
			
				
				}
				if(!Scoreboard1.GameIsAlive()){
					
					lblQuarter.setText("GAME");
					lblClock.setText("OVER");
					comboBox.setEnabled(false);
					btnNewButton.setEnabled(false);
					lblResult.setText("GAME OVER!!! " + Scoreboard1.ReportScore());
					
					
					/*String[] args = {"0", "0", "0", "0"};
					args[0] = ("Game Over. " + Scoreboard1.ReportScore() );
					try {
						GameResult end = new GameResult(args);
						end.setVisible(true);
						
					} catch (NumberFormatException | FileNotFoundException | NullPointerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
					
					
					
					}
			}
				
		
			
			
		});
		
		
		btnNewButton.setBounds(360, 119, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnStats = new JButton("STATS");
		btnStats.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			
			
			public void actionPerformed(ActionEvent e) {
				try {
					StatUpdate.main(Scoreboard1.TeamNames(), Scoreboard1.Statbook());
				} catch (NumberFormatException | NullPointerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
			}
				
		
			
			
		});
		
		btnStats.setBounds(761, 78, 89, 23);
		contentPane.add(btnStats);
		
		
		
		
	
	
		
		
	}
	}

