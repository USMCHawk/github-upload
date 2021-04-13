package program06;

public class Queue extends DynArray
{

	public int size()
	{
		return super.arraySize();
	}

	public boolean isEmpty()
	{
		return (super.elements() == 0);
	}
	
	public void que(double value)
	{
		super.insert(value);
	}
		
	public double deQue()
	{
		if (!this.isEmpty())
		{
			return super.removeAt(0);
		}
		else
		{
			return Double.NaN;
		}
	}
	
	public void queueDump()
	{
		super.printArray();
	}
}
