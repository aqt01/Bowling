package Model;

public class Shot 
{
	private String First;
	private String Second;
	private String Third;
	private String Total;
	private boolean Spare;
	private boolean Strike;
	private boolean Nothing0;
	private boolean Nothing;
	public boolean isTenth;
	
	public Shot(String first, String second, boolean strike, boolean spare, boolean nothing0, boolean nothing)
	{
		First = first;
		Second = second;
		Spare = spare;
		Strike = strike;
		Nothing0 = nothing0;
		Nothing = nothing;
	}
	
	public String getFirst() 
	{
		return First;
	}

	public void setFirst(String first) 
	{
		First = first;
	}

	public String getSecond() 
	{
		return Second;
	}

	public void setSecond(String second) 
	{
		Second = second;
	}

	public boolean isSpare() 
	{
		return Spare;
	}

	public void setSpare(boolean spare) 
	{
		Spare = spare;
	}

	public boolean isStrike() 
	{
		return Strike;
	}

	public void setStrike(boolean strike) 
	{
		Strike = strike;
	}

	public boolean isNothing0() 
	{
		return Nothing0;
	}

	public void setNothing0(boolean nothing0) 
	{
		Nothing0 = nothing0;
	}

	public boolean isNothing() 
	{
		return Nothing;
	}
	

	public void setNothing(boolean nothing) 
	{
		Nothing = nothing;
	}

	public String getTotal() 
	{
		return Total;
	}

	public void setTotal(String total) 
	{
		Total = total;
	}

	public String getThird() 
	{
		return Third;
	}

	public void setThird(String third) 
	{
		Third = third;
	}
}
