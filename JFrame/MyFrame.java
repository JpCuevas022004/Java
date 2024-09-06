package JFrame;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	MyFrame(){
		
		//JFrame = a GUI window to add components to
		
		this.setTitle("JFrame title goes here"); //sets title of a frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(false); //prevent frame from being resized                                
        this.setSize(420, 420); // sets the x-dimension and y-dimension of a frame
        this.setVisible(true); //make frame visible

        ImageIcon icon = new ImageIcon("C:/Users/jpcue/eclipse-workspace/JFrame/src/java.png"); //create an ImageIcon
        this.setIconImage(icon.getImage()); //change icon of frame
        this.getContentPane().setBackground(Color.GREEN);//change the color of background
        //this.getContentPane().setBackground(new Color(123,50,250)); //change the color of background
        //this.getContentPane().setBackground(new Color(0x123456)); //change the color of background*/
	}

}
