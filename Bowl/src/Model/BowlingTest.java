package Model;

import org.junit.Test;

import Controller.Master;

public class BowlingTest 
{

	@Test
	public void test() 
	{
		
		//assertEquals(true, true);
		//assertNotNull("", null);
	    //fail("Not yet implemented");
		
	}
	
	@Test(expected = NullPointerException.class)
	public void test0()
	{
		throw new NullPointerException();
	}

}