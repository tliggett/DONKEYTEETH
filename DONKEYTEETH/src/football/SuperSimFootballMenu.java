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
import javax.swing.JCheckBox;

public class SuperSimFootballMenu  extends JFrame  {

	private JPanel contentPane;
	int yds, yds2go, intDist, intDist2, intDist3, intDist4, intDown, yardsGained, intDist2Touch;
	double yardsgained;
	String run, pass, PLAY, down;
	char r, p;
	String play;
	String Result = "";
	
	
	Playbook Playbook1 = new Playbook();
	footballSimMethods donkeyteeth = new footballSimMethods();
	Scoreboard Scoreboard1 = new Scoreboard();
	private JTextField txtChooseYourPlay;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws NullPointerException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuperSimFootballMenu frame = new SuperSimFootballMenu();
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
	public SuperSimFootballMenu() throws NumberFormatException, FileNotFoundException, NullPointerException {
		Graphics draw = null;
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblSuperSimFootball = new JLabel("Super Sim Football!!!");
		lblSuperSimFootball.setBounds(157, 68, 183, 16);
		contentPane.add(lblSuperSimFootball);
		
		JLabel lblNewLabel = new JLabel("-----( = )-----");
		lblNewLabel.setBounds(157, 37, 106, 16);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setMaximumRowCount(20);
		comboBox.setBounds(6, 192, 189, 27);
		comboBox.addItem("Minnesota Vikings OVR:86");
		comboBox.addItem("New York Giants OVR:82");
		comboBox.addItem("Philadelphia Eagles OVR:81");
		comboBox.addItem("Detroit Lions OVR:80");
		comboBox.addItem("Green Bay Packers OVR:87");
		comboBox.addItem("Chicago Bears OVR:81");
		comboBox.addItem("New England Patriots OVR:95");
		comboBox.addItem("Carolina Panthers OVR:94");
		
		
		
		
		contentPane.add(comboBox);
		
		JComboBox<String> comboBox1 = new JComboBox<String>();
		comboBox1.setMaximumRowCount(20);
		comboBox1.setBounds(266, 192, 228, 27);
		comboBox1.addItem("Green Bay Packers OVR:87");
		comboBox1.addItem("Minnesota Vikings OVR:86");
		comboBox1.addItem("New York Giants OVR:82");
		comboBox1.addItem("Philadelphia Eagles OVR:81");
		comboBox1.addItem("Detroit Lions OVR:80");
		comboBox1.addItem("Chicago Bears OVR:81");
		comboBox1.addItem("New England Patriots OVR:95");
		comboBox1.addItem("Carolina Panthers OVR:94");
		contentPane.add(comboBox1);
		
		
		
		
		JLabel lblVs = new JLabel("VS");
		lblVs.setBounds(217, 196, 22, 16);
		contentPane.add(lblVs);
		
		JCheckBox chckbxCpuPlayer = new JCheckBox("CPU Player");
		chckbxCpuPlayer.setBounds(44, 226, 97, 23);
		contentPane.add(chckbxCpuPlayer);
		
		JCheckBox chckbxCpuPlayer_1 = new JCheckBox("CPU Player");
		chckbxCpuPlayer_1.setBounds(328, 226, 97, 23);
		contentPane.add(chckbxCpuPlayer_1);
		
		String [][] args = new String [2][4];
		
		
		JButton btnNewButton = new JButton("Play Game");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			
			public void actionPerformed(ActionEvent e) {
			try {					
				
				for(int i = 0; i<2; i++){
					for(int j = 0; j<4; j++){
						args[i][j] = "0";
					}
				}
				
				String gonnasplit = (String) (comboBox.getSelectedItem());
				String [] line = gonnasplit.split("OVR:");
				args[0][0] = line[0];
				args[0][1] = Boolean.toString(chckbxCpuPlayer.isSelected());
				args[0][2] = line[1];
				
				String gonnasplit1 = (String) (comboBox1.getSelectedItem());
				String [] line1 = gonnasplit1.split("OVR:");
				args[1][0] = line1[0];
				args[1][1] = Boolean.toString(chckbxCpuPlayer_1.isSelected());
				args[1][2] = line1[1];
				
				PlayGame.main(args);
				
				
			} catch (NumberFormatException | NullPointerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}	
			});
		
			
			
		
		
		btnNewButton.setBounds(177, 292, 117, 29);
		contentPane.add(btnNewButton);
		
		
		
	}
}