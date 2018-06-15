/**
 * This class is used to find all the solutions for the NQueens puzzle. A
 * solution of the NQueens puzzle occurs when there are N queens placed on the
 * board in a way, so that they do not "eat" each other. In order for a piece to
 * eat another piece, the piece has to intersect the piece diagonally,
 * vertically, or horizontally across the board.
 * 
 * This class finds the solutions for the NQueens puzzle by using the
 * findSolutions method, which uses two variables for the row and column to iterate through
 * the board. The findSolutions method places the queen at the first valid
 * location in the first row then moves to the next row and does the same thing
 * again. After a piece is placed in a valid location, the invalid positions
 * that are created by that piece are marked on the array, so there would
 * not be any queens placed at those locations.
 * 
 * However, when a row on the board has no valid positions, the findSolutions
 * method would backtrack to the previous row and then move that queen on
 * the previous row to the next valid position on the same row. The invalid
 * positions caused by that queen before would be erased and then the new
 * invalid positions caused by that queen when it reaches its new location
 * would be marked. If there are no valid positions in that row, then the
 * findSolutions method would backtrack to the previous row before.
 * 
 * When the findSolutions method places a queen on the last row, a solution is
 * found and would be printed out through the printQueens method. The
 * solution will be shown on the board for 500 milliseconds. After a
 * solution is found, the findSolutions method would erase the queen from the board
 * and place the queen at its next valid position. When the findSolutions method 
 * backtracks all the way to the first row, then all the solutions are found. After 
 * all the solutions are printed out, the number of solutions found would be returned 
 * as well.
 * 
 * This class has a main method that runs the NQueens puzzle when given a user
 * input of an integer that will give the number of queens the user wants the
 * puzzle to be for. The program will proceed to find the solutions for the
 * puzzle as well as a statement that says how many solutions were found in the
 * puzzle. If the user input is a negative number or zero or the user forgets to
 * add a number input, the program will print an error message and get the
 * solutions for a default 8 * 8 board.
 * 
 * @author Jonathan
 *
 */
public class NQueens {

	private int[][] queenArray;
	
	public static final int DEFAULT_LENGTH = 8;
	
	public static final int QUEEN = -1;
	
	public static final int EMPTY = 0;

	/**
	 * Constructs NQueens object with a integer array with user-specified
	 * length. If the user-specified length of the array is less than one, an
	 * error message would print out and a default array of length 8 will be created. 
	 * The integer array represents the board for the NQueens puzzle.
	 * 
	 * @param numRowsAndCol
	 *            the size of the String array.
	 */
	public NQueens(int numRowsAndCol) {
		if (numRowsAndCol < 1) {
			System.out.println("Error. Invalid number of queens. Finding solutions for 8 * 8 board...");
			numRowsAndCol = DEFAULT_LENGTH;
		}
		queenArray = new int[numRowsAndCol][numRowsAndCol];
		for (int row = 0; row < queenArray.length; row++) {
			for (int column = 0; column < queenArray.length; column++) {
				queenArray[row][column] = EMPTY;
			}
		}
		this.drawBoard();
	}

	/**
	 * This method prints the location of the queens and the empty spaces on the
	 * board.
	 */
	public void printBoard() {
		for (int row = 0; row < queenArray.length; row++) {
			for (int column = 0; column < queenArray.length; column++) {
				if (queenArray[row][column] < 0) {
					System.out.print("Q ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * This method takes a user-specified row and user-specified column
	 * variables, which represent the row and column of a potential queen in the
	 * board. The queen is placed on the board. Then the method iterates through
	 * the bottom left and right diagonals as well as the bottom portion of the
	 * column based on the queen's location and marks the invalid positions by
	 * adding one to those values. The image of the queen will be presented onto
	 * the board GUI on the user specified row and column location. It will pause 
	 * and display for a short amount of time.
	 * 
	 * 
	 * @param row
	 *            the row value of the queen
	 * @param column
	 *            the column value of the queen
	 */
	public void placeQueen(int row, int column) {
		final int FAST_TIME = 50;
		queenArray[row][column] = QUEEN;
		this.drawQueen(row, column, FAST_TIME);
		for (int factor = 1; factor < queenArray.length - row; factor++) {
			queenArray[row + factor][column]++;
			if (column + factor < queenArray.length && row + factor < queenArray.length) {
				queenArray[row + factor][column + factor]++;
			}
			if (column - factor >= 0 && row + factor < queenArray.length) {
				queenArray[row + factor][column - factor]++;
			}
		}
	}

	/**
	 * This method erases the invalid positions caused by a queen and erases the
	 * queen as well. The method erases the invalid positions by decrementing
	 * their values of the board by one. This method iterates through the bottom
	 * left and right diagonals and the bottom portion of the column, which is
	 * dependent on the location of the queen that will be removed. After the
	 * invalid positions are removed, the queen is removed from the array by
	 * setting the value of its location to 0. The queen is removed from the board GUI
	 * by drawing another square of the same color over the queen.
	 * 
	 * @param row
	 *            the row value of the queen
	 * @param column
	 *            the column value of the queen
	 */
	public void removeQueen(int row, int column) {
		for (int factor = 1; factor < queenArray.length - row; factor++) {
			queenArray[row + factor][column]--;
			if (column + factor < queenArray.length && row + factor < queenArray.length) {
				queenArray[row + factor][column + factor]--;
			}
			if (column - factor >= 0 && row + factor < queenArray.length) {
				queenArray[row + factor][column - factor]--;
			}
		}
		queenArray[row][column] = EMPTY;
		this.drawSquare(row, column);
	}

	/**
	 * This method uses two variables for the row and column to iterate through
	 * the board. The findSolutions method places the queen at the first valid
	 * location in the first row then moves to the next row and does the same thing
	 * again. After a piece is placed in a valid location, the invalid positions
	 * that are created by that piece are marked on the array, so there would
	 * not be any queens placed at those locations.
	 * 
	 * However, when a row on the board has no valid positions, the findSolutions
	 * method would backtrack to the previous row and then move that queen on
	 * the previous row to the next valid position on the same row. The invalid
	 * positions caused by that queen before would be erased and then the new
	 * invalid positions caused by that queen when it reaches its new location
	 * would be marked. If there are no valid positions in that row, then the
	 * findSolutions method would backtrack to the previous row before.
	 * 
	 * When the findSolutions method places a queen on the last row, a solution is
	 * found and would be printed out through the printQueens method. The
	 * solution will be shown on the board for 500 milliseconds. After a
	 * solution is found, the findSolutions method would erase the queen from the board
	 * and place the queen at its next valid position. When the findSolutions method 
	 * backtracks all the way to the first row, then all the solutions are found. After 
	 * all the solutions are printed out, the number of solutions found would be returned 
	 * as well.
	 * 
	 * @return		number of solutions found in puzzle
	 */
	public int findSolutions() {
		int row = 0;
		int column = 0;
		int count = 0;
		final int SHOW_SOLUTION_TIME = 500;
		int[] queenPositions = new int[queenArray.length];
		while (row >= 0) {
			if (column < queenArray.length) {
				if (queenArray[row][column] == EMPTY) {
					if (row < queenPositions.length - 1) {
						queenPositions[row] = column;
						this.placeQueen(row, column);
						row++;
						column = 0;
					} else {
						queenArray[row][column] = QUEEN;
						this.drawQueen(row, column, SHOW_SOLUTION_TIME);
						count++;
						System.out.println("Solution: " + count);
						System.out.println();
						this.printBoard();
						queenArray[row][column] = EMPTY;
						this.drawSquare(row, column);
						column++;
					}
				} else {
					column++;
				}
			} else {
				row--;
				if (row >= 0) {
					this.removeQueen(row, queenPositions[row]);
					column = queenPositions[row] + 1;
				}
			}
		}
		return count;
	}

	/**
	 * Draws the checker board of length based on the number of queens using
	 * methods from the StdDrawPlus class by looping through the array of queens
	 * and drawing squares of red or gray depending on the row and column
	 * coordinates of the squares.
	 */
	public void drawBoard() {
		int length = queenArray.length;
		StdDrawPlus.setXscale(0, length);
		StdDrawPlus.setYscale(0, length);
		for (int row = 0; row < queenArray.length; row++) {
			for (int column = 0; column < queenArray.length; column++) {
				this.drawSquare(row, column);
			}
		}
	}

	/**
	 * Draws the queen on the board created by methods of the StdDrawPlus class.
	 * The queen is drawn using an image of the queen and is drawn on the
	 * user-specified row and column locations. The simulation is paused for a user-specified
	 * time in milliseconds before another queen will be put on the board.
	 * 
	 * @param row
	 *            the row value of the queen
	 * @param column
	 *            the column value of the queen
	 */
	public void drawQueen(int row, int column, int time) {
		final double BORDER = 0.5;
		StdDrawPlus.picture(column + BORDER, queenArray.length - row - BORDER, "images/queen-dark.png", 1, 1);
		StdDrawPlus.show(time);
	}

	/**
	 * Draws a square on the GUI using methods from the StdDrawPlus class based
	 * on its row and column location on the board. The square will also be
	 * colored red or gray based on its respective row and column locations.
	 * 
	 * @param row
	 *            the row value of the queen
	 * @param column
	 *            the column value of the queen
	 */
	public void drawSquare(int row, int column) {
		final double BORDER = 0.5;
		if (row % 2 == column % 2) {
			StdDrawPlus.setPenColor(StdDrawPlus.RED);
			StdDrawPlus.filledSquare(column + BORDER, queenArray.length - row - BORDER, BORDER);
		} else {
			StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
			StdDrawPlus.filledSquare(column + BORDER, queenArray.length - row - BORDER, BORDER);
		}
	}

	/**
	 * Runs the NQueens puzzle when given a user input of an integer that will
	 * give the number of queens the user wants the puzzle to be for. The
	 * program will proceed to find the solutions for the puzzle as well as a
	 * statement that says how many solutions were found in the puzzle. If the
	 * user input is a negative number or zero or the user forgets to add a
	 * number input, the program will print an error message and get the
	 * solutions for a default 8 * 8 board.
	 * 
	 * @param args
	 *            user input for length of board
	 */
	public static void main(String[] args) 
	{
		int num = DEFAULT_LENGTH;
		if (args.length == 1)
		{
			num = Integer.parseInt(args[0]);
		} else
		{
			System.out.println("Error. Usage: NQueens boardLength. Finding solutions for 8 * 8 board...");
		}
		NQueens puzzle = new NQueens(num);
		System.out.println("There are " + puzzle.findSolutions() + " solutions for " + puzzle.queenArray.length + " by " + puzzle.queenArray.length + " board.");
		
	}

}
