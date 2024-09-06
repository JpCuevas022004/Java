package MouseListener;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements MouseListener {
	JLabel label;
	ImageIcon smile;
	ImageIcon surprised;
	ImageIcon nervous;
	ImageIcon cool;
	
	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.setLayout(new FlowLayout());
		
		smile= new ImageIcon("C:/Users/jpcue/eclipse-workspace/MouseListener/src/happy.png");
		surprised = new ImageIcon("C:/Users/jpcue/eclipse-workspace/MouseListener/src/surprised.png");
		nervous = new ImageIcon("C:/Users/jpcue/eclipse-workspace/MouseListener/src/nervous.png");
		cool = new ImageIcon("C:/Users/jpcue/eclipse-workspace/MouseListener/src/cool.png");
		
		label = new JLabel();
		label.setIcon(smile);
		//label.setBounds(0, 0, 100, 100);
		//label.setBackground(Color.red);
		//label.setOpaque(true);
		label.addMouseListener(this);
		//this.pack();
		//this.setLocationRelativeTo(null);
		//this.add(label);
		this.add(label);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("You clicked the mouse");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("You pressed the mouse");
		//label.setBackground(Color.yellow);
		label.setIcon(surprised);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("You released the mouse");
		//label.setBackground(Color.green);
		label.setIcon(cool);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("You enetered the mouse");
		//label.setBackground(Color.blue);
		label.setIcon(nervous);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("You exited the mouse");
		//label.setBackground(Color.red);
		label.setIcon(smile);
	}

}
