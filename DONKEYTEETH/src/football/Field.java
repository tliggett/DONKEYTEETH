package football;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

public class Field extends Canvas
{
   public Field()    //constructor - sets up the class
   {
      setSize(800,600);
      setBackground(Color.GRAY);
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      smileyFace(window);
   }

   public void smileyFace( Graphics window )
   {
      window.setColor(Color.GREEN);
      window.fillRect(100, 200, 1200, 700);
      
      window.setColor(Color.WHITE);
      window.drawRect(100, 200, 1200, 700);
      window.drawLine(200, 200, 200, 900);
      window.drawLine(300, 200, 300, 900);
      window.drawLine(400, 200, 400, 900);
      window.drawLine(500, 200, 500, 900);
      window.drawLine(600, 200, 600, 900);
      window.drawLine(700, 200, 700, 900);
      window.drawLine(800, 200, 800, 900);
      window.drawLine(900, 200, 900, 900);
      window.drawLine(1000, 200, 1000, 900);
      window.drawLine(1100, 200, 1100, 900);
      window.drawLine(1200, 200, 1200, 900);
      
      window.setColor(Color.RED);
      window.fillRect(100, 200, 100, 700);
      window.setColor(Color.BLUE);
      window.fillRect(1200, 200, 100, 700);
      
      window.setColor(Color.White);
      

   }
}
