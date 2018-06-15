/**
 * This class creates a sudoku board and checks if the solution of the sudoku board is
 * valid or not. A valid solution would be that each column and each row as well as each subSquare 
 * are in a permutation from 1 to 9. There is a constructor that is used to create a sudoku board as 
 * well as two methods. One method is a permutation checker and the other method is a checker that uses 
 * the permutation checker to check if the sudoku board is a valid solution or not.
 * 
 * The permutation checker is a boolean method that checks if array of integers is a permutation or not. 
 * A random permutation is a random sequence that includes all numbers from starting value to end value 
 * with no duplicates. 
 * 
 * The checker method uses the permutationChecker method to see if the columns, rows, and subSquares 
 * of the board are valid solutions. This method also tells the user the number of columns,
 * rows, and/or subsquares that failed by listing them out. If the sudoku board is a valid solution, then 
 * the number of columns, rows, and subsquares that failed should be 0.
 * 
 * @author Jonathan
 *
 */
public class SudokuChecker {
	
	private int[][] sudokuBoard;
	
	public static final int BOARD_DIMENSION = 9;
	
	public static final int SUBSQUARE_SIDE_LENGTH = 3;
	
	/**
	 * This method creates a sudoku board. If the array doesn't exist, then a new default sudoku board
	 * will be created and it will be filled with zeros.
	 * @param array		The array stores the sudoku board solution.
	 */
	public SudokuChecker(int[][] array)
	{
		if (array == null)
		{
			sudokuBoard = new int[BOARD_DIMENSION][BOARD_DIMENSION]; 
			System.out.println("ERROR");
			for (int row = 0; row < sudokuBoard.length; row++)
			{
				for (int column = 0; column < sudokuBoard.length; column++)
				{
					sudokuBoard[row][column] = 0;
				}
			}
		} else
		{
			sudokuBoard = array;
		}
	}
	
	/**
	 * Checks if array of integers is a permutation or not. However, if the permutation was sorted, then the numbers would be 
	 * incrementing by one each time. A random permutation is a random sequence that includes all numbers from starting value 
	 * to end value with no duplicates.
	 * @param array		Array that is checked if permutation or not.
	 * @return		Returns true if is, false if not.
	 */
	public boolean permutationChecker(int[] array)
	{
		if (array != null && array.length > 0) {
			int endNumber = array[0];
			int beginNumber = array[0];
			boolean[] groupArray = new boolean[array.length];
			for (int index = 0; index < array.length; index++) {
				if (array[index] < beginNumber) {
					beginNumber = array[index];
				}
				if (array[index] > endNumber) {
					endNumber = array[index];
				}
				groupArray[index] = false;
			}
			if (endNumber - beginNumber + 1 == groupArray.length) {
				for (int index = 0; index < array.length; index++) {
					int compareIndex = array[index] - beginNumber;
					if (groupArray[compareIndex]) {
						return false;
					}
					groupArray[compareIndex] = true;
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method uses the permutationChecker method to see if the columns, rows, and subSquares of the board are valid solutions.
	 * A valid solution would be that each column and each row as well as each subSquare are in a permutation from 1 to 9.
	 * A random permutation is a random sequence that includes all numbers from starting value to end value with no duplicates.
	 * This method also tells the user the number of columns, rows, and/or subsquares that failed.
	 * @return		Returns false if not, true if all are valid solutions.
	 */
	public boolean checker()
	{
		int[] columnArray = new int[sudokuBoard.length];
		int[] subSquareArray = new int[sudokuBoard.length];
		int columnCounter = 0;
		int subSquareCounter = 0;
		int rowCounter = 0;
		for (int row = 0; row < sudokuBoard.length; row++)
		{
			if (!this.permutationChecker(sudokuBoard[row]))
			{
				rowCounter++;
			}
			for (int column = 0; column < sudokuBoard.length; column++)
			{
				columnArray[column] = sudokuBoard[column][row];
				subSquareArray[column] = sudokuBoard[column / SUBSQUARE_SIDE_LENGTH + SUBSQUARE_SIDE_LENGTH * (row % SUBSQUARE_SIDE_LENGTH)][column % SUBSQUARE_SIDE_LENGTH + SUBSQUARE_SIDE_LENGTH * (row / SUBSQUARE_SIDE_LENGTH)];
			}
			if (!this.permutationChecker(columnArray))
			{
				columnCounter++;
			} 
			if (!this.permutationChecker(subSquareArray))
			{
				subSquareCounter++;
			}
		}
		System.out.println(columnCounter + " " + "columns failed.");
		System.out.println(rowCounter + " " + "rows failed.");
		System.out.println(subSquareCounter + " " + "subSquares failed.");
		return ((rowCounter + columnCounter + subSquareCounter) == 0);
		
	}

}
