package uk.gov.dwp.maze;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.dwp.maze.explore.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static uk.gov.dwp.maze.util.MazeUtil.createMazeFromFile;

public class MazeMain {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(MazeMain.class);

    public static void main(String[] args) throws IOException {
        final Maze maze = createMazeFromFile(getMazeFileName());
        final Explorer explorer = new Explorer(new Position(new Coordinate(maze.getStartRow(), maze.getStartColumn()), Direction.NORTH));

        final MazeExplorer mazeExplorer = new MazeExplorer();
        mazeExplorer.exploreMaze(explorer, maze);
        printStepsToExploreMaze(explorer.getMovementRecord());
        LOGGER.info("Number of moves to exit maze {}", explorer.getMovementRecord().size());
        LOGGER.info("Number of forward moves to exit maze {}",explorer.getForwardMoves());
    }
    private static String getMazeFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Please enter the name of the file containing the maze structure.");
        return scanner.nextLine();
    }

    private static void printStepsToExploreMaze(final List<Position> pathToExit)  {
        for (Position position : pathToExit) {
            LOGGER.info("Explorer was at grid position - row: {} , column: {}, heading {}", position.coordinate().row(), position.coordinate().column(), position.direction().name());
        }
    }

}

