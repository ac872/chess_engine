import com.chess.board.Board;
import com.chess.board.Square;
import com.chess.pieces.Knight;
import com.chess.pieces.Pawn;
import com.chess.pieces.Piece;
import org.junit.Test;
import org.junit.*;
import org.junit.Assert;

import java.awt.*;
import java.util.HashMap;

public class BoardTest {

    private Board board = new Board(8, 8);
    private Board filledBoard = new Board(8, 8);
    private HashMap<Point, Square> initGrid;


    @Before
    public void setup(){
        board.setGrid();
        filledBoard.setGrid();
        filledBoard.initializePieces();
        this.initGrid = filledBoard.getGrid();

    }

    @Test
    public void testBoardSize(){
        Assert.assertEquals(8, board.getX());
        Assert.assertEquals(8, board.getY());
    }

    @Test
    public void testBoardContentsEmpty(){
        HashMap<Point, Square> grid = board.getGrid();
        for (int i = 1; i <= board.getX(); i++) {
            for (int j = 1; j <= board.getY(); j++){
                Square square = grid.get(new Point(j, i));
                Assert.assertEquals("     ", square.getContents());
            }
        }
    }

    @Test
    public void testInitialPlacement(){
        testKing();
        testBishop();
        testRook();
        testQueens();
        testPawns();
        testKnight();
    }

    @Test
    public void testPawns(){
        HashMap<Point, Square> grid = filledBoard.getGrid();
        for (int i = 1; i < filledBoard.getX(); i++) {
            Square whiteSquare = grid.get(new Point(i, 2));
            Piece whitePiece = whiteSquare.getPiece();
            Assert.assertTrue(whitePiece.isAlive());
            Assert.assertEquals(1, whitePiece.getColor());
            Assert.assertEquals("  p  ", whitePiece.getName());

            Square blackSquare = grid.get(new Point(i, 7));
            Piece blackPiece = blackSquare.getPiece();
            Assert.assertTrue(blackPiece.isAlive());
            Assert.assertEquals(0, blackPiece.getColor());
            Assert.assertEquals("  P  ", blackPiece.getName());
        }
    }

    @Test
    public void testQueens(){
        Square whiteSquare = initGrid.get(new Point(4, 1));
        Piece whitePiece = whiteSquare.getPiece();
        Assert.assertTrue(whitePiece.isAlive());
        Assert.assertEquals(1, whitePiece.getColor());
        Assert.assertEquals("  q  ", whitePiece.getName());

        Square blackSquare = initGrid.get(new Point(4, 8));
        Piece blackPiece = blackSquare.getPiece();
        Assert.assertTrue(blackPiece.isAlive());
        Assert.assertEquals(0, blackPiece.getColor());
        Assert.assertEquals("  Q  ", blackPiece.getName());
    }

    @Test
    public void testKing(){
        Square whiteSquare = initGrid.get(new Point(5, 1));
        Piece whitePiece = whiteSquare.getPiece();
        Assert.assertTrue(whitePiece.isAlive());
        Assert.assertEquals(1, whitePiece.getColor());
        Assert.assertEquals("  k  ", whitePiece.getName());

        Square blackSquare = initGrid.get(new Point(5, 8));
        Piece blackPiece = blackSquare.getPiece();
        Assert.assertTrue(blackPiece.isAlive());
        Assert.assertEquals(0, blackPiece.getColor());
        Assert.assertEquals("  K  ", blackPiece.getName());
    }

    @Test
    public void testRook(){
        Square whiteSquare1 = initGrid.get(new Point(1, 1));
        Piece whitePiece1 = whiteSquare1.getPiece();
        Assert.assertTrue(whitePiece1.isAlive());
        Assert.assertEquals(1, whitePiece1.getColor());
        Assert.assertEquals("  r  ", whitePiece1.getName());

        Square whiteSquare2 = initGrid.get(new Point(8, 1));
        Piece whitePiece2 = whiteSquare2.getPiece();
        Assert.assertTrue(whitePiece2.isAlive());
        Assert.assertEquals(1, whitePiece2.getColor());
        Assert.assertEquals("  r  ", whitePiece2.getName());

        Square blackSquare1 = initGrid.get(new Point(1, 8));
        Piece blackPiece1 = blackSquare1.getPiece();
        Assert.assertTrue(blackPiece1.isAlive());
        Assert.assertEquals(0, blackPiece1.getColor());
        Assert.assertEquals("  R  ", blackPiece1.getName());

        Square blackSquare2 = initGrid.get(new Point(8, 8));
        Piece blackPiece2 = blackSquare2.getPiece();
        Assert.assertTrue(blackPiece2.isAlive());
        Assert.assertEquals(0, blackPiece2.getColor());
        Assert.assertEquals("  R  ", blackPiece2.getName());

    }

    @Test
    public void testBishop(){
        Square whiteSquare1 = initGrid.get(new Point(3, 1));
        Piece whitePiece1 = whiteSquare1.getPiece();
        Assert.assertTrue(whitePiece1.isAlive());
        Assert.assertEquals(1, whitePiece1.getColor());
        Assert.assertEquals("  b  ", whitePiece1.getName());

        Square whiteSquare2 = initGrid.get(new Point(6, 1));
        Piece whitePiece2 = whiteSquare2.getPiece();
        Assert.assertTrue(whitePiece2.isAlive());
        Assert.assertEquals(1, whitePiece2.getColor());
        Assert.assertEquals("  b  ", whitePiece2.getName());

        Square blackSquare1 = initGrid.get(new Point(3, 8));
        Piece blackPiece1 = blackSquare1.getPiece();
        Assert.assertTrue(blackPiece1.isAlive());
        Assert.assertEquals(0, blackPiece1.getColor());
        Assert.assertEquals("  B  ", blackPiece1.getName());

        Square blackSquare2 = initGrid.get(new Point(6, 8));
        Piece blackPiece2 = blackSquare2.getPiece();
        Assert.assertTrue(blackPiece2.isAlive());
        Assert.assertEquals(0, blackPiece2.getColor());
        Assert.assertEquals("  B  ", blackPiece2.getName());
    }

    @Test
    public void testKnight(){
        Square whiteSquare1 = initGrid.get(new Point(2, 1));
        Piece whitePiece1 = whiteSquare1.getPiece();
        Assert.assertTrue(whitePiece1.isAlive());
        Assert.assertEquals(1, whitePiece1.getColor());
        Assert.assertEquals("  n  ", whitePiece1.getName());

        Square whiteSquare2 = initGrid.get(new Point(7, 1));
        Piece whitePiece2 = whiteSquare2.getPiece();
        Assert.assertTrue(whitePiece2.isAlive());
        Assert.assertEquals(1, whitePiece2.getColor());
        Assert.assertEquals("  n  ", whitePiece2.getName());

        Square blackSquare1 = initGrid.get(new Point(2, 8));
        Piece blackPiece1 = blackSquare1.getPiece();
        Assert.assertTrue(blackPiece1.isAlive());
        Assert.assertEquals(0, blackPiece1.getColor());
        Assert.assertEquals("  N  ", blackPiece1.getName());

        Square blackSquare2 = initGrid.get(new Point(7, 8));
        Piece blackPiece2 = blackSquare2.getPiece();
        Assert.assertTrue(blackPiece2.isAlive());
        Assert.assertEquals(0, blackPiece2.getColor());
        Assert.assertEquals("  N  ", blackPiece2.getName());
    }

    @Test
    public void testValid() {
//        Test if same point should be false
        Assert.assertFalse(filledBoard.isValid(new Point(1,1), new Point(1, 1)));
//        Test if same color pieces should be false (in this case pawns)
        Assert.assertFalse(filledBoard.isValid(new Point(1, 2), new Point(2, 2)));
//        Test if moving pawn to empty space should be true
        Assert.assertTrue(filledBoard.isValid(new Point(1, 2), new Point(1, 3)));
//        Test moving pawn forward by 2 spaces
        Assert.assertTrue(filledBoard.isValid(new Point(2, 2), new Point(2, 4)));
//        Test moving pawn forward by 3 spaces
        Assert.assertFalse(filledBoard.isValid(new Point(1, 2), new Point(1, 5)));
//        Test if moving Queen one space in forwards with pawn in should be false
        Assert.assertFalse(filledBoard.isValid(new Point(4,1), new Point(4, 2)));
//        Test moving a Knight
        Assert.assertTrue(filledBoard.isValid(new Point(2, 1), new Point(3, 3)));
//        Test Moving  queen when path is blocked
        Assert.assertFalse(filledBoard.isValid(new Point(4, 1), new Point(4, 3)));

    }

    @Test
    public void test(){
        Assert.assertTrue(filledBoard.isValid(new Point(2, 2), new Point(2, 3)));

    }

    @Test
    public void testValidDiagMovementPawns() {
//        Test diagonal movement of pawn with empty space (false)
        Assert.assertFalse(filledBoard.getGrid().get(new Point(3, 3)).isFilled());
        Assert.assertFalse(filledBoard.getGrid().get(new Point(1, 3)).isFilled());
        Assert.assertFalse(filledBoard.isValid(new Point(2, 2), new Point(3, 3)));
        Assert.assertFalse(filledBoard.isValid(new Point(2, 2), new Point(1, 3)));

//        Test diagonal movement of pawn with piece in place (true)
        Board tempBoard = filledBoard;
        Point orig = new Point(2, 2);
        Square origSquare = tempBoard.getGrid().get(orig);
        Piece originalPiece = origSquare.getPiece();
        Point dest = new Point(3, 3);
        Square destSquare = tempBoard.getGrid().get(dest);
        Knight testKnightPiece = new Knight(0, "  N  ");
        destSquare.setPiece(testKnightPiece);

        Assert.assertTrue(tempBoard.isValid(orig, dest));
        tempBoard.movePiece(orig, dest);
        Piece testPiece = destSquare.getPiece();
        Assert.assertEquals(originalPiece, testPiece);
        Assert.assertFalse(origSquare.isFilled());
        Assert.assertTrue(destSquare.isFilled());
        Assert.assertEquals("  p  ", destSquare.getPiece().getName());
        Assert.assertNull(origSquare.getPiece());

    }

    @Test
    public void testIsPathClear() {
//        Test moving pawn one space forward
        Assert.assertTrue(filledBoard.isPathClear(new Point(1, 2), new Point(1, 3)));
//        Test moving pawn up to next line of pawns
        Assert.assertTrue(filledBoard.isPathClear(new Point(1, 2), new Point(1, 7)));
//        Test False moving pawn to edge of board with pawn in the way
        Assert.assertFalse(filledBoard.isPathClear(new Point(1, 2), new Point(1, 8)));
//        Test diagonal
        Assert.assertTrue(filledBoard.isPathClear(new Point(2, 2), new Point(7, 7)));
    }

    @Test
    public void testMovePawn() {
        //        Moving pawn one space forwards
        Board tempBoard = filledBoard;
        Point orig = new Point(2, 2);
        Point dest = new Point(2, 3);
        Square origSquare = tempBoard.getGrid().get(orig);
        Square destSquare = tempBoard.getGrid().get(dest);
        Piece originalPiece = origSquare.getPiece();
        tempBoard.movePiece(orig, dest);
        Piece testPiece = destSquare.getPiece();

        Assert.assertEquals(originalPiece, testPiece);
        Assert.assertFalse(origSquare.isFilled());
        Assert.assertTrue(destSquare.isFilled());
        Assert.assertEquals("  p  ", destSquare.getPiece().getName());
        Assert.assertNull(origSquare.getPiece());
    }

    @Test
    public void testMovePawnTwoSpaces(){
        //        Moving pawn two spaces forwards on first turn
        Board tempBoard = filledBoard;
        Point orig = new Point(2, 2);
        Point dest = new Point(2, 4);
        Square origSquare = tempBoard.getGrid().get(orig);
        Square destSquare = tempBoard.getGrid().get(dest);
        Piece originalPiece = origSquare.getPiece();
        Assert.assertTrue(tempBoard.isValid(orig, dest));
        tempBoard.movePiece(orig, dest);
        Piece testPiece = destSquare.getPiece();

        Assert.assertEquals(originalPiece, testPiece);
        Assert.assertFalse(origSquare.isFilled());
        Assert.assertTrue(destSquare.isFilled());
        Assert.assertEquals("  p  ", destSquare.getPiece().getName());
        Assert.assertNull(origSquare.getPiece());
//        Attempt to move two spaces again
        Point newDest = new Point(2, 6);
        Assert.assertFalse(tempBoard.isValid(dest, newDest));
    }

    @Test
    public void testMovePawnOneSpaceThenTwo(){
        //        Moving pawn two spaces forwards on first turn
        Board tempBoard = filledBoard;
        Point orig = new Point(2, 2);
        Point dest = new Point(2, 3);
        Square origSquare = tempBoard.getGrid().get(orig);
        Square destSquare = tempBoard.getGrid().get(dest);
        Piece originalPiece = origSquare.getPiece();
        Assert.assertTrue(tempBoard.isValid(orig, dest));
        tempBoard.movePiece(orig, dest);
        Piece testPiece = destSquare.getPiece();

        Assert.assertEquals(originalPiece, testPiece);
        Assert.assertFalse(origSquare.isFilled());
        Assert.assertTrue(destSquare.isFilled());
        Assert.assertEquals("  p  ", destSquare.getPiece().getName());
        Assert.assertNull(origSquare.getPiece());
//        Attempt to move two spaces again
        Point newDest = new Point(2, 5);
        Assert.assertFalse(tempBoard.isValid(dest, newDest));
    }
}
