package View;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;



public class InitFrame 
{
	JFileChooser chooser;
	simpleProgressBar progres ;
	// Load the components onto the frame
	
	public int getMiddleFrameY(JFrame frame) 
	{		
		Toolkit kit = frame.getToolkit();		
	    int middleY = (kit.getScreenSize().height/2) - frame.getHeight()/2;
		return middleY;
	}
	
	
	public int getMiddleFrameX(JFrame frame) 
	{		
		Toolkit kit = frame.getToolkit();
		int middleX = (kit.getScreenSize().width/2) - frame.getWidth()/2;
	    return middleX;
		
	}
	
	public void LoadComponents(final JFrame frame) 
    {
    	
    	//Resize?
    	//frame.setSize(200,200);
		
		frame.setLocation( getMiddleFrameX(frame), getMiddleFrameY(frame));
    	frame.setDefaultLookAndFeelDecorated(false);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	
    	Container cont = frame.getContentPane(); 
    	cont.setLayout(new FlowLayout());
    	//JOptionPane.showMessageDialog(frame, "KLK");
    	Icon image = new ImageIcon(getClass().getResource("Splash.jpg"));
    	Icon iconLoad = new ImageIcon (getClass().getResource("Load.jpg"));
    	Icon iconExit = new ImageIcon (getClass().getResource("Exit.jpg"));
    	
    	JLabel buttonCharge = new JLabel(iconLoad);    	
    	JLabel buttonExit = new JLabel(iconExit);  
    	JLabel centeredImage = new JLabel(image);
    	
    	
    	// Acciones del mouse sobre botones "exit" y "load"
    	
    	buttonCharge.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				String path = FileChooser(frame);			
				
				String no = "NO";
				
				if(!path.equals(no))
				{
					 simpleProgressBar progres = new simpleProgressBar(100,100);
				}
				
			
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    	    	
    	buttonExit.addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				    	
				System.exit(0);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		 });
    	
    //	cont.add(backgroundImage);
    	cont.setLayout(new FlowLayout());
    	cont.add(centeredImage);
    	cont.add(buttonCharge);
    	cont.add(buttonExit);    	
    	frame.setVisible(true);
    	
    }
  
	// Funcion para llamar al JFilechooser y devolver su ruta absoluta 
	// al archivo seleccionado
	
	public String FileChooser(JFrame frame) 
	{
		int response = -1;
		String path= "NO";
		
		while(response != JOptionPane.YES_OPTION) 
		{
			chooser= new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text/Java files", "txt", "java");
			chooser.setFileFilter(filter);
			
			chooser.showOpenDialog(frame);								
			response = JOptionPane.showConfirmDialog(frame, "Want to load the file ?'" + chooser.getSelectedFile().getName()+  "'");
			// si se cancela, no retorna ruta
			progres.main(null);
			if(response==JOptionPane.CANCEL_OPTION)
			{
				response = JOptionPane.showConfirmDialog(frame, "Want to cacel the file load?");
				
				if(response == JOptionPane.CANCEL_OPTION)
				{
					path = FileChooser(frame);
				}
				break;			
			} 
			path = String.valueOf(chooser.getSelectedFile());
			
		}
		return path;
	}
	
}
