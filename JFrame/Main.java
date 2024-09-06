package JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//JFrame = a GUI window to add components to
		
		/*JFrame frame = new JFrame(); //creates a frame
        frame.setTitle("JFrame title goes here"); //sets title of a frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        frame.setResizable(false); //prevent frame from being resized                                
        frame.setSize(420, 420); // sets the x-dimension and y-dimension of a frame
        frame.setVisible(true); //make frame visible

        ImageIcon icon = new ImageIcon("C:/Users/jpcue/eclipse-workspace/JFrame/src/java.png"); //create an ImageIcon
        frame.setIconImage(icon.getImage()); //change icon of frame
        //frame.getContentPane().setBackground(Color.green); //change the color of background
        frame.getContentPane().setBackground(new Color(123,50,250)); //change the color of background
        //frame.getContentPane().setBackground(new Color(0x123456)); //change the color of background*/
        new MyFrame();        

	}

}
