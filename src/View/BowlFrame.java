package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.Player;
import Model.ResHelper;

@SuppressWarnings("serial")
public class BowlFrame extends JFrame
{
	private JPanel panel;
	private JButton close;
	private JButton min;
	private JLabel label;
	private JLabel label0;
	private JPanel content;
	private JButton backBtn;
	private JButton nextBtn;
	private Table Table0;
	private Table Table;
	private String FILE_PATH;
	private Player Player;
	private Player Player0;
	private ImageIcon titleIcon;
	private ImageIcon backIcon;
	private ImageIcon btnBIcon;
	private ImageIcon btnNIcon;
	private ImageIcon cbtn;
	private ImageIcon mbtn;
	private int bidx;
	private int nidx0;
	private int cnt;
	private int nidx;
	private int bidx0;
	
	public BowlFrame()
	{
		nidx = 0;
		nidx0 = 0;
		bidx = 0;
		cnt = 0;
		chooseFileWindow();
		titleInit();
		contentInit();
	}
	
	public String getFilePath() 
	{
		return FILE_PATH;
	}
	
	public void setPlayers(Player p0, Player p)
	{
		Player0 = p0;
		Player = p;
	}
	
	private void chooseFileWindow()
	{
		InitFrame init = new InitFrame();
		JFrame frame = new JFrame("Bowling Game");	
		
		SplashScreen splash = new SplashScreen(3000);
        
        // Normally, we'd call splash.showSplash() and get on 
        // with the program. But, since this is only a test...       
		
		splash.showSplash(300,250);		
		frame.setSize(400,400);		
		init.LoadComponents(frame);
		FILE_PATH = init.FileChooser(frame);
		
		frame.dispose();
		
	}
	
	private void contentInit() 
	{
		btnBIcon = new ImageIcon(getClass().getResource("bbtn.png"));
		btnBIcon = new ImageIcon(btnBIcon.getImage().getScaledInstance(ResHelper.WIDTH3, ResHelper.HEIGHT3,  java.awt.Image.SCALE_SMOOTH));
		
		btnNIcon = new ImageIcon(getClass().getResource("nbtn.png"));
		btnNIcon = new ImageIcon(btnNIcon.getImage().getScaledInstance(ResHelper.WIDTH3, ResHelper.HEIGHT3,  java.awt.Image.SCALE_SMOOTH));
		
		
		content = new JPanel();
		content.setLayout(null);
		content.setBackground(Color.DARK_GRAY);
		content.setBounds(0, panel.getHeight(), ResHelper.WIDTH, ResHelper.HEIGHT - panel.getHeight());
		
		Table = new Table();
		Table.setBounds(20, ResHelper.HEIGHT/4 + 10, 12*85, 100);
		Table0 = new Table();
		content.add(Table0);
		content.add(Table);
		
		backBtn = new JButton();
		backBtn.setBounds(ResHelper.X2, ResHelper.Y2, ResHelper.WIDTH2, ResHelper.HEIGHT2);
		backBtn.setIcon(btnBIcon);
		backBtn.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(cnt % 2 == 0)
					backwardLabelsP1();
				else 
					backwardLabelsP2();
				cnt++;
			}
		});
		content.add(backBtn);
		
		nextBtn = new JButton();
		nextBtn.setBounds(ResHelper.X3, ResHelper.Y3, ResHelper.WIDTH3, ResHelper.HEIGHT3);
		nextBtn.setIcon(btnNIcon);
		nextBtn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(cnt % 2 == 0)
					fowardLabelsP1();
				else fowardLabelsP2();
				cnt++;
			}
		});
		content.add(nextBtn);
		
		this.add(content);
	}
	
	protected void backwardLabelsP1() 
	{
		Table0.getTable().get(bidx0).labelF.setText("");
		Table0.getTable().get(bidx0).labelS.setText("");
		Table0.getTable().get(bidx0).labelT.setText("");
		nidx0 = bidx0;
		bidx0--;
	}
	
	protected void backwardLabelsP2() 
	{
		Table.getTable().get(bidx).labelF.setText("");
		Table.getTable().get(bidx).labelS.setText("");
		Table.getTable().get(bidx).labelT.setText("");
		nidx = bidx;
		bidx--;
	}

	protected void fowardLabelsP1() 
	{
		String t = Player0.getScoreFromIdx(nidx0).isStrike() ? "X":Player0.getScoreFromIdx(nidx0).getFirst();
		Table0.getTable().get(nidx0).labelF.setText(t);
		t = Player0.getScoreFromIdx(nidx0).isSpare() ? "/":Player0.getScoreFromIdx(nidx0).getSecond();
		Table0.getTable().get(nidx0).labelS.setText(t);
		Table0.getTable().get(nidx0).labelT.setText(Player0.getScoreFromIdx(nidx0).getTotal());
		
		if(Player0.getScoreFromIdx(nidx0).isTenth)
			Table0.getTable().get(nidx0).labelTr.setText(Player0.getScoreFromIdx(nidx0).getThird());
		
		nidx0 = (nidx0 + 1) % Table.getTable().size();
		bidx0 = nidx0;
	}
	
	protected void fowardLabelsP2() 
	{
		String t = Player.getScoreFromIdx(nidx).isStrike() ? "X":Player.getScoreFromIdx(nidx).getFirst();
		Table.getTable().get(nidx).labelF.setText(t);
		t = Player.getScoreFromIdx(nidx).isSpare() ? "/":Player0.getScoreFromIdx(nidx).getSecond();
		Table.getTable().get(nidx).labelS.setText(t);
		Table.getTable().get(nidx).labelT.setText(Player.getScoreFromIdx(nidx).getTotal());
		
		if(Player.getScoreFromIdx(nidx).isTenth)
			Table.getTable().get(nidx).labelTr.setText(Player.getScoreFromIdx(nidx).getThird());
		
		nidx = (nidx + 1) % Table.getTable().size();
		bidx = nidx;
	}
	
	private void titleInit()
	{
		titleIcon = new ImageIcon(getClass().getResource("tbar.png"));
		titleIcon = new ImageIcon(titleIcon.getImage().getScaledInstance(ResHelper.WIDTH0 + ResHelper.WIDTH0/7, ResHelper.HEIGHT0 + ResHelper.HEIGHT0/10,  java.awt.Image.SCALE_SMOOTH));
		
		cbtn = new ImageIcon(getClass().getResource("cbtn2.png"));
		cbtn = new ImageIcon(cbtn.getImage().getScaledInstance(ResHelper.WIDTHC - 10, ResHelper.HEIGHTC,  java.awt.Image.SCALE_SMOOTH));
		
		mbtn = new ImageIcon(getClass().getResource("mbtn.png"));
		mbtn = new ImageIcon(mbtn.getImage().getScaledInstance(ResHelper.WIDTHC, ResHelper.HEIGHTC,  java.awt.Image.SCALE_SMOOTH));
		
		backIcon = new ImageIcon(getClass().getResource("lab.png"));
		backIcon = new ImageIcon(backIcon.getImage().getScaledInstance(ResHelper.WIDTH3, ResHelper.HEIGHT3,  java.awt.Image.SCALE_SMOOTH));
		
		
		
		
		this.getContentPane().setLayout(null);
		this.setUndecorated(true);
		this.setBounds(ResHelper.X, ResHelper.Y, ResHelper.WIDTH, ResHelper.HEIGHT);
		
		/* Title bar panel */
		label = new JLabel();
		label.setBounds(ResHelper.X0, ResHelper.Y0, ResHelper.WIDTH0, ResHelper.HEIGHT0);
		label.setIcon(titleIcon);
		panel = new JPanel();
		panel.setBounds(ResHelper.X0, ResHelper.Y0, ResHelper.WIDTH0, ResHelper.HEIGHT0);
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		
	
		/* Close Button  */ 
		close = new JButton("X");
		close.setBounds(ResHelper.XC, ResHelper.YC, ResHelper.WIDTHC - 10, ResHelper.HEIGHTC);
		close.setIcon(cbtn);
		close.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				Container framed = close.getParent();
			    do 
			    	framed = framed.getParent(); 
			    while (!(framed instanceof JFrame));                                      
			    	((JFrame) framed).dispose();
			}
		});
		
		panel.add(close);
		
		final JFrame frame = this;
		
		/* Min Button */ 
		
		min = new JButton("-");
		min.setBounds(ResHelper.XM, ResHelper.YM, ResHelper.WIDTHM, ResHelper.HEIGHTM);
		min.setIcon(mbtn);
		min.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				frame.setState(Frame.ICONIFIED);
			}
		});
		
		label0 = new JLabel();
		label0.setIcon(backIcon);
		label0.setBounds(100, 0, ResHelper.WIDTH3, ResHelper.HEIGHT3);
		
		panel.add(min);
		panel.add(label0);
		panel.add(label);
		
		
		this.add(panel);
	}
}
