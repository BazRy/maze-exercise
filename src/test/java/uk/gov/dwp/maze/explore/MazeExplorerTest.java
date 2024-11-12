package uk.gov.dwp.maze.explore;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import uk.gov.dwp.maze.Maze;

import static org.junit.jupiter.api.Assertions.*;
import static uk.gov.dwp.maze.util.MazeUtil.createMazeFromFile;

public class MazeExplorerTest {

    private static Maze maze;

    @BeforeAll
    public static void setUo () {
        maze = createMazeFromFile("MazeLarge.txt");
    }

    @Test
    public void explorerShouldExploreMaze() {
        final Coordinate expectedExitCoordinate = new Coordinate(14, 1);
        final Explorer explorer = new Explorer(new Position(new Coordinate(maze.getStartRow(), maze.getStartColumn()), Direction.NORTH));
        final MazeExplorer mazeExplorer = new MazeExplorer();
        mazeExplorer.exploreMaze(explorer, maze);
        assertEquals(expectedExitCoordinate, explorer.getCurrentPosition().coordinate());
        assertEquals(Direction.SOUTH, explorer.getCurrentPosition().direction());
        assertTrue(explorer.getForwardMoves() > 0);
        assertFalse(explorer.getMovementRecord().isEmpty());
        assertEquals(explorer.getCurrentPosition(), explorer.getMovementRecord().get(explorer.getMovementRecord().size() -1));
    }
}
