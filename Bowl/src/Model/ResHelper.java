package Model;

import java.awt.Toolkit;

public final class ResHelper 
{
	/**/
	public static String APP_NAME = "Bowling";
	public static String CHOOSER = "Choose the file where the game is...";
	public static String BACK_BUTTON = "BACK";
	public static String NEXT_BUTTON = "NEXT";
	
	public static int TABLE_PANEL_SIZE = 10;
	
	/* Takes the width and height of the PC Screen */
	public static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	/* Now it assigns the X and Y coordinates depending on that screen width y height */
	public static int X = 2 * (SCREEN_WIDTH/10);
	public static int Y = 2 * (SCREEN_HEIGHT/10);
	public static int WIDTH = 1000;
	public static int HEIGHT = 480;
	
	/* Those are the assignments for the close, max and min buttons */
	
	/* Close Button */
	public static int YC = 0;
	public static int WIDTHC = WIDTH/20;
	public static int HEIGHTC = HEIGHT/12;
	public static int XC = WIDTH - WIDTHC;
	
	/* Min Button */
	public static int YM = 0;
	public static int WIDTHM = WIDTH/20;
	public static int HEIGHTM = HEIGHT/12;
	public static int XM = (XC - WIDTHC);
	
	
	/* Here it assigns the X, Y, width and height of the frame and components depending on thoes width and height too */
	public static int X0 = 0;
	public static int Y0 = 0;
	public static int WIDTH0 = WIDTH;
	public static int HEIGHT0 = (HEIGHT/10);
	public static int X1 = X0;
	public static int Y1 = 5 * (HEIGHT/10);
	public static int WIDTH1 = WIDTH0;
	public static int HEIGHT1 = HEIGHT0;
	public static int X2 = 5 * (WIDTH/20);
	public static int Y2 = 7 * (HEIGHT/10);
	public static int WIDTH2 = 2 * (WIDTH/10);
	public static int HEIGHT2 = (HEIGHT/12);
	public static int X3 = 11 * (WIDTH/20);
	public static int Y3 = Y2;
	public static int WIDTH3 = 2 * (WIDTH/10);
	public static int HEIGHT3 = HEIGHT2;
	public static int X4 = (WIDTH0/25);
	public static int Y4 = (HEIGHT0/5);
	public static int WIDTH4 = (WIDTH0/25);
	public static int HEIGHT4 = (HEIGHT0/4);
	
	private ResHelper()
	{
		
	}
}
