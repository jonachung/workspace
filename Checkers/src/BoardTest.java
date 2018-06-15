import org.junit.Assert;

import org.junit.Test;


/**
 * This is a JUnit Test for the Board Class.
 * 
 * @author Jonathan
 *
 */
public class BoardTest {

	/**
	 * Tests the default board constructor by creating an empty board
	 * and iterating through every position in the checkerBoard and making
	 * sure that every piece is null.
	 */
	@Test
	public void testConstructor1() {
		Board b = new Board(true);
		for(int row = 0; row < 8; row += 1)
			for(int column = 0; column < 8; column += 1)
				Assert.assertNull(b.pieceAt(row, column));
	}

	/**
	 * Tests the new board constructor by creating a board with its
	 * starting positions for checkers and making sure that every piece
	 * in the board is not null.
	 */
	@Test
	public void testConstructor2() {
		Board b = new Board(false);
		final int NUM_ROWS = 3;
		for (int row = 0; row < NUM_ROWS; row++)
		{
			for (int col = (row + 1) % 2; col < 8; col += 2)
			{
				Assert.assertEquals(b.pieceAt(row, col).isRed(), false);
			}
		}
		for (int row = 7; row >= 8 - NUM_ROWS; row--)
		{
			for (int col = (row + 1) % 2; col < 8; col += 2)
			{
				Assert.assertEquals(b.pieceAt(row, col).isRed(), true);
			}
		}
	}
	
	/**
	 * Tests the pieceAt method by creating a board with its starting positions for
	 * checkers and getting one piece object and one empty space object. There should
	 * be one piece object and one empty space object.
	 */
	@Test
	public void testPieceAtForPiecesCorrectType() {
		Board sut = new Board();
		
		Piece piece = sut.pieceAt(0, 1);
		Piece empty = sut.pieceAt(1, 1);
		
		Assert.assertNotNull(piece);
		Assert.assertNull(empty);
		
		
	}
	
	/**
	 * Tests pieceAt() method for pieces that are out of bounds by
	 * creating an empty board with a piece that is out of bounds
	 * and checks if the piece is null or not.
	 * The pieces that are out of bounds should be null objects only.
	 */
	@Test
	public void testPieceAtForOutOfBounds(){
		Board b = new Board(false);
		
		Piece piece = b.pieceAt(-1, -1);
		
		Assert.assertNull(piece);
	}
	
	/**
	 * Tests placePiece() method by placing a piece within the boundaries for
	 * an empty board. A piece will first be placed within the boundaries for
	 * the empty board until the placePiece() method is called in which case the piece's
	 * final coordinates will be updated.
	 * The test will check if the piece that was placed was not null.
	 */
	@Test
	public void testPlacePiece()
	{
		Board b = new Board(true);
		Piece piece = new Piece(false,0,1);
		b.placePiece(piece, 1, 2);
		Assert.assertNotNull(piece);
	}
	
	/**
	 * Tests removePiece() by creating a board setup with the default configuration for checkers.
	 * A piece will be removed through the removePiece() method. After, the pieceAt method is
	 * used to see whether the location of the removed piece returns null.
	 */
	@Test
	public void testRemovePieceForCorrectPieces()
	{
		Board b = new Board();
		b.removePiece(0, 1);
		Assert.assertNull(b.pieceAt(0, 1));
	}
	
	/**
	 * Tests validMove() method for black piece that is supposed to make a regular
	 * move down the checker board by creating a checker board with default configuration for 
	 * checkers and making sure that the validmove method for a specific piece returns true.
	 */
	@Test
	public void testValidMoveBlackRegularMove()
	{
		Board b = new Board();
		Piece p = b.pieceAt(2, 1);
		Assert.assertEquals(b.validMove(3, 2, p), true);
	}
	
	/**
	 *  validMove() method for black piece that is supposed to make a capture
	 *  down the checker board by creating a empty checkerboard and adding two pieces,
	 *  one black and one red piece, and making sure that the validmove method for
	 *  the black piece returns true.
	 */
	@Test
	public void testValidMoveBlackCapture()
	{
		Board b = new Board(true);
		Piece red = new Piece(true, 0, 0);
		Piece black = new Piece(false, 0, 0);
		b.placePiece(black, 1, 2);
		b.placePiece(red, 2, 3);
		Assert.assertEquals(b.validMove(3, 4, black), true);
	}
	
	/**
	 * Tests validMove() method for red piece that is supposed to make a regular
	 * move down the checker board by creating a checker board with default configuration for 
	 * checkers and making sure that the validmove method for a specific piece returns true.
	 */
	@Test
	public void testValidMoveRedRegularMove()
	{
		Board b = new Board();
		Piece p = b.pieceAt(5, 0);
		Assert.assertEquals(b.validMove(4, 1, p), true);
	}
	
	/**
	 * Tests validMove() method for red piece that is supposed to make a capture
	 *  down the checker board by creating a empty checkerboard and adding two pieces,
	 *  one black and one red piece, and making sure that the validmove method for
	 *  the red piece returns true.
	 */
	@Test
	public void testValidMoveRedCapture()
	{
		Board b = new Board(true);
		Piece red = new Piece(true, 0, 0);
		Piece black = new Piece(false, 0, 0);
		b.placePiece(black, 1, 2);
		b.placePiece(red, 2, 3);
		Assert.assertEquals(b.validMove(0, 1, red), true);
	}
	
	/**
	 * Tests validMove() method for black piece that is supposed to make an invalid
	 * move down the checker board by creating a empty checkerboard and adding one black piece
	 * and making sure that the validmove method for
	 *  the black piece returns false for wrong selections.
	 *  
	 *  Those wrong selections for the new locations are being a red square, the new locations 
	 *  being too far away from standards (3 or more spaces), or going backwards when the piece is not a king
	 *  yet.
	 */
	@Test
	public void testValidMoveInvalidMoveBlack()
	{
		Board b = new Board(true);
		Piece black = new Piece(false, 0, 0);
		b.placePiece(black, 1, 2);
		Assert.assertEquals(b.validMove(0,  1,  black), false);
		Assert.assertEquals(b.validMove(4, 5, black), false);
		Assert.assertEquals(b.validMove(2, 2, black), false);
	}
	
	/**
	 * Tests validMove() method for red piece that is supposed to make an invalid
	 * move down the checker board by creating a empty checkerboard and adding one black piece
	 * and making sure that the validmove method for
	 *  the red piece returns false for wrong selections.
	 *  
	 *  Those wrong selections for the new locations are being a red square, the new locations 
	 *  being too far away from standards (3 or more spaces), or going backwards when the piece is not a king
	 *  yet.
	 */
	@Test
	public void testValidMoveInvalidMoveRed()
	{
		Board b = new Board(true);
		Piece red = new Piece(true, 0, 0);
		b.placePiece(red, 6, 3);
		Assert.assertEquals(b.validMove(7,  4,  red), false);
		Assert.assertEquals(b.validMove(5, 3, red), false);
		Assert.assertEquals(b.validMove(3, 0, red), false);
	}
	
	/**
	 * Tests validMove() method for red king piece that is supposed to make a regular
	 * move down the checker board by creating a checker board with default configuration for 
	 * checkers and making sure that the validmove method for a specific piece returns true.
	 * 
	 * The test also tests that the king piece can move both up or down across the board.
	 */
	@Test
	public void testValidMoveRedKing()
	{
		Board b = new Board(true);
		Piece red = new Piece(true, true, 0, 0);
		b.placePiece(red, 6, 3);
		Assert.assertEquals(b.validMove(5, 2, red), true);
		Assert.assertEquals(b.validMove(7, 4, red), true);
	}
	
	/**
	 * Tests validMove() method for black king piece that is supposed to make a regular
	 * move down the checker board by creating a checker board with default configuration for 
	 * checkers and making sure that the validmove method for a specific piece returns true.
	 * 
	 * The test also tests that the king piece can move both up or down across the board.
	 */
	@Test
	public void testValidMoveBlackKing()
	{
		Board b = new Board(true);
		Piece black = new Piece(true, true, 0, 0);
		b.placePiece(black, 1, 2);
		Assert.assertEquals(b.validMove(0, 1, black), true);
		Assert.assertEquals(b.validMove(2, 3, black), true);
	}
	
	/**
	 * Tests canSelect() method for the first move of a regular black piece.
	 * It does this by creating an empty checker board with one black piece
	 * checking if a (row, column) location for the piece can be
	 * selected or not.
	 */
	@Test
	public void testCanSelectFirstMoveBlack() {
		Board b = new Board(true);
		Piece black = new Piece(false, 0, 0);
		b.placePiece(black, 1, 2);
		b.canSelect(2, 3);
	}
	
	/**
	 * Tests canSelect() method for the first move of a regular red piece.
	 * It does this by creating an empty checker board with one red piece
	 * checking if a (row, column) location for the piece can be
	 * selected or not.
	 */
	@Test
	public void testCanSelectFirstMoveRed() {
		Board b = new Board(true);
		Piece red = new Piece(true, 0, 0);
		b.placePiece(red, 1, 2);
		b.canSelect(1, 2);
	}
	
	/**
	 * Tests canSelect() method for the second move of a regular black piece.
	 * It does this by creating a checker board with default configurations
	 * for checkers and checking if a (row, column) location can be
	 * selected or not after a piece was selected.
	 */
	@Test
	public void testCanSelectSecondMoveBlack() {
		Board b = new Board();
		b.select(2, 1);
		Assert.assertEquals(b.canSelect(3, 2), true);
	}
	
	/**
	 * Tests canSelect() method for the second move of a regular black piece.
	 * It does this by creating a checker board with default configurations
	 * for checkers and checking if a (row, column) location can be
	 * selected or not after a piece was selected.
	 */
	@Test
	public void testCanSelectSecondMoveRed() {
		Board b = new Board();
		b.select(5, 2);
		Assert.assertEquals(b.canSelect(4, 1), true);
	}
	
	/**
	 * Tests canSelect() method for the first move of a regular black piece
	 * except the selection should be invalid. It is done by creating
	 * a checker board with the default configurations of checkers and checking
	 * if a selection is invalid.
	 * 
	 * An invalid selection is if a red square is selected.
	 */
	@Test
	public void testCanSelectFirstMoveInvalidBlack()
	{
		Board b = new Board();
		Assert.assertEquals(b.canSelect(0, 0), false);
	}
	
	/**
	 * Tests canSelect() method for the second move of a regular black piece
	 * except the selection should be invalid. It is done by creating an empty checker
	 * board with 2 black pieces and checking if various selections are invalid.
	 * 
	 * An invalid selection is if a red square is selected or if the selection
	 * is not a valid move
	 */
	@Test
	public void testCanSelectSecondMoveInvalidBlackRegularMove()
	{
		Board b = new Board(true);
		Piece blackOne = new Piece(false, 0, 0);
		Piece blackTwo = new Piece(false, 0, 0);
		b.placePiece(blackOne, 1, 2);
		b.placePiece(blackTwo, 2, 3);
		b.select(1, 2);
		Assert.assertEquals(b.canSelect(2, 2), false);
		Assert.assertEquals(b.canSelect(0,  1), false);
		Assert.assertEquals(b.canSelect(4, 5), false);
	}
	
	/**
	 * Tests canSelect() method for the second move of a regular
	 * black piece performing a capture. It is done by creating an empty checker
	 * board with one black piece and one red piece. It checks if the selection
	 * successfully shows a capture.
	 */
	@Test
	public void testCanSelectSecondMoveBlackCapture()
	{
		Board b = new Board(true);
		Piece black = new Piece(false, 0, 0);
		Piece red = new Piece(true, 0, 0);
		b.placePiece(black, 1, 2);
		b.placePiece(red, 2, 3);
		b.select(1, 2);
		Assert.assertEquals(b.canSelect(3, 4), true);
	}
	
	/**
	 * Tests canSelect() method for the first move of a regular red piece
	 * except the selection should be invalid. It is done by creating
	 * a checker board with the default configurations of checkers and checking
	 * if a selection is invalid.
	 * 
	 * An invalid selection is if a red square is selected.
	 */
	@Test
	public void testCanSelectFirstMoveInvalidRed()
	{
		Board b = new Board();
		Assert.assertEquals(b.canSelect(0, 0), false);
	}
	
	/**
	 * Tests canSelect() method for the second move of a regular red piece
	 * except the selection should be invalid. It is done by creating an empty checker
	 * board with 2 red pieces and checking if various selections are invalid.
	 * 
	 * An invalid selection is if a red square is selected and the selection
	 * is not a valid move
	 */
	@Test
	public void testCanSelectSecondMoveInvalidRedRegularMove()
	{
		Board b = new Board(true);
		Piece redOne = new Piece(true, 0, 0);
		Piece redTwo = new Piece(true, 0, 0);
		b.placePiece(redOne, 6, 3);
		b.placePiece(redTwo, 4, 1);
		b.select(6, 3);
		Assert.assertEquals(b.canSelect(7, 4), false);
		Assert.assertEquals(b.canSelect(5, 3), false);
		Assert.assertEquals(b.canSelect(3, 0), false);
	}
	
	/**
	 * Tests canSelect() method for the seconf move of a regular
	 * red piece performing a capture. It is done by creating an empty checker
	 * board with one black piece and one red piece. It checks if the selection
	 * successfully shows a capture.
	 */
	@Test
	public void testCanSelectSecondMoveRedCapture()
	{
		Board b = new Board(true);
		Piece black = new Piece(false, 0, 0);
		Piece red = new Piece(true, 0, 0);
		b.placePiece(black, 1, 2);
		b.placePiece(red, 2, 3);
		b.select(2, 3);
		Assert.assertEquals(b.canSelect(0, 1), true);
	}
	
	/**
	 * Tests select() method when a black piece is being moved from 
	 * one location to another valid location on the checkerboard.
	 * The test makes sure that after the selections, location (0,1) has
	 * no piece there and location (1,2) has a piece there.
	 */
	@Test
	public void testSelectMoveBlackPiece()
	{
		Board b = new Board(true);
		Piece piece = new Piece(false, 0, 0);
		b.placePiece(piece, 0, 1);
		
		b.select(0, 1);
		b.select(1, 2);
		
		Assert.assertNull(b.pieceAt(0, 1));
		Assert.assertEquals(b.pieceAt(1, 2), piece);
	}
	
	/**
	 * Tests select() method when a red piece is being moved from 
	 * one location to another valid location on the checkerboard.
	 * The test makes sure that after the selections, location (5,2) has
	 * no piece there and location (4,1) has a piece there.
	 */
	@Test
	public void testSelectMoveRedPiece()
	{
		Board b = new Board(true);
		Piece piece = new Piece(true, 0, 0);
		b.placePiece(piece, 5, 2);
		
		b.select(5, 2);
		b.select(4, 1);
		
		Assert.assertNull(b.pieceAt(5, 2));
		Assert.assertEquals(b.pieceAt(4, 1), piece);
	}
	
	/**
	 * Tests select() method when a red piece is being moved from 
	 * one location to another valid location on the checkerboard while
	 * performing a capture.
	 * The test makes sure that after the selections, location (5,2) has
	 * no piece there and location (3,0) has a piece there.
	 */
	@Test
	public void testSelectMoveRedPieceCapture()
	{
		Board b = new Board(true);
		Piece piece = new Piece(true, 0, 0);
		Piece opp = new Piece(false, 0, 0);
		b.placePiece(piece, 5, 2);
		b.placePiece(opp, 4, 1);
		
		b.select(5, 2);
		b.select(3, 0);
		
		Assert.assertNull(b.pieceAt(5, 2));
		Assert.assertNull(b.pieceAt(4, 1));
		Assert.assertEquals(b.pieceAt(3, 0), piece);
	}
	
	/**
	 * Tests select() method when a red piece is being moved from 
	 * one location to another valid location on the checkerboard while
	 * performing a capture.
	 * The test makes sure that after the selections, location (0,1) has
	 * no piece there and location (2,3) has a piece there.
	 */
	@Test
	public void testSelectMoveBlackPieceCapture()
	{
		Board b = new Board(true);
		Piece piece = new Piece(false, 0, 0);
		Piece opp = new Piece(true, 0, 0);
		b.placePiece(piece, 0, 1);
		b.placePiece(opp, 1, 2);
		
		b.select(0, 1);
		b.select(2, 3);
		
		Assert.assertNull(b.pieceAt(0, 1));
		Assert.assertNull(b.pieceAt(1, 2));
		Assert.assertEquals(b.pieceAt(2, 3), piece);
	}
	
	/**
	 * Tests winner() method for red pieces. In order for red to win, there should be no
	 * black pieces on the board.
	 */
	@Test
	public void testRedWinner()
	{
		Board b = new Board(true);
		Piece red = new Piece(true, 0, 1);
		b.placePiece(red, 0, 1);
		Assert.assertEquals("Red wins!", b.winner());
	}
	
	/**
	 * Tests winner() method for black pieces. In order for black to win, there should be no
	 * red pieces on the board.
	 */
	@Test
	public void testBlackWinner()
	{
		Board b = new Board(true);
		Piece black = new Piece(false, 0, 1);
		b.placePiece(black, 0, 1);
		Assert.assertEquals("Black wins!", b.winner());
	}
	
	/**
	 * Tests canEndTurn() method when a red piece has finished making a regular move
	 * by making a red piece move and then checking if
	 * the turn could end or not.
	 */
	@Test
	public void testCanEndTurnRedMove()
	{
		Board b = new Board(true);
		Piece piece = new Piece(true, 0, 0);
		b.placePiece(piece, 5, 2);
		
		b.select(5, 2);
		b.select(4, 1);
		
		Assert.assertEquals(b.canEndTurn(), true);
	}
	
	/**
	 * Tests canEndTurn() method when a red piece has finished making
	 * a capture
	 * by making a red piece move and then checking if
	 * the turn could end or not.
	 */
	@Test
	public void testCanEndTurnRedMoveCapture()
	{
		Board b = new Board(true);
		Piece piece = new Piece(true, 0, 0);
		Piece opp = new Piece(false, 0, 0);
		b.placePiece(piece, 5, 2);
		b.placePiece(opp, 4, 1);
		
		b.select(5, 2);
		b.select(3, 0);
		
		Assert.assertEquals(b.canEndTurn(), true);
	}
	
	/**
	 * Tests canEndTurn() method when a black piece has finished making
	 * a capture
	 * by making a black piece move and then checking if
	 * the turn could end or not.
	 */
	@Test
	public void testCanEndTurnBlackMoveCapture()
	{
		Board b = new Board(true);
		Piece piece = new Piece(false, 0, 0);
		Piece opp = new Piece(true, 0, 0);
		b.placePiece(piece, 0, 1);
		b.placePiece(opp, 1, 2);
		
		b.select(0, 1);
		b.select(2, 3);
		
		Assert.assertEquals(b.canEndTurn(), true);
	}
	
	/**
	 * Tests canEndTurn() method when a black piece has finished making a regular move
	 * by making a black piece move and then checking if
	 * the turn could end or not.
	 */
	@Test
	public void testCanEndTurnBlackMove()
	{
		Board b = new Board(true);
		Piece piece = new Piece(false, 0, 0);
		b.placePiece(piece, 0, 1);
		
		b.select(0, 1);
		b.select(1, 2);
		
		Assert.assertEquals(b.canEndTurn(), true);
	}
	
	/**
	 * Tests checkKing() method for a red piece that should become a king when
	 * the piece moves to the top of the board.
	 * After the method has been used, the red piece should be a king piece.
	 */
	@Test
	public void testCheckKingRed()
	{
		Board b = new Board(true);
		Piece king = new Piece(true, 1, 2);
		b.placePiece(king, 1, 2);
		b.select(1, 2);
		b.select(0, 1);
		b.checkKing();
		Assert.assertEquals(true, king.isKing());
	}
	
	/**
	 * Tests checkKing() method for a black piece that should become a king when
	 * the piece moves to the bottom of the board.
	 * After the method has been used, the black piece should be a king piece.
	 */
	@Test
	public void testCheckKingBlack()
	{
		Board b = new Board(true);
		Piece king = new Piece(false, 6, 1);
		b.placePiece(king, 6, 1);
		b.select(6, 1);
		b.select(7, 2);
		b.checkKing();
		Assert.assertEquals(true, king.isKing()); 
	}
	
	/**
	 * Tests checkKing() method for a red piece that should not become a king since
	 * the piece does not move to the bottom of the board.
	 * After the method has been used, the red piece should not be a king piece.
	 */ 
	@Test
	public void testCheckKingRedInvalidKing()
	{
		Board b = new Board(true);
		Piece king = new Piece(true, 1, 2);
		b.placePiece(king, 1, 2);
		b.select(1, 2);
		b.select(2, 3);
		b.checkKing();
		Assert.assertEquals(false, king.isKing());
	}
	
	/**
	 * Tests checkKing() method for a black piece that should not become a king since
	 * the piece does not move to the bottom of the board.
	 * After the method has been used, the black piece should not be a king piece.
	 */
	@Test
	public void testCheckKingBlackInvalidKing()
	{
		Board b = new Board(true);
		Piece king = new Piece(false, 5, 6);
		b.placePiece(king, 5, 6);
		b.select(5, 6);
		b.select(4, 5);
		b.checkKing();
		Assert.assertEquals(false, king.isKing());
	}
}
