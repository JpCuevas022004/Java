package DragNDrop;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DragFrame extends JFrame implements MouseListener, MouseMotionListener{
	JLabel box;
	private int startX, startY;
	
	DragFrame(){
		super("DragNDrop");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(null);

        box = new JLabel();
        box.setBounds(0,0,100,100);
        box.setOpaque(true);
        box.setBackground(Color.gray);
        box.addMouseListener(this);
        box.addMouseMotionListener(this);
        this.add(box);
        this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		box.setBackground(Color.red);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		box.setBackground(Color.red);
		startX = e.getX();
	    startY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		box.setBackground(Color.gray);
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getXOnScreen() - startX;
	    int y = e.getYOnScreen() - startY;
	    box.setLocation(x, y);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
