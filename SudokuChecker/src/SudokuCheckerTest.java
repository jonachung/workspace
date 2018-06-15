
public class SudokuCheckerTest {
	
	public static void main(String[] args)
	{
		int[][] array = 						{{1,2,3,4,5,6,7,8,9}, 
												{4,5,6,4,5,6,7,8,9}, 
												{9,8,7,4,5,6,7,8,9},
												{1,2,3,4,5,6,7,8,9},
												{1,2,3,4,5,6,7,8,9},
												{1,2,3,4,5,6,7,8,9},
												{1,2,3,4,5,6,7,8,9},
												{1,2,3,4,5,6,7,8,9},
												{1,2,3,4,5,6,7,8,9}};
		
		SudokuChecker board = new SudokuChecker(array);
		//System.out.println(board.rowChecker());
		System.out.println(board.checker());
		//System.out.println(board.subSquareChecker());
	}
	
	
}


