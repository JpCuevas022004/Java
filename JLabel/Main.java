package JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//JLabel = a GUI display for a string of text, an image, or both
		
		ImageIcon icon = new ImageIcon("C:/Users/jpcue/eclipse-workspace/JLabel/src/coding.png");
        Border border = BorderFactory.createLineBorder(Color.green,3);

        JLabel label = new JLabel(); //create a label
        label.setText("Bro do you even code"); //set text of a label
        label.setIcon(icon);
        label.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of ImageIcon
        label.setVerticalTextPosition(JLabel.TOP); //set text TOP, CENTER, BOTTOM of ImageIcon
        label.setForeground(Color.GREEN); //set font color of text
        label.setFont(new Font("MV Boli",Font.PLAIN,50)); //set font of text
        label.setIconTextGap(-25); //set gap of text to image
        label.setBackground(Color.BLACK); //set backgrund color
        label.setOpaque(true); //display background color
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label
        //label.setBounds(100, 100, 250, 250); //set x,y position within frame as well as dimensions


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(500,500);
        //frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);
        frame.pack();
	}

}
