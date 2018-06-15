
public class Sorted {

	public static void main(String[] args) {
		
		String swap;
		int swapCount = 0;
		int[] sortedArray = new int[args.length];
		do{
			for (int index = 1; index < args.length; index++){
				if(Integer.parseInt(args[index - 1]) > Integer.parseInt(args[index])){
					swap = args[index - 1];
					args[index - 1] = args[index];
					args[index] = swap; 
					swapCount += 1;
					}
				}
			}while(swapCount > 0); 
		for (int index = 0; index < args.length; index++)
		{
			sortedArray[index] = Integer.parseInt(args[index]);
		}
		System.out.println(sortedArray.toString());		
	}

}
