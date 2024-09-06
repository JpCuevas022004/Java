package KeyboardControlDemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements KeyListener{
	JFrame frame;
	JLabel W;
	JLabel A;
	JLabel S;
	JLabel D;
	JLabel X;
	MyFrame(){
		super("Keyboard Control Demo");
		
		this.setSize(500, 500);
		this.setLayout(new BorderLayout());
		this.addKeyListener(this);
		
		W = new JLabel("W Key");
		W.setHorizontalAlignment(JLabel.CENTER);
		W.setBounds(180, 0, 100, 100);
		W.setOpaque(true);
		
		A = new JLabel("A Key");
		A.setHorizontalAlignment(JLabel.CENTER);
		A.setBounds(180, 0, 100, 100);
		A.setOpaque(true);
		
		S = new JLabel("S Key");
		S.setHorizontalAlignment(JLabel.CENTER);
		S.setBounds(180, 0, 100, 100);
		S.setOpaque(true);
		
		D = new JLabel("D Key");
		D.setHorizontalAlignment(JLabel.CENTER);
		D.setBounds(180, 0, 100, 100);
		D.setOpaque(true);
		
		X = new JLabel("X Key");
		X.setHorizontalAlignment(JLabel.CENTER);
		X.setBounds(180, 0, 100, 100);
		X.setOpaque(true);
		
		this.add(W, BorderLayout.NORTH);
		this.add(A, BorderLayout.WEST);
		this.add(S, BorderLayout.CENTER);
		this.add(D, BorderLayout.EAST);
		this.add(X, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int KeyCode = e.getKeyCode();
		if(e.getKeyCode()== KeyEvent.VK_W) {
			W.setBackground(Color.GREEN);
			System.out.println("You pressed the W key");
		}
		if(e.getKeyCode()== KeyEvent.VK_A) {
			A.setBackground(Color.GREEN);
			System.out.println("You pressed the A key");
		}
		if(e.getKeyCode()== KeyEvent.VK_S) {
			S.setBackground(Color.GREEN);
			System.out.println("You pressed the S key");
		}
		if(e.getKeyCode()== KeyEvent.VK_D) {
			D.setBackground(Color.GREEN);
			System.out.println("You pressed the D key");
		}
		if(e.getKeyCode()== KeyEvent.VK_X) {
			X.setBackground(Color.GREEN);
			System.out.println("You pressed the X key");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int KeyCode = e.getKeyCode();
		if(e.getKeyCode()== KeyEvent.VK_W) {
			W.setBackground(null);
			System.out.println("You released the W key");
		}
		if(e.getKeyCode()== KeyEvent.VK_A) {
			A.setBackground(null);
			System.out.println("You released the A key");
		}
		if(e.getKeyCode()== KeyEvent.VK_S) {
			S.setBackground(null);
			System.out.println("You released the S key");
		}
		if(e.getKeyCode()== KeyEvent.VK_D) {
			D.setBackground(null);
			System.out.println("You released the D key");
		}
		if(e.getKeyCode()== KeyEvent.VK_X) {
			X.setBackground(null);
			System.out.println("You released the X key");
		}
	}

}
