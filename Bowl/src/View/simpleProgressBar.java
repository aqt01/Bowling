package View;
    /** 
     * File: simpleProgressBar.java 
     * Tiltle: Creating a Simple Progress Bar 
     * Author: http://java-program-sample.blogspot.com/ 
     */  
      
    //Java Core Package  
    import javax.swing.*;  
    //Java Extension Package  
    import java.awt.*;  
import java.awt.event.*;  
      
    public class simpleProgressBar  
    {     
    	JProgressBar bar = new JProgressBar();
     	JFrame frame = new JFrame("Loading");
     // JButton button = new JButton("Test Progress Bar");  
        InitFrame init = new InitFrame();  
     //Setting up GUI  
        
        public simpleProgressBar(int x , int y) {  
                
         //Setting up the Title of the Window  
           
         //Set Size of the Window (WIDTH, HEIGHT)
         frame.setSize(x,y);
         frame.setLocation(init.getMiddleFrameX(frame),init.getMiddleFrameY(frame));  
      
         //Exit Property of the Window  
         //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      
         //Setting up the container ready for the components to be added.  
         Container pane = frame.getContentPane();  
         frame.setContentPane(pane);  
           
         //Display the progress bar completion percentage label  
         bar.setStringPainted(true);  
      
         //Setting up the container layout  
         GridLayout grid = new GridLayout(1,1);  
         pane.setLayout(grid);  
           
         //Adding the progress bar and the button to the container  
         pane.add(bar);
         Thread run = new Progress(this); //Calling the class "threadPlugin" we created that extends with Thread  
         run.start(); //run the thread to start the progress  
       
         /**Set all the Components Visible. 
          * If it is set to "false", the components in the container will not be visible. 
          */  
         frame.setVisible(true);
         
        }
        
        public void closeProgressWindow() 
        {
        	frame.dispose();
        }
        
    
    
    
          
     //Main Method  
        public static void main (String[] args) {  
         simpleProgressBar spb = new simpleProgressBar(350,100);  
     }  
    }
   
    
    class Progress extends Thread 
    {
	int Delay = 5; //Creating a delay or the speed of the progress bar  
	JProgressBar pb; //Constructing Progress Bar
	simpleProgressBar progressBar;
	
	//Creating a threadPlugin Method initializing JProgressBar so the Main Program "simpleProgressBar.java"  
	//can recognize by the time we call this class for JProgressBar action.  
    //Constructing JProgressBar and JButton   

	public Progress(simpleProgressBar _progressBar) 
	{  
		pb = _progressBar.bar;
		progressBar = _progressBar;
	}
	
	public void run() 
	{  
		int minimum = pb.getMinimum(); //initializing minimum value of the progress bar  
		int maximum = pb.getMaximum(); //initializing maximum value of the progress bar  
   
		//Initializing Progress from its minimum value 0 to its maximum value 100  
		for (int i = minimum; i < maximum; i++) {   
				try {  
				int value = pb.getValue();  
				pb.setValue(value + 1);  
       
     //Testing the progress bar if it already reaches to its maximum value  
					if (pb.getValue() >= maximum) 
					{  
       
					//Test confirmation if it runs perfectly          					
						JOptionPane.showMessageDialog(null, "Loaded Successful!","Loaded!",JOptionPane.INFORMATION_MESSAGE);
						progressBar.closeProgressWindow();
					}  
        
				Thread.sleep(Delay); //Implementing the speed of the progress bar  
   } catch (InterruptedException ignoredException) { //Catch an error if there is any  
   }
}
}
  }

   
   