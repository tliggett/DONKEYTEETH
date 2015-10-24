package football;

//© A+ Computer Science  -  www.apluscompsci.com
//Name - TJ Liggett
//Date - 10/31/15
//Class - APCS 7
//Lab  - Shape Panel

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Canvas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapePanel extends JPanel
{
	public ShapePanel()
	{
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	/*
	 *All of your test code should be placed in paint.
	 */
	public void paint(Graphics window)
	{
		
		window.setFont(new Font("TAHOMA",Font.BOLD,18));
		window.drawString("FIRST DOWN!",300,400);
		
		football.Shapes sh1 = new football.Shapes(594, 416, 300, 300, Color.GREEN);
		sh1.draw(window);
		
	
		

		//instantiate a Shape
		//tell your shape to draw

		//instantiate a Shape
		//tell your shape to draw

		//instantiate a Shape
		//tell your shape to draw
	}
}