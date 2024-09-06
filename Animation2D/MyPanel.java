package Animation2D;

import java.awt.*;
import java.awt.event.*;




import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener{
	final int PANEL_WIDTH = 500;
	final int PANEL_HEIGHT= 500;
	Image pacman;
	Image backgroundImage;
	Timer timer;
	int xVelocity = 3;
	int yVelocity = 2;
	int x = 0;
	int y = 0;
	
	
	
	MyPanel(){
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.black);
		pacman = new ImageIcon("C:/Users/jpcue/eclipse-workspace/Animation2D/src/java.png").getImage();
		backgroundImage = new ImageIcon("C:/Users/jpcue/eclipse-workspace/Animation2D/src/earth.jpg").getImage();
		timer = new Timer(10, this);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(backgroundImage, 0, 0, null);
		g2D.drawImage(pacman, x, y, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(x>=PANEL_WIDTH - pacman.getWidth(null)|| x<0) {
			xVelocity = xVelocity * -1;
		}
		x = x + xVelocity;
		repaint();
		
		if(y>=PANEL_HEIGHT - pacman.getHeight(null)|| y<0) {
			yVelocity = yVelocity * -1;
		}
		y = y + yVelocity;
		repaint();
	}
	    
	

}
