package Controller;

import java.io.IOException;
import java.util.List;

import sun.awt.EventQueueDelegate;

import com.sun.jdi.VirtualMachine;
import com.sun.jdi.event.EventQueue;
import com.sun.jdi.event.EventSet;

import Model.File_Reader;
import Model.Player;
import View.BowlFrame;

public class Master 
{
	public BowlFrame Bowl;
	private File_Reader Reader;
	private Player Player;
	private Player Player0;
	
	public Master()
	{
		Reader = new File_Reader();
	}
	
	public static void main(String[] args)
	{
		Master M = new Master();
		M.Bowl = new BowlFrame();
		M.Reader.setFile(M.Bowl.getFilePath());
		
		try {
			M.initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		M.setPlayers();
		
		M.Bowl.setVisible(true);
		M.PrintLists();
	}
	
	public void initialize() throws IOException
	{
		List<Player> P = this.Reader.Read_Input();
		this.Player0 = P.get(0);
		this.Player = P.get(1);
	}
	
	public void setPlayers()
	{
		Bowl.setPlayers(Player0, Player);
	}
	
	public void PrintLists() 
	{	
		System.out.println("Player0: ");
		System.out.println("____________");
		this.printEntireList(0);
		System.out.println("Size: " + this.Player0.getScore().size());
		System.out.println("____________");
		System.out.println("____________");
		System.out.println("Player: ");
		System.out.println("____________");
		this.printEntireList(1);
		System.out.println("Size: " + this.Player.getScore().size());
	}
	
	public Player getPlayer(int idx)
	{
		return idx == 1 ? Player : Player0;
	}
	
	public void printEntireList(int idx)
	{
		Player temp = getPlayer(idx);
		
		for(int i=0;i<temp.getScore().size();i++)
		{
				System.out.println(i + "-First : " + temp.getScoreFromIdx(i).getFirst());
				System.out.println(i + "-Second : " + temp.getScoreFromIdx(i).getSecond());
				System.out.println(i + "-Third : " + temp.getScoreFromIdx(i).getThird() + " total by now: " + temp.getScoreFromIdx(i).getTotal());
		}
	}
}
