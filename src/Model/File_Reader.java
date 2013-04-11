package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class File_Reader 
{
	/* 
	 * 1- 166
	 * 2- 172
	 * 
	 */
	
	private File file;
	
	public File_Reader()
	{
		
	}
	
	public void setFile(String fil)
	{
		file = new File(fil);
	}
	
	public List<Player> Read_Input() throws IOException
	{
	    Player player0 = new Player();
		Player player = new Player();
	    
		BufferedReader br = new BufferedReader(new FileReader(file));
	    
		int cnt = 0;
		try 
	    {
	        String line;
	        String f = "", s = "", t = "";
	        
	        while ((line = br.readLine()) != null && cnt < 21) 
	        {
	        	if(cnt % 2 == 0)
	        	{
	        		f = String.valueOf(line);
	        		
	        		line = br.readLine();
	        		
	        		s = String.valueOf(line);
	        		if(cnt <= 19)
	        			player0.addShot(f, s);
	        		else  
	        		{
	        			line = br.readLine();
	        			
	        			t = String.valueOf(line);
	        			player0.addShot(f, s, t);
	        		}
	        	}
	        	else 
	        	{
	        		f = String.valueOf(line);
	        		
	        		line = br.readLine();
	        		
	        		s = String.valueOf(line);
	        		
	        		if(cnt <= 19)
	        			player.addShot(f, s);
	        		else 
	        		{
	        			line = br.readLine();
	        			
	        			t = String.valueOf(line);
	        			player.addShot(f, s, t);
	        		}
	        	}
	            cnt++;
	        }
	    } 
		finally 
	    {
	        br.close();
	    }
		System.out.println(cnt);
		List<Player> K = new ArrayList<Player>();
		K.add(player0);
		K.add(player);
		
		return K;
	}
}
