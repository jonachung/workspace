import org.junit.Assert;

import org.junit.Test;

/**
 * This is a JUnit Test for the Piece Class.
 * 
 * @author Jonathan
 *
 */
public class PieceTest {

	/**
	 * Tests constructor that automatically sets the king instance variable to false.
	 * Makes sure that all instance variables are equal to their respective parameter values.
	 * For example, the column instance variable should be equal to the col parameter variable.
	 */
	@Test
	public void testConstructor1() {
		Piece myPiece = new Piece(true, 2, 1);
		Assert.assertEquals(2, myPiece.getRow());
		Assert.assertEquals(1, myPiece.getColumn());
		Assert.assertTrue(myPiece.isRed());
		Assert.assertFalse(myPiece.isKing());
	}
	
	/**
	 * Tests second constructor that does not automatically set any instance variables to any values.
	 * Makes sure that all instance variables are equal to their respective parameter values.
	 * For example, the column instance variable should be equal to the col parameter value.
	 */
	@Test
	public void testConstructor2()
	{
		Piece myPiece = new Piece(true, true, 3, 6);
		Assert.assertEquals(3, myPiece.getRow());
		Assert.assertEquals(6, myPiece.getColumn());
		Assert.assertTrue(myPiece.isRed());
		Assert.assertTrue(myPiece.isKing());
	}
	
	/**
	 * Tests becomesKing method to make sure that piece object that was orginally not a king
	 * becomes a king.
	 * Piece object will initially have no king and becomesKing should make the Piece object become a king.
	 */
	@Test
	public void testBecomesKing()
	{
		Piece myPiece = new Piece(true, 3, 6);
		Assert.assertFalse(myPiece.isKing());
		myPiece.becomesKing();
		Assert.assertTrue(myPiece.isKing());
	}
	
	/**
	 * Tests getRow method to make sure that the correct value of the row for the piece object is received.
	 */
	@Test
	public void testGetRow()
	{
		Piece myPiece = new Piece(true, 3, 6);
		Assert.assertEquals(3, myPiece.getRow());
	}
	
	/**
	 * Tests getColumn method to make sure that the correct value of the column for the piece object is received.
	 */
	@Test
	public void testGetColumn()
	{
		Piece myPiece = new Piece(true, 3, 6);
		Assert.assertEquals(6, myPiece.getColumn());
	}
	
	/**
	 * Tests movePiece method to make sure that Piece moves to the correct location. 
	 * Finds column and row of orignial piece and then implements movePiece method.
	 * The new row and column locations of the piece should be the user-specified row and
	 * column locations from the movePiece method.
	 */
	@Test
	public void testMovePiece()
	{
		Piece myPiece = new Piece(true, 3, 6);
		Assert.assertEquals(6, myPiece.getColumn());
		Assert.assertEquals(3, myPiece.getRow());
		myPiece.movePiece(2, 5); // use legitamite checkers move (Done)
		Assert.assertEquals(5, myPiece.getColumn());
		Assert.assertEquals(2, myPiece.getRow());
	}
	
	/**
	 * Tests isKing method to make sure that the correct instance of whether the piece is a king or not is received.
	 * Tests one piece object that should have no king and then tests another piece object that should have a king.
	 */
	@Test
	public void testIsKing()
	{
		Piece myPiece = new Piece(true, 3, 6);
		Assert.assertFalse(myPiece.isKing());
		Piece yourPiece = new Piece(true, true, 3, 6);
		Assert.assertTrue(yourPiece.isKing());
	}
	
	/**
	 * Tests isRed method to make sure that the correct instance of whether the piece is red or not is received.
	 * Tests one piece object that should not be red and then tests another piece object that should be red.
	 */
	@Test
	public void testIsRed()
	{
		Piece myPiece = new Piece(true, 3, 6);
		Assert.assertTrue(myPiece.isRed());
		Piece yourPiece = new Piece(false, 3, 6);
		Assert.assertFalse(yourPiece.isRed());	
	}
}
