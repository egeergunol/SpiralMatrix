import org.asml.Direction;
import org.asml.StartPoint;
import org.asml.TwoDArraySpiralTraverser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoDArraySpiralTraverserTest {

    private final TwoDArraySpiralTraverser traverser = new TwoDArraySpiralTraverser();

    private final int[][] twoDArray = { {1, 2, 3, 4},
                                        {5, 6, 7, 8},
                                        {9, 10, 11, 12},
                                        {13, 14, 15, 16} };

    /**
     * Tests traversing starting from the top left element moving to right as the direction
     */
    @Test
    public void should_traverse_StartingFromTopLeft_WithInitialDirectionAsRight() {
        assertEquals("[1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]",
                traverser.spiralTraverseTwoDArray(twoDArray, StartPoint.TOP_LEFT_CORNER, Direction.RIGHT).toString());
    }

    /**
     * Tests traversing starting from the top left element moving to down as the direction
     */
    @Test
    public void should_traverse_StartingFromTopLeft_WithInitialDirectionAsDown() {
        assertEquals("[1, 5, 9, 13, 14, 15, 16, 12, 8, 4, 3, 2, 6, 10, 11, 7]",
                traverser.spiralTraverseTwoDArray(twoDArray, StartPoint.TOP_LEFT_CORNER, Direction.DOWN).toString());
    }

    /**
     * Tests traversing starting from the top right element moving to left as the direction
     */
    @Test
    public void should_traverse_StartingFromTopRight_WithInitialDirectionAsLeft() {
        assertEquals("[4, 3, 2, 1, 5, 9, 13, 14, 15, 16, 12, 8, 7, 6, 10, 11]",
                traverser.spiralTraverseTwoDArray(twoDArray, StartPoint.TOP_RIGHT_CORNER, Direction.LEFT).toString());
    }

    /**
     * Tests traversing starting from the top right element moving to down as the direction
     */
    @Test
    public void should_traverse_StartingFromTopRight_WithInitialDirectionAsDown() {
        assertEquals("[4, 8, 12, 16, 15, 14, 13, 9, 5, 1, 2, 3, 7, 11, 10, 6]",
                traverser.spiralTraverseTwoDArray(twoDArray, StartPoint.TOP_RIGHT_CORNER, Direction.DOWN).toString());
    }

    /**
     * Tests traversing starting from the bottom left element moving to right as the direction
     */
    @Test
    public void should_traverse_StartingFromBottomLeft_WithInitialDirectionAsRight() {
        assertEquals("[13, 14, 15, 16, 12, 8, 4, 3, 2, 1, 5, 9, 10, 11, 7, 6]",
                traverser.spiralTraverseTwoDArray(twoDArray, StartPoint.BOTTOM_LEFT_CORNER, Direction.RIGHT).toString());
    }

    /**
     * Tests traversing starting from the bottom left element moving to up as the direction
     */
    @Test
    public void should_traverse_StartingFromBottomLeft_WithInitialDirectionAsUp() {
        assertEquals("[13, 9, 5, 1, 2, 3, 4, 8, 12, 16, 15, 14, 10, 6, 7, 11]",
                traverser.spiralTraverseTwoDArray(twoDArray, StartPoint.BOTTOM_LEFT_CORNER, Direction.UP).toString());
    }

    /**
     * Tests traversing starting from the bottom right element moving to left as the direction
     */
    @Test
    public void should_traverse_StartingFromBottomRight_WithInitialDirectionAsLeft() {
        assertEquals("[16, 15, 14, 13, 9, 5, 1, 2, 3, 4, 8, 12, 11, 10, 6, 7]",
                traverser.spiralTraverseTwoDArray(twoDArray, StartPoint.BOTTOM_RIGHT_CORNER, Direction.LEFT).toString());
    }

    /**
     * Tests traversing starting from the bottom right element moving to up as the direction
     */
    @Test
    public void should_traverse_StartingFromBottomRight_WithInitialDirectionAsUp() {
        assertEquals("[16, 12, 8, 4, 3, 2, 1, 5, 9, 13, 14, 15, 11, 7, 6, 10]",
                traverser.spiralTraverseTwoDArray(twoDArray, StartPoint.BOTTOM_RIGHT_CORNER, Direction.UP).toString());
    }
}
