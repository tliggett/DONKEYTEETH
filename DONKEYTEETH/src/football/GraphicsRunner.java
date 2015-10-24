package football;

	//© A+ Computer Science  -  www.apluscompsci.com
	//Name - TJ Liggett
	//Date - 10/08/15
	//Class - APCS 7
	//Lab  - Graphics Runner

import javax.swing.JFrame;

	public class GraphicsRunner extends JFrame
	{
		private static final int WIDTH = 500;
		private static final int HEIGHT = 500;

		public GraphicsRunner()
		{
			
			super("Graphics Runner");

			setSize(WIDTH,HEIGHT);
			
			footballRunnerII football = new footballRunnerII();
			
			
			
			//getContentPane().add(new SmileyFace());
			//getContentPane().add(new BigHouse());
			//getContentPane().add(new Robot());
			getContentPane().add(new ShapePanel());
			setVisible(true);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		public static void main( String args[] )
		{
			GraphicsRunner run = new GraphicsRunner();
		}
	}