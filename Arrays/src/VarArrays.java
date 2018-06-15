
public class VarArrays {
	
	public int sum(int... values)
	{
		int total = 0;
		for (int index = 0; index < values.length; index++)
		{
			total += values[index];
		}
		return total;
	}

	public static void main(String[] args) {
		VarArrays array = new VarArrays();
		System.out.println(array.sum(10, 7));
		System.out.println(array.sum(1,7,2,9));
	}

}
