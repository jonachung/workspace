
public class Piece { // the hard one
	
	private int xCoordinate;
	
	private int yCoordinate;
	
	// initial variable (boolean) for if piece is on bottom or top
	// initial variable (boolean) for if piece 
	
	private boolean position; //true is bottom, false is top.
	
	private boolean crown; //true is crown, false is no crown.
	
	public static final int X_LEFT = 0;
	
	public static final int Y_BOTTOM = 0;
	
	public static final int Y_TOP = 7;
	
	public static final int X_RIGHT = 7;
	
	public Piece(int x, int y, boolean place, boolean king) //initialize instance variables properly ex. can't have -1000, -1000
	{
		if (((y % 2) == (x % 2)) && (x >= Piece.X_LEFT && x <= Piece.X_RIGHT) && (y >= Piece.Y_BOTTOM && y <= Piece.Y_TOP)) // check gray piece // 0 and 7 should be constants
		{
			xCoordinate = x;
			yCoordinate = y;
			position = place;
			crown = king;
		} else
		{
			System.out.println("OUT OF RANGE. DEFAULT COORDINATES ARE NOW (0,0).");
			xCoordinate = 0;
			yCoordinate = 0;
			position = place;
			crown = king;
		} 
	}
	
	public boolean validMove(int xCoorNewPosition, int yCoorNewPosition) //no math.abs
	{
		if (xCoorNewPosition >= Piece.X_LEFT && xCoorNewPosition <= Piece.X_RIGHT && yCoorNewPosition >= Piece.Y_BOTTOM && yCoorNewPosition <= Piece.Y_TOP && ((xCoordinate - xCoorNewPosition == 1) || (xCoordinate - xCoorNewPosition == -1)))
		{
			if (!this.crown)
			{
				if ((yCoordinate - yCoorNewPosition == 1) && (!this.position)) // top
				{
					return true;
				} else if ((yCoordinate - yCoorNewPosition == -1)  && (this.position)) // bottom
				{
					return true;
				}
			} else
			{
				if ((yCoordinate - yCoorNewPosition == 1) || (yCoordinate - yCoorNewPosition == -1))
				{
					return true;
				}
			}
		}
		return false;
	}

}
