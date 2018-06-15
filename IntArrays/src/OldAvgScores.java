
public class OldAvgScores {

	public static void main(String[] args) {
		
		IntArrays averageArray = new IntArrays(args.length);
		for (int index = 0; index < args.length; index++)
		{
			averageArray.add(Integer.parseInt(args[index]));
		}
		averageArray.remove(averageArray.min());
		averageArray.remove(averageArray.max());
		System.out.println(averageArray.average());
	}

}
