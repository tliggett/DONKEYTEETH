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

public class StatUpdate  extends JFrame  {

	private JPanel contentPane;
	public static String str = "";
	
	public static void main(String[] args, int[][]statbook) throws NullPointerException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatUpdate frame = new StatUpdate(args, statbook);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param args 
	 * @throws FileNotFoundException 
	 * @throws NumberFormatException 
	 */
	@SuppressWarnings("deprecation")
	public StatUpdate(String[] args, int[][]statbook) throws NumberFormatException, FileNotFoundException, NullPointerException {
		Graphics draw = null;
		
		
				
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*JLabel lblSuperSimFootball = new JLabel("Super Sim Football!!!");
		lblSuperSimFootball.setBounds(33, 36, 183, 16);
		contentPane.add(lblSuperSimFootball);
		
		JLabel lblNewLabel = new JLabel("-----( = )-----");
		lblNewLabel.setBounds(33, 17, 106, 16);
		contentPane.add(lblNewLabel);*/
		
		
		
		String Hclock ="0";
		double secondstens = (statbook[0][3]%100);
		int minutes = (int)(Math.floor(statbook[0][3]/100));
		int seconds =(int)((secondstens/100)*60);
		
		if(seconds == 0)
			Hclock = (minutes + ":" + seconds + "0");
		else if (seconds < 10)
			Hclock =(minutes + ":0" + seconds);
		else
			Hclock =(minutes + ":" + seconds);
		
		String Aclock ="0";
		double Asecondstens = (statbook[1][3]%100);
		int Aminutes = (int)(Math.floor(statbook[1][3]/100));
		int Aseconds =(int)((Asecondstens/100)*60);
		
		if(Aseconds == 0)
			Aclock = (Aminutes + ":" + Aseconds + "0");
		else if (Aseconds < 10)
			Aclock =(Aminutes + ":0" + Aseconds);
		else
			Aclock =(Aminutes + ":" + Aseconds);
		
		
		JLabel lblHomeTeam = new JLabel(args[0]);
		lblHomeTeam.setBounds(110, 33, 154, 32);
		contentPane.add(lblHomeTeam);
		
		JLabel lblAWAYTEAM = new JLabel(args[1]);
		lblAWAYTEAM.setBounds(285, 33, 154, 32);
		contentPane.add(lblAWAYTEAM);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setBounds(10, 98, 46, 14);
		contentPane.add(lblScore);
		
		JLabel lblRushYards = new JLabel("Rush Yards");
		lblRushYards.setBounds(10, 142, 60, 14);
		contentPane.add(lblRushYards);
		
		JLabel lblPassYards = new JLabel("Pass Yards");
		lblPassYards.setBounds(10, 194, 60, 14);
		contentPane.add(lblPassYards);
		
		JLabel lblTop = new JLabel("TOP");
		lblTop.setBounds(10, 255, 46, 14);
		contentPane.add(lblTop);
		
		JLabel lblTurnovers = new JLabel("Turnovers");
		lblTurnovers.setBounds(10, 304, 60, 14);
		contentPane.add(lblTurnovers);
		
		JLabel lblTakeaways = new JLabel("Takeaways");
		lblTakeaways.setBounds(10, 364, 60, 14);
		contentPane.add(lblTakeaways);
		
		JLabel lblHscore = new JLabel("" + statbook[0][0]);
		lblHscore.setBounds(118, 98, 46, 14);
		contentPane.add(lblHscore);
		
		JLabel lblAscore = new JLabel("" + statbook[1][0]);
		lblAscore.setBounds(289, 98, 46, 14);
		contentPane.add(lblAscore);
		
		JLabel lblHrush = new JLabel("" + statbook[0][1]);
		lblHrush.setBounds(118, 142, 46, 14);
		contentPane.add(lblHrush);
		
		JLabel lblArush = new JLabel("" + statbook[1][1]);
		lblArush.setBounds(289, 142, 46, 14);
		contentPane.add(lblArush);
		
		JLabel lblHpass = new JLabel("" + statbook[0][2]);
		lblHpass.setBounds(118, 194, 46, 14);
		contentPane.add(lblHpass);
		
		JLabel lblApass = new JLabel("" + statbook[1][2]);
		lblApass.setBounds(285, 194, 46, 14);
		contentPane.add(lblApass);
		
		JLabel lblHtop = new JLabel(Hclock);
		lblHtop.setBounds(110, 255, 46, 14);
		contentPane.add(lblHtop);
		
		JLabel lblAtop = new JLabel(Aclock);
		lblAtop.setBounds(285, 255, 46, 14);
		contentPane.add(lblAtop);
		
		JLabel lblHturn = new JLabel("" + statbook[0][4]);
		lblHturn.setBounds(118, 304, 46, 14);
		contentPane.add(lblHturn);
		
		JLabel lblHtake = new JLabel("" + statbook[1][4]);
		lblHtake.setBounds(110, 364, 46, 14);
		contentPane.add(lblHtake);
		
		JLabel lblAturn = new JLabel("" + statbook[1][4]);
		lblAturn.setBounds(285, 304, 46, 14);
		contentPane.add(lblAturn);
		
		JLabel lblAtake = new JLabel("" + statbook[0][4]);
		lblAtake.setBounds(285, 364, 46, 14);
		contentPane.add(lblAtake);
		
		
	
	
		
		
	}
	}

