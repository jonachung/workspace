
public class NumberArray {

	private int[] values;
	
	public NumberArray(int[] array)
	{
		values = array;
	}
	
	public int min()
	{
		int minInd = 0;
		for (int index = 0; index < values.length; index++)
		{
			if (values[index] < values[minInd])
			{
				minInd = index;
			}
		}
		return values[minInd];
	}
	
	public int max()
	{
		int maxInd = 0;
		for (int index = 0; index < values.length; index++)
		{
			if (values[index] > values[maxInd])
			{
				maxInd = index;
			}
		}
		return values[maxInd];
	}
	
	public int sum()
	{
		int total = 0;
		for (int value : values)
		{
			total += value;
		}
		return total;
	}
	
	public double average() 
	{
		double average;
		average = this.sum() / (double) values.length;
		return average;
	}
	
	public boolean contains(int number)
	{
		for (int value : values)
		{
			if (value == number)
			{
				return true;
			}
		}
		return false;
	}
	
	public int count(int number)
	{
		int numberOfTimes = 0;
		for (int value : values)
		{
			if (value == number)
			{
				numberOfTimes++;
			}
		}
		return numberOfTimes;
	}
	
	public int indexOf(int number)
	{
		for (int index = 0; index < values.length; index++)
		{
			if (values[index] == number)
			{
				return index;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(int number)
	{
		for (int index = values.length - 1; index >= 0; index--)
		{
			if (values[index] == number)
			{
				return index;
			}
		}
		return -1;
	}
	
	public void print()
	{
		for (int index = 0; index < values.length - 1; index++)
		{
			System.out.print(values[index] + ",");	
		}
		System.out.println(values[values.length - 1]);
	}
	
	public boolean swap(int index1, int index2) // supposed to check if true and false. and then change values to correct values. should be able to print out correct array.
	{
		if (index1 < values.length && index2 < values.length && index1 >= 0 && index2 >= 0)
		{
			int temp = values[index1];
			values[index1] = values[index2];
			values[index2] = temp;
			return true;
		}
		return false;	
	}
	
}
