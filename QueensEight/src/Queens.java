
public class Queens {
	
	public static void main(String[] args)
	{
		//int[][] board = new int[2][8];
		for (int firstRowPosition = 0; firstRowPosition < 8; firstRowPosition++)
		{
			for (int secondRowPosition = 0; secondRowPosition < 8; secondRowPosition++)
			{
				for (int thirdRowPosition = 0; thirdRowPosition < 8; thirdRowPosition++)
				{
					System.out.println("(" + firstRowPosition + "," + secondRowPosition + "," + thirdRowPosition +  ")");
				}
			}
		}
	}

}
