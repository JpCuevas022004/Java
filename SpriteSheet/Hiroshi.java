package SpriteSheet;

public class Hiroshi extends GameCharacter {
    
    // Asset Constant 
	private final static int NROWS = 2;
    private final static int NCOLS = 5;
    private final static int SWIDTH = 102;
    private final static int SHEIGHT = 102;
    private final static int SPEED = 20;
	
	// Constructor
	public Hiroshi() {
		super(100, 100, "assets//2a910a872a3a7752bc7aa28bda001f95.png", NROWS, NCOLS, SWIDTH, SHEIGHT, SPEED);
	}

	public void update() {
		long ctime = System.currentTimeMillis();
		 
		if((ctime - this.getLastUpdate()) >= this.getSpeed()) {
			this.setLastUpdate(ctime);
			this.setIndex(this.getIndex()+1);
			// check if on last frame
			if(this.getIndex() > (NROWS*NCOLS)-1) this.setIndex(0);
			
		}
	}

}