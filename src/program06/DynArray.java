package program06;

public class DynArray 
{
	private double[] array;
	private int size;
	private int nextIndex;
	
	public DynArray() // default constructor
	{
		this.array = new double[1];
		this.size = 1;
		this.nextIndex = 0;
	}
	
	public int arraySize() // accessor for size
	{
		return this.size;
	}
	
	public int elements() // accessor for nextIndex
	{
		return this.nextIndex;
	}
	
	public double at(int index) // accessor for array
	{
		if (0 <= index && index < this.elements())
		{
			return this.array[index];
		}
		else
		{
			return Double.NaN;
		}
	}

	private void grow() //mutator for array size
	{
		double[] temp = new double[this.arraySize()*2];
		System.arraycopy(this.array, 0, temp, 0, this.arraySize());
		this.array = temp;
		this.size = temp.length;
	}
	
	private void shrink() //mutator for array size
	{
		double[] temp = new double[this.arraySize()/2];
		System.arraycopy(this.array, 0, temp, 0, this.arraySize()/2);
		this.array = temp;
		this.size = temp.length;
	}
	
	public void insertAt(int index, double value) // mutator for array
	{
		if (this.arraySize() == this.elements())
		{
			this.grow();
		}
		
		if (0 <= index && index <= this.elements())
		{
			for (int i = this.elements(); i > index; i--)
			{
				this.array[i] = this.array[i - 1];
			}
			this.array[index] = value;
			this.nextIndex++;
		}
		else
		{
			return;
		}
	}
	
	public void insert(double value) // mutator for array - adds element at nextIndex
	{
		this.insertAt(this.elements(), value);
	}
	
	public double removeAt(int index) // mutator to remove from array at an index
	{
		if (index >= this.elements())
		{
			return Double.NaN;
		}
		double oldValue = this.array[index];

		if (0 <= index && index <= this.elements()-1)
		{
			for (int i = index; i < this.elements(); i++)
			{
				this.array[i] = this.array[i + 1];
			}
		}

		if (this.elements() == this.arraySize()/2)
		{
			this.shrink();
		}
		
		if (this.elements() > 0)
		{
			this.nextIndex--;
		}
		else
		{
			return Double.NaN;
		}
		return oldValue;
	}
	
	public double remove() // mutator
	{
		if (this.elements() > 0)
		{
			return(this.removeAt(this.elements()-1));	
		}
		else
		{
			return Double.NaN;
		}
	}
	
	public void printArray() // accessor to print the array
	{
		for (int i = 0; i < this.elements(); i++)
		{
			System.out.printf("array.at(%d) = " + this.array[i] + "\n", i);
		}
	}
}
