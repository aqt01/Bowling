package View;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Model.ResHelper;

@SuppressWarnings("serial")
public class Table extends JPanel
{
	private List<TablePanel> Tabs;
	private JPanel panel;
	
	public Table()
	{
		init();
	}
	
	public void init()
	{
		this.setLayout(null);
		this.setBounds(20, 20, 19 * 95, 100);
		this.setBackground(Color.DARK_GRAY);
		Tabs = new ArrayList<TablePanel>();
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 21 * 50, 100);
		panel.setLayout(null);
		
		TablePanel t = new TablePanel(false);
		
		for(int i=0;i<ResHelper.TABLE_PANEL_SIZE;i++)
		{
			t = new TablePanel(i == 9);
			if(i != 9)
				t.setBounds(i * 87, 0, 85, 100);
			else t.setBounds(i * 87, 0, 100,  100);
			
			Tabs.add(t);
			panel.add(t);
		}
		this.add(panel);
	}
	
	public List<TablePanel> getTable()
	{
		return Tabs;
	}
	
	public TablePanel getShotPanel(int idx)
	{
		return Tabs.get(idx);
	}
}
