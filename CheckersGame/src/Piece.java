
/**
 * This class creates the piece object that will be used for the checkers game.
 * The piece has four properties which are the row and column locations, king or not 
 * king, and the color of the piece (red or not red). 
 * 
 * The methods that the piece class holds include becomesKing(), getRow(), getColumn(),
 * movePiece(), isRed(), isKing(). GetRow(), getColumn(), isRed(), and isKing() are getter
 * methods for the piece object. becomesKing() and movePiece() are setter methods that change
 * some of the properties the piece object has.
 * 
 * @author Jonathan
 *
 */
public class Piece {
	
	private boolean red;
	
	private boolean king;
	
	private int row;
	
	private int column;
	
	/**
	 * Creates piece object at a specific row and column location. The piece will have
	 * a color that is represented by a boolean value of true or false. (true -> red, false -> black).
	 * There is also a boolean value that represents whether the piece is a king or not that is
	 * automatically set to false for no king.
	 * @param red		color of piece
	 * @param row		row location of piece
	 * @param col		column location of piece
	 */
	public Piece(boolean red, int row, int col)
	{
		this.king = false;
		this.red = red;
		this.row = row;
		this.column = col;
	}
	
	/**
	 * Creates piece object at a specific row and column location. The piece will have
	 * a color that is represented by a boolean value for whether the color is red or not.
	 * There is also a boolean value that represents whether the piece is a king or not.
	 * @param king		if piece is king or not
	 * @param red		color of piece
	 * @param row		row location of piece
	 * @param col		column location of piece
	 */
	public Piece(boolean king, boolean red, int row, int col)
	{
		this.king = king;
		this.red = red;
		this.row = row;
		this.column = col;
	}
	
	/**
	 * This method makes a piece become a king by setting the boolean value for the king
	 * to be true since the piece will become a king piece.
	 */
	public void becomesKing()
	{
		this.king = true;
	}
	
	/**
	 * Gets row property of piece object.
	 * @return		row property of piece
	 */
	public int getRow()
	{
		return this.row;
	}
	
	/**
	 * Gets column property of piece object.
	 * @return		column property of piece
	 */
	public int getColumn()
	{
		return this.column;
	}
	
	/**
	 * Moves piece to a new location specified by the new user-specified
	 * row and column location.
	 * @param row		new row location of piece
	 * @param col		new column location of piece
	 */
	public void movePiece(int row, int col)
	{
		this.row = row;
		this.column = col;
	}
	
	/**
	 * Checks if piece is red or not. If piece is red, method returns true.
	 * If piece is not red (black), returns false.
	 * @return		Returns true if piece is red, returns false if piece is not red.
	 */
	public boolean isRed()
	{
		return this.red;
	}
	
	/**
	 * Checks if piece is king or not. If piece is king, method returns true.
	 * If piece is not king, returns false.
	 * @return		Returns true if piece is king, returns false if piece is not king.
	 */
	public boolean isKing()
	{
		return this.king;
	}

}
