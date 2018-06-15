
public class NewPiece { // the simple one
	
	private int xCoordinate;
	
	private int yCoordinate;
	
	public static final int X_LEFT = 0;
	
	public static final int Y_BOTTOM = 0;
	
	public static final int X_RIGHT = 7;
	
	public static final int Y_TOP = 7;
	
	public NewPiece(int x, int y)
	{
		if (((y % 2) == (x % 2)) && (x >= NewPiece.X_LEFT && x <= NewPiece.X_RIGHT) && (y >= NewPiece.Y_BOTTOM && y <= NewPiece.Y_TOP)) 			
		{
			xCoordinate = x;
			yCoordinate = y;
		} else
		{
			System.out.println("OUT OF RANGE. DEFAULT COORDINATES ARE NOW (0,0).");
			xCoordinate = 0;
			yCoordinate = 0;
		}
	}
	
	public boolean validMove(int xCoor, int yCoor)
	{	
		if (xCoor >= NewPiece.X_LEFT && xCoor <= NewPiece.X_RIGHT && yCoor >= NewPiece.Y_BOTTOM && yCoor <= NewPiece.Y_TOP)
		{
			if (((xCoor - xCoordinate == 1) || (xCoor - xCoordinate == -1)) && (yCoor - yCoordinate == 1))
			{
				return true;
			}
		}
		return false;
	}

}
