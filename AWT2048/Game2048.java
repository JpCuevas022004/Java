package AWT2048;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game2048 extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final int GRID_SIZE = 4;
	    private int[][] grid;

	    public Game2048() {
	        setTitle("2048 Game");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(400, 400);
	        setResizable(false);
	        setLocationRelativeTo(null);

	        setGrid(new int[GRID_SIZE][GRID_SIZE]);

	        addKeyListener((KeyListener) new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_UP) {
	                    // Handle up movement
	                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	                    // Handle down movement
	                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	                    // Handle left movement
	                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	                    // Handle right movement
	                }
	            }
	        });

	        setVisible(true);
	    }

		public int[][] getGrid() {
			return grid;
		}

		public void setGrid(int[][] grid) {
			this.grid = grid;
		}


}
