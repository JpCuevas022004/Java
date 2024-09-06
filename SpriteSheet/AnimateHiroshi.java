package SpriteSheet;


import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class AnimateHiroshi extends JFrame implements Runnable{

    // Timer
	private long rstart;
	private long rend;
	
	// Thread Object
	private Thread t;

	// Screen dimension variables
	private int screenWidth;
	private int screenHeight;

	// frame buffers
	FrameBuffer2 buffer;
	
	// Hiroshi 
	Hiroshi hero; 

    public AnimateHiroshi(String title, int width, int height) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		
		screenWidth = width;
		screenHeight = height;

		// Instantiate character
		hero = new Hiroshi();
		
		// Instantiate thread using the class instance
		t = new Thread(this);
	}



	public void paint(Graphics g) {
		// detect if the frame buffer is initialized
		if(buffer == null) 
			buffer = new FrameBuffer2(createImage(screenWidth, screenHeight),
					createImage(screenWidth, screenHeight));
		
		Graphics2D g2d = (Graphics2D) g;
		// Clear (createImage(screenWidth, screenHeight))
           buffer.clear(createImage(screenWidth, screenHeight));
        // Draw
           buffer.drawCharacter(hero);
        // Render
           g2d.drawImage(buffer.render(), 0, 0, this);
		g2d.dispose();
		
	}
	
    public void run() {
		while(true){
			try {
				
				// update frame
				hero.update();
				
				// To maintain a 25 frame per second rendering,
				// we let the thread sleep for 40 milliseconds.
				// That is:
				// 1 second = 1000 milliseconds
				// so we divide
				// 1000 milliseconds / 25
				// that gives us 40 milliseconds window
				// for every rendering
				
				
				// we render after the thread sleep
				rstart = System.currentTimeMillis();
				repaint();
				rend = System.currentTimeMillis();
				
				// sleep for the remaining time
				Thread.sleep(40-(rend-rstart));
				
			} catch (InterruptedException ex) {
				// Print errors
				System.out.println(ex.getMessage());
			}
		}
		
	}

    public void startAnimation(){
		t.start(); // starts the animation
		hero.setLastUpdate(System.currentTimeMillis());
	}
	
	public static void main(String[] args){
		AnimateHiroshi fr =
		new AnimateHiroshi("Hiroshi Demo", 500, 500);
		fr.setVisible(true);
		fr.startAnimation(); // we start the animation
	}
}