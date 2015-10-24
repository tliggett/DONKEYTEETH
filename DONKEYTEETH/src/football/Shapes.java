package football;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -TJ Liggett
//Date - 10/19/15
//Class - APCS 7
//Lab  - Shapes

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Shapes
{
 //instance variables
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;

 public Shapes(int x, int y, int wid, int ht, Color col)
 {
		xPos = x;
		yPos = y;
		width = wid;
		height = ht;
		color = col;
		//finish this constructor
 }

 public void setX(int xp)
 { 
	 xPos = xp;
 }
 
 public void sety(int yp)
 { 
	 yPos = yp;
	 
 }
 
 public int getX() {
	 return xPos;
 }
 public int getY() {
	 return yPos;
 }
 
 public void draw(Graphics window)
 {
   
    
    Image img = null;
    try {
		 img = ImageIO.read(new File("Graphics/Minnesota+Vikings+v+New+York+Jets+KiwtXudpUNPl.jpg"));
	} catch (IOException e) {
		e.printStackTrace();
	}
  window.drawImage(img, xPos, yPos, height, width, null);
 }
	 
	 
	 
	 
	 //ImageIcon gif = null;
       //try {
 		 //new ImageIcon(ImageIO.read(new File("Graphics/JoeStaley.gif")));
 	//} catch (IOException e) {
 		//e.printStackTrace(); 	    
 	//}
      //JLabel label = new JLabel(gif);
       
     //window.add(label);
    
 



   
   
 public String toString()
 {
 	return xPos+" "+yPos+" "+width+" "+height+" "+color;
 }
}
