import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.Graphics2D;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * CS 121 Project 1: Traffic Animation
 *
 * Animates a [put your description here]
 *
 * @author BSU CS 121 Instructors
 * @author [put your name here]
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.

	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 17; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your vehicle's
	 * coordinates should be relative to this offset value.
	 */
	
	private int xOffset = 0;


	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
	 */
	private int stepSize = 5;

	private final Color BACKGROUND_COLOR = Color.black;

	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
	
		// Get the current width and height of the window.
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height
		
		// Fill the graphics page with the background color.
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width, height);

		// Calculate the new xOffset position of the moving object.
		xOffset  = (xOffset + stepSize) % (width + height / 4);

		// TODO: Use width, height, and xOffset to draw your scalable objects
		// at their new positions on the screen

		// This draws a green square. Replace it with your own object.
		
		int circleDiameter = height / 4;
		int circleY = height / 2 - circleDiameter / 2;
		
		Color hotPink = new Color (250,7,127);
		
		int xValue = xOffset - (circleDiameter / 2);
		xValue = (xValue) % (width + height / 4);
		g.setColor(Color.green);
		//Draws the grass
		g.fillRect(0,0,width,height);
		g.setColor(Color.black);
		//Draws the road
		g.fillRect(0, 0, width, height * 2 / 3);
		g.setColor(Color.blue);
		//Draws the water
		g.fillRect(0, 0, width, height / 3);
		g.setColor(Color.white);
		//Draws the main object
		g.fillOval((xOffset - circleDiameter), circleY, circleDiameter, circleDiameter);
		g.setColor(Color.red);
		//Draws the two lines
		g.drawLine(xOffset - (circleDiameter / 2), circleDiameter + circleY, xValue, circleY);
		g.drawLine(xOffset, (circleDiameter * 2), (xOffset - (height / 4)), circleDiameter * 2);
		g.setColor(hotPink);
		//Draws the stick figure
		g.drawLine(width / 16, height * 13 / 14, width / 14, height * 8 / 9);
		g.drawLine(width / 14, height * 8 / 9, width / 12, height * 13 / 14);
		g.drawLine(width / 14, height * 8 / 9, width / 14, height * 23 / 28);
		g.drawLine(width / 16, height * 6 / 7, width / 12, height * 6 / 7);
		g.drawOval(width / 20, height * 21 / 28, width / 24, width / 24);
		g.setColor(Color.black);
		//Displays text
		g.setFont(new Font("Arial", Font.BOLD, 24));
		g.drawString("e", height / 5, width / 5);
		
		
		
		
		
		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public TrafficAnimation()
	{
		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}
