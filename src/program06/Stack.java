package program06;

public class Stack extends DynArray 
{
	public int size()
	{
		return super.elements()-1;
	}

	public boolean isEmpty()
	{
		return (super.elements() == 0);
	}
	
	public void push(double value)
	{
		super.insert(value);
	}
	
	public double pop()
	{
		if (!this.isEmpty())
		{
			return super.remove();
		}
		else
		{
			return Double.NaN;
		}
	}
	
	public void stackDump()
	{
		for (int i = this.size(); i >= 0; --i)
		{
			System.out.printf("array.at(%d) = " + super.at(i) + "\n", i);	
		}
	}
}
