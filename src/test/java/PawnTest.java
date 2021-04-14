import com.chess.board.Square;
import org.junit.*;
import org.junit.Assert;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

public class PawnTest {

    private final Point north = new Point(0,1);
    private final Point south = new Point(0, -1);
    private final Point east = new Point(1, 0);
    private final Point west = new Point(-1, 0);
    private final Point northWest = new Point(-1, 1);
    private final Point northEast = new Point(1, 1);
    private final Point southEast = new Point(1, -1);
    private final Point southWest = new Point(-1, -1);
    private final LinkedList<Point> listOfDirections =
            new LinkedList<>(Arrays.asList(north, south, east, west, northEast, northWest, southEast, southWest));

    @Before
    public void setup() {
    }

    @Test
    public void testDirection() {
        Point from = new Point(0, 0);
        Point to = new Point(1, 1);
        Assert.assertFalse(from.equals(to));
        Point direction = new Point((int)Math.signum(to.x - from.x), (int)Math.signum(to.y - from.y));
        Assert.assertTrue(listOfDirections.contains(direction));
    }

    @Test
    public void movePieceTest(Square origin, Square dest) {

    }


}
