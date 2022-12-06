package org.asml;

import java.util.ArrayDeque;
import java.util.Queue;

public class TwoDArraySpiralTraverser {

    private int[][] twoDArray;

    private int twoDArrayHeight;

    private int twoDArrayWidth;

    //Represents the indexes that are traversed, so that it can be known whether they are traversed again
    private boolean[][] indexesTraversedIndicatorArray;

    //Holds traversed elements
    private Queue<Integer> traversedElements = new ArrayDeque<>();

    private int currentXIndex;

    private int currentYIndex;

    /**
     * Traverses a given two-dimensional array in a spiral way
     * @param twoDArray the array to be traversed
     * @param startPoint the starting point to start the traverse
     * @param initialDirection the initial direction for beginning the traverse
     * @return the traversed elements as a queue
     */
    public Queue<Integer> spiralTraverseTwoDArray(int[][] twoDArray, StartPoint startPoint, Direction initialDirection) {
        //Initialization for a new traverse
        this.twoDArray = twoDArray;
        twoDArrayHeight = twoDArray.length;
        twoDArrayWidth = twoDArray[0].length;
        indexesTraversedIndicatorArray = new boolean[twoDArrayHeight][twoDArrayWidth];
        for (int i = 0; i < twoDArrayHeight; i++)
            for (int j = 0; j < twoDArrayWidth; j++)
                indexesTraversedIndicatorArray[i][j] = false;
        traversedElements.clear();
        determineStartIndex(startPoint);

        //Traverses until every element is traversed
        while (traversedElements.size() != twoDArrayHeight * twoDArrayWidth) {
            //Use the initial direction to start traversing, afterwards determine the next direction to continue
            if (traversedElements.isEmpty())
                traverse(initialDirection);
            else {
                traverse(getNextDirection());
            }
        }

        System.out.println(traversedElements);
        return traversedElements;
    }

    /**
     * Determines x and y indexes according to the starting point
     * @param startPoint the starting point to start the traverse
     */
    private void determineStartIndex(StartPoint startPoint) {
        switch (startPoint) {
            case TOP_LEFT_CORNER -> {
                currentXIndex = 0;
                currentYIndex = 0;
            }
            case TOP_RIGHT_CORNER -> {
                currentXIndex = twoDArrayWidth - 1;
                currentYIndex = 0;
            }
            case BOTTOM_LEFT_CORNER -> {
                currentXIndex = 0;
                currentYIndex = twoDArrayHeight - 1;
            }
            case BOTTOM_RIGHT_CORNER -> {
                currentXIndex = twoDArrayWidth - 1;
                currentYIndex = twoDArrayHeight - 1;
            }
        }
    }

    /**
     * Traverses according to the direction
     * @param direction the direction to traverse
     */
    private void traverse(Direction direction) {
        switch (direction) {
            case UP -> {
                while (currentYIndex >= 0 && !areIndexesTraversed(currentXIndex, currentYIndex)) {
                    addElementAndMarkCurrentIndexesAsTraversed();
                    currentYIndex--;
                }
                //Increment since the loop is done when current y index is -1
                currentYIndex++;
            }
            case DOWN -> {
                while (currentYIndex != twoDArrayHeight && !areIndexesTraversed(currentXIndex, currentYIndex)) {
                    addElementAndMarkCurrentIndexesAsTraversed();
                    currentYIndex++;
                }
                //Decrement since the loop is done when current y index is height of the array
                currentYIndex--;
            }
            case LEFT -> {
                while (currentXIndex >= 0 && !areIndexesTraversed(currentXIndex, currentYIndex)) {
                    addElementAndMarkCurrentIndexesAsTraversed();
                    currentXIndex--;
                }
                //Increment since the loop is done when current x index is -1
                currentXIndex++;
            }
            case RIGHT -> {
                while (currentXIndex != twoDArrayWidth && !areIndexesTraversed(currentXIndex, currentYIndex)) {
                    addElementAndMarkCurrentIndexesAsTraversed();
                    currentXIndex++;
                }
                //Decrement since the loop is done when current x index is width of the array
                currentXIndex--;
            }
        }
    }

    /**
     * Checks whether given x and y indexes are traversed
     * @param xIndex x index to check
     * @param yIndex y index to check
     * @return whether the indexes are traversed
     */
    private boolean areIndexesTraversed(int xIndex, int yIndex) {
        return indexesTraversedIndicatorArray[yIndex][xIndex];
    }

    /**
     * Adds element located at the current indexes to the queue and marks current indexes as traversed
     */
    private void addElementAndMarkCurrentIndexesAsTraversed() {
        traversedElements.offer(twoDArray[currentYIndex][currentXIndex]);
        indexesTraversedIndicatorArray[currentYIndex][currentXIndex] = true;
    }

    /**
     * Determines the direction to continue traversing
     * @return the next direction
     */
    private Direction getNextDirection() {
        Direction direction = Direction.UP;
        if (currentXIndex + 1 != twoDArrayWidth && !areIndexesTraversed(currentXIndex + 1, currentYIndex)) {
            direction = Direction.RIGHT;
            //Increment x index since the next direction is right
            currentXIndex++;
        } else if (currentXIndex - 1 >= 0 && !areIndexesTraversed(currentXIndex - 1, currentYIndex)) {
            direction = Direction.LEFT;
            //Increment x index since the next direction is left
            currentXIndex--;
        } else if (currentYIndex + 1 != twoDArrayHeight && !areIndexesTraversed(currentXIndex, currentYIndex + 1)) {
            direction = Direction.DOWN;
            //Increment y index since the next direction is down
            currentYIndex++;
        } else if (currentYIndex - 1 >= 0 && !areIndexesTraversed(currentXIndex, currentYIndex - 1)) {
            direction = Direction.UP;
            //Decrement y index since the next direction is up
            currentYIndex--;
        }
        return direction;
    }

}
