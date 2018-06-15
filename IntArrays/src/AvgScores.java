
public class AvgScores {

	public static void main(String[] args) {
		int min = Integer.parseInt(args[0]);
		int max = Integer.parseInt(args[0]);
		int total = 0;
		double average;
		for (int index = 0; index < args.length; index++)
		{
			int value = Integer.parseInt(args[index]);
			if (value < min)
			{
				min = value;
			} else if (value > max)
			{
				max = value;
			}
			total += value;
		}
		average = (total - (min + max)) / (args.length - 2);
		System.out.println(average);
	}

}
