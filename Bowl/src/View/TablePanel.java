package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TablePanel extends JPanel
{
	public JLabel labelF;
	public JLabel labelS;
	public JLabel labelTr;
	public JLabel labelT;
	public JPanel panel;
	
	public TablePanel(boolean last)
	{
		init(last);
	}
	
	public void init(boolean last)
	{
		this.setLayout(null);	
		this.setBounds(0, 0, 85, 70);
		
		labelF = new JLabel("");
		labelF.setBounds(0, 0, 35, 35);
		labelF.setOpaque(true);
		labelF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelF.setBackground(Color.GRAY);
		labelF.setForeground(Color.WHITE);
		labelF.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		this.add(labelF);
		
		labelS = new JLabel("");
		labelS.setOpaque(true);
		labelS.setBackground(Color.GRAY);
		labelS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelS.setForeground(Color.WHITE);
		labelS.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		labelT = new JLabel("");
		labelT.setOpaque(true);
		labelT.setBackground(Color.GRAY);
		labelT.setFont(new Font("Tahoma", Font.PLAIN, 36));
		labelT.setForeground(Color.WHITE);
		labelT.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		if(!last)
		{
			labelS.setBounds(35, 0, 50, 45);
			labelT.setBounds(0, 35, 85, 70);
		}
		else 
		{
			labelS.setBounds(35, 0, 35, 45);
			
			labelT.setBounds(0, 35, 100, 70);
			
			labelTr = new JLabel();
			labelTr.setBounds(65, 0, 35, 45);
			labelTr.setOpaque(true);
			labelTr.setBackground(Color.GRAY);
			labelTr.setForeground(Color.WHITE);
			labelTr.setFont(new Font("Tahoma", Font.PLAIN, 14));
			labelTr.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			this.add(labelTr);
		}

		this.add(labelS);
		
		this.add(labelT);
	}
}
