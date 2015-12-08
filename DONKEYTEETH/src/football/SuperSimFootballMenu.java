package football;

import static java.lang.System.out;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
		
		String[][] teamdata = getData("data/proteams.txt");
		String[] teamnames = new String[teamdata.length];
		
		for(int i = 0; i<teamdata.length; i++){
			teamnames[i] = teamdata[i][0];
		}
		
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
		for(int i = 0; i<teamdata.length; i++){
			comboBox.addItem(teamnames[i]);
			
		}
		
		
		
		
		contentPane.add(comboBox);
		
		JComboBox<String> comboBox1 = new JComboBox<String>();
		comboBox1.setMaximumRowCount(20);
		comboBox1.setBounds(266, 192, 228, 27);
		for(int i = 0; i<teamdata.length; i++){
			comboBox1.addItem(teamnames[i]);
			
		}
		contentPane.add(comboBox1);
		
		
		
		
		JLabel lblVs = new JLabel("VS");
		lblVs.setBounds(217, 196, 22, 16);
		contentPane.add(lblVs);
		
		JCheckBox chckbxCpuPlayer = new JCheckBox("CPU Player");
		chckbxCpuPlayer.setBounds(44, 226, 151, 23);
		contentPane.add(chckbxCpuPlayer);
		
		JCheckBox chckbxCpuPlayer_1 = new JCheckBox("CPU Player");
		chckbxCpuPlayer_1.setBounds(328, 226, 151, 23);
		contentPane.add(chckbxCpuPlayer_1);
		
		JCheckBox chkrand = new JCheckBox("Random Team");
		chkrand.setBounds(44, 261, 151, 23);
		contentPane.add(chkrand);
		
		JCheckBox chkrand_1 = new JCheckBox("Random Team");
		chkrand_1.setBounds(328, 261, 151, 23);
		contentPane.add(chkrand_1);
		
		String [][] args = new String [2][7];
		
		
		JButton btnNewButton = new JButton("Play Game");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			
			public void actionPerformed(ActionEvent e) {
			try {					
				
				
				
				
				
				
				String teamn = (String) (comboBox.getSelectedItem());
				
				
				
				int[] teamstats = new int[4];
				int ovr = 0;
				
				
				for(int i = 0; i<teamdata.length; i++ ){
					if(chkrand.isSelected()){
						int r = (int) (32*Math.random());
						teamn = teamdata[r][0];
					}
					if(teamn == "Legendary"){
						args[0][0] = "Legendary Greats";
						args[0][1] = Boolean.toString(chckbxCpuPlayer.isSelected());
						
						
						args[0][2] = "1000";
						
						for(int j = 0; j<4; j++){
							args[0][j+3] = "1000";
							
						}
					}
					else if(teamdata[i][0] == teamn){
						args[0][0] = teamn;
						args[0][1] = Boolean.toString(chckbxCpuPlayer.isSelected());
						for(int j = 1; j<5; j++){
							teamstats[j-1] =Integer.parseInt(teamdata[i][j]);
							ovr += teamstats[j-1];
						}
						args[0][2] = "" + ovr/4;
						
						for(int j = 0; j<4; j++){
							args[0][j+3] = teamdata[i][j+1];
							
						}
					}
				}
				
				
				String teamn1 = (String) (comboBox1.getSelectedItem());
				int[] teamstats1 = new int[4];
				int ovr1 = 0;
				for(int i = 0; i<teamdata.length; i++ ){
					if(chkrand_1.isSelected()){
						int r = (int) (32*Math.random());
						teamn = teamdata[r][0];
					}
					
					if(teamdata[i][0] == teamn1){
						args[1][0] = teamn1;
						args[1][1] = Boolean.toString(chckbxCpuPlayer_1.isSelected());
						for(int j = 1; j<5; j++){
							teamstats[j-1] =Integer.parseInt(teamdata[i][j]);
							ovr1 += teamstats[j-1];
						}
						args[1][2] = "" + ovr1/4;
						
						for(int j = 0; j<4; j++){
							args[1][j+3] = teamdata[i][j+1];
							
						}
					}
				}
				
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
	public String [][] getData(String filename){
		
		ArrayList<String[]> mat = new ArrayList<String[]>();
		
			try {
				mat = ReadFile.readfile(filename);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		String [][] d = new String[32][5];	
		for(int i = 0; i<d.length; i++){
			String [] ray = new String[5];
			ray = mat.get(i);
			
			
			for(int j = 0; j<5; j++){
				d[i][j] = ray[j];
			}
		}
		return d;
		
		
		
	}
}