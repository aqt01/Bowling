package Test;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/* Esta es una clase para testear los scores de la aplicaci—n, este
 * crea un archivo con puntuaciones aleatorias, aunque tambien tiene un 
 * metodo que le inserta basura al score para analizar el comportamiento de la aplicacion
 * en estos casos. 
 * */

public class TestCaseFileBuilder {

	private PrintWriter escritor;
	private JFrame frame;
	JFileChooser chooser; 
	
	public TestCaseFileBuilder() 
	{
		//WindowUtilities.

		chooser= new JFileChooser();
		chooser.showOpenDialog(frame);
		
		frame = new JFrame("FIle CHOOOSER");
		frame.setSize(200, 200);
		Container cont = frame.getContentPane();
		frame.setContentPane(cont);
		frame.setVisible(true);
		frame.setBackground(Color.white);
		frame.setLayout(new FlowLayout());
		JButton button = new JButton("hola");
		button.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				chooser = new JFileChooser();
				chooser.showOpenDialog(frame);				
				JOptionPane.showConfirmDialog(frame, chooser.getSelectedFile());
			}
		} );
		frame.add(button);
		
	}
	
	// El tercer parametro trash, es para generar codigo basura
	// si esta activado, no generara codigo basura (o de error) junto con los numeros
	
	public void escribir (String file, String text, Boolean trash) throws IOException 
	{
		escritor = new PrintWriter(new FileWriter(file));
		// Randon con numeros de los puntos
		Random rnd = new Random();
		// Random basura
		Random basura = new Random();
		
		String lbasura;
		
		
			// Genera 40 numeros al azar entre 0 y 10
			// representando a los numeros
			// nos interesa guardar el primer frame para saber si hubo chuza
		
			int frame1,frame2;
			for(int i = 0 ; i<20 ;i++)
			{	
				// Frame1
				frame1 =rnd.nextInt(11);
				
				escritor.println(frame1);				
				
				
				// Si se habilito el parametro basura, tirara basura luego de c/linea de puntos
				if(trash)
				{
					
					lbasura =  " " + String.valueOf(basura.nextBoolean()) + " " + String.valueOf(basura.nextDouble()) + " F " + String.valueOf(basura.nextFloat()) ;
					escritor.println(lbasura);
				}
				
				// Frame2
				
				frame2 =rnd.nextInt(11);
				
				// si hubo una chuza en el frame
					
				if(frame1==10) 
					escritor.println(frame2);
				else // si no hubo chuza , solo puede tumbar hasta el numero de bolos que quedo
					escritor.println(10 - frame1);
					
				
				// Si hubo una chuza al final de los frames
				if(i==18 || i==19) 
				{	// si en el ultimo del primer y/o segundo jugador hay chuza?
					if( frame1==10 ) // Se escribe el valor del frame extra
						escritor.println(rnd.nextInt(11));
					else			// Si no hubo una chuza, el valor final es 0 
						escritor.println("0");
				}
				
			}
			
			
		// imprime una linea en blanco
			
		escritor.println();
		// limpia el filewriter
		escritor.flush();
		escritor.close();
	}
	
	
		public static void main(String [] args) throws IOException 
		{
		
		System.out.println("klk");
		
		TestCaseFileBuilder feo = new TestCaseFileBuilder();
	//	feo.escribir();
		feo.escribir("klk.txt", "cosas",true);
		
		
	}
}

