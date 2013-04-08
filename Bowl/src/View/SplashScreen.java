package View;
 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class SplashScreen extends JWindow {
	  JPanel content = (JPanel)getContentPane();
    JFrame frame;  
    
    private int duration;
   
      public SplashScreen(int d) {
        duration = d;
    }
    
    public void showSplash(int w, int h) {
        
        content.setBackground(Color.white);
         
         // Set the window's bounds, centering the window
         int width = w;
         int height =h;
         Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
         int x = (screen.width-width)/2;
         int y = (screen.height-height)/2;
         setBounds(x,y,width,height);
         
         // Build the splash screen
         JLabel label = new JLabel(new ImageIcon("./images/Splash.jpg"));
         JLabel copyrt = new JLabel
                 ("Copyright 2013 Bowling Game", JLabel.CENTER);
         copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
         content.add(label, BorderLayout.CENTER);
         content.add(copyrt, BorderLayout.SOUTH);
         
         // Display it
         setVisible(true);
         
         // Wait a little while, maybe while loading resources
         try { Thread.sleep(duration); } catch (Exception e) {}
         
         setVisible(false);
         
     }
     

    //run Method. This is the area where we can adjust the performance of our progress bar.  
    	
     
    
    // A simple little method to show a title screen in the center
    // of the screen for the amount of time given in the constructor
   
    
    }



