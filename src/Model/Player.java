package Model;

import java.util.ArrayList;
import java.util.List;

public final class Player 
{
	private List<Shot> Shots;
	private int tenth = 0;
	private int idx = 0;
	private int score;
	
	public Player()
	{
		Shots = new ArrayList<Shot>();
	}
	
	public void addShot(String f, String s)
	{
		int sum = Integer.valueOf(f) + Integer.valueOf(s);
		
		Shot shot = new Shot(f, s, f.equals("10") , (sum == 10 && !s.equals("0")), f.equals("0"), s.equals("0"));

		tenth++;
		
		if(tenth == 10)
		{
			shot.isTenth = true;
		}
		else shot.isTenth = false;
		
		Shots.add(shot);
		if(shot.isTenth)
			calcScore();
	}
	
	public void addShot(String f, String s, String t)
	{
		int sum = Integer.valueOf(f) + Integer.valueOf(s);
		
		Shot shot = new Shot(f, s, f.equals("10") , (sum == 10 && !s.equals("0")), f.equals("0"), s.equals("0"));

		tenth++;
		
		if(tenth == 10)
		{
			shot.isTenth = true;
		}
		else shot.isTenth = false;
		
		Shots.add(shot);
		if(shot.isTenth)
			calcScore();
	}
	
	public void calcScore()
	{
		Shot nextShot;
				
		for (int i=0; i < Shots.size(); i++)
		{	
			//if last frame
			if(i == 9) 
			{
				score += calcTenthFrame(Shots.get(i));
				Shots.get(i).setTotal(String.valueOf(score));
			}
			else
			{		
				if(Shots.get(i).isSpare())
				{
					nextShot = Shots.get(i+1);
					score += 10 + Integer.valueOf(nextShot.getFirst());
				}
				//if next ball is a strike, add the next frame's first ball.
				else if( Shots.get(i).isStrike() && (i+1)!=9)
				{
					nextShot = Shots.get(i+1);
					score += 10;
					if (nextShot.isStrike())					
					{	
						score += 10;
						nextShot = Shots.get(i+2);
						score += Integer.valueOf(nextShot.getFirst());
					}
					else
						score += calcFrameScore(nextShot);
				}
				else if( Shots.get(i).isStrike() && (i+1)==9)
				{
					nextShot = Shots.get(i+1);
					score += 10;
					if (nextShot.isStrike())					
					{	
						score += 10 + Integer.valueOf(nextShot.getSecond());
					}
					score += Integer.valueOf(nextShot.getFirst()) + Integer.valueOf(nextShot.getSecond());
				}
				else
					score += calcFrameScore(Shots.get(i));
				Shots.get(i).setTotal(String.valueOf(score));
			}
		
		}		
	}
	
	public int calcTenthFrame(Shot shot)
	{
		if (shot.getSecond().equals("10"))
			return 10 + Integer.valueOf(shot.getThird());		
		else if (shot.getThird() != null && shot.getThird().equals("10"))
			return 10 + Integer.valueOf(shot.getFirst());
		else
			return Integer.valueOf(Integer.valueOf(shot.getFirst()) + Integer.valueOf(shot.getSecond()));
	}
	
	public int calcFrameScore(Shot shot)
	{
		return Integer.valueOf(Integer.valueOf(shot.getFirst()) + Integer.valueOf(shot.getSecond()));	
	}
	
	
	public Shot getScoreFromIdx(int idx)
	{
		return Shots.get(idx);
	}
	
	public Shot netxShot()
	{
		if(idx < Shots.size())
			idx++;
		return Shots.get(idx-1);
	}
	
	public Shot previousShot()
	{
		if(idx > 1)
			idx--;
		return Shots.get(idx-1);
	}
	
	public List<Shot> getScore()
	{
		return Shots;
	}
	
	public boolean isStrike(int idx)
	{
		return Shots.get(idx).isStrike();
	}
	
	public boolean isNothing(int idx)
	{
		return Shots.get(idx).isNothing();
	}
	
	public boolean isNothing0(int idx)
	{
		return Shots.get(idx).isNothing0();
	}
	public boolean isSpare(int idx)
	{
		return Shots.get(idx).isSpare();
	}
}
