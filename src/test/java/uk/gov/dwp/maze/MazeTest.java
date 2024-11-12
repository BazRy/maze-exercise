package uk.gov.dwp.maze;

import org.junit.jupiter.api.Test;
import uk.gov.dwp.maze.exception.MazeLoaderException;
import uk.gov.dwp.maze.explore.Coordinate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static uk.gov.dwp.maze.util.MazeUtil.createMazeFromFile;

public class MazeTest {

    @Test
    public void loadMazeAssertStartAndExitNodeLocationsAreCorrect () {
        int expectedExitNodeRow = 14;
        int expectedExitNodeColumn = 1;
        final Maze maze = createMazeFromFile("MazeLarge.txt");
        final Optional<Node> startNode = maze.getNodeAtLocation(new Coordinate(maze.getStartRow(), maze.getStartColumn()));
        assertTrue(startNode.isPresent());
        assertTrue(startNode.get().getNodeType().isStart());

        final Optional<Node> exitNode = maze.getNodeAtLocation(new Coordinate(expectedExitNodeRow, expectedExitNodeColumn));
        assertTrue(exitNode.isPresent());
        assertTrue(exitNode.get().getNodeType().isExit());
    }

    @Test
    public void loadMazeAssertNumberAllNodesAreCorrect () {
        int expecteStartNodes = 1;
        int expectedExitNodes = 2;
        int expecteWallNodes = 70;
        int expecteSpaceNodes = 32;
        final Maze maze = createMazeFromFile("MazeSmall.txt");
        assertEquals(expecteStartNodes, maze.getStartNodes());
        assertEquals(expectedExitNodes, maze.getExitNodes());
        assertEquals(expecteWallNodes, maze.getWallNodes());
        assertEquals(expecteSpaceNodes, maze.getSpaceNodes());
    }

    @Test
    public void loadMazeWithInvalidCharacterExpectException () {
        runInvalidMazeTests("MazeContainsInvalidCharacter.txt","Invalid character within maze");
    }

    @Test
    public void loadMazeWithNoExitExpectException () {
        runInvalidMazeTests("MazeContainsNoExit.txt", "Maze should have a single start and at least one exit");
    }

    @Test
    public void loadMazeWithNoStartExpectException () {
        runInvalidMazeTests("MazeContainsNoStart.txt", "Maze should have a single start and at least one exit");
    }

    @Test
    public void loadMazeWithMultipleStartsExpectException () {
        runInvalidMazeTests("MazeContainsMultipleStarts.txt", "Maze should have a single start and at least one exit");
    }

    @Test
    public void mazeIsUnbalancedExpectException () {
        runInvalidMazeTests("MazeIsUnbalanced.txt","Maze is unbalanced, it should be square/rectangular");
    }

    private void runInvalidMazeTests(final String fileName, final String expectedMessage) {
        Exception exception = assertThrows(MazeLoaderException.class, () -> {
            createMazeFromFile(fileName);
        });
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
