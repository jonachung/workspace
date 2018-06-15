public class QueensEightVersion1 {
			
	private int[] queenPositions;

    public QueensEightVersion1(int numRowsAndCol) 
    {
        queenPositions = new int[numRowsAndCol];
        for (int index = 0; index < queenPositions.length; index++)
        {
        	queenPositions[index] = 0;
        }
    }

    /**
     * This method checks whether the position of the queen is valid at the location
     * specified by the row and column.
     * @param row
     * @param column
     * @return true if queen position is valid, false if not.
     */
    public boolean canPlaceQueen(int row, int column) 
    {	
    	
    	for (int rowNumber = 0; rowNumber < row; rowNumber++)
    	{
    		if (queenPositions[rowNumber] == column)
    		{
    			return false;
    		}
    	}
    	
    	for (int rowNumber = 0; rowNumber < row; rowNumber++) // left top diagonal
    	{
    		if (queenPositions[rowNumber] - rowNumber == column - row)
    		{
    			return false;
    		}
    	}
    	
    	for (int rowNumber = 0; rowNumber < row; rowNumber++) // left right diagonal
    	{
    		if (queenPositions[rowNumber] + rowNumber == column + row)
    		{
    			return false;
    		}
    	}
    		
    	return true;
    }

    /**
     * This method can find one solution of the Queens puzzle.
     */
    public void placeQueens() 
    {
    	int row = 0;
    	int column = 0;
    	int count = 0;
    	while (row >= 0)
    	{
    		if (column < queenPositions.length)
			{
    			if (this.canPlaceQueen(row, column))
        		{
        			queenPositions[row] = column;
        			if (row < queenPositions.length - 1)
        			{
        				row++;
                		column = 0;
        			} else
        			{
        				count++;
        				System.out.println("Solution: " + count);
        				System.out.println();
                		this.printQueensAlt();
        				column++;
        			}
        		} else
        		{
        			column++;
        		}
			} else 
			{
				--row;
				if (row >= 0)
				{
					column = queenPositions[row];
					column++;
				}
			}
    	}
    	//this.printQueensAlt();
    	
    	/**
    	 * Find the first solution by using method.
    	 * When can't find possible movements in a specific row, go to previous row (row - 1) 
    	 * and move that piece to next possible position.
    	 * When you find the first solution, print it out and then find another solution.
    	 * Do this by taking out last piece and moving previous row (row - 1) and move that piece 
    	 * to next possible position.
    	 * 
    	 */
    }
    
    /**
     * This method prints out the queens in a board-like shape.
     */
    public void printQueensAlt() 
    {   
        for (int row = 0; row < queenPositions.length; row++)
        {
        	for (int column = 0; column < queenPositions.length; column++)
        	{
        		if (queenPositions[row] == column)
        		{
        			System.out.print("Q ");
        		} else
        		{
        			System.out.print("* ");
        		}
        	}
        	System.out.println();
        }
    	System.out.println();
    }
}
