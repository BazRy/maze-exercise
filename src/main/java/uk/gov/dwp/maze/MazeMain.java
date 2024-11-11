package uk.gov.dwp.maze;

import uk.gov.dwp.maze.explore.*;

import java.io.IOException;
import java.util.List;

import static uk.gov.dwp.maze.util.MazeUtil.createMazeFromFile;

public class MazeMain {

    public static void main(String[] args) throws IOException {
        final Maze maze = createMazeFromFile("Maze1.txt");
        System.out.println("Walls " + maze.getWallTotal());
        System.out.println("Spaces " + maze.getSpacesTotal());
        System.out.println("Exits " + maze.getExitsTotal());
        System.out.println("Start location is " + maze.getStartRow() + ", " + maze.getStartColumn());

        Explorer explorer = new Explorer(new Position(new Coordinate(maze.getStartRow(), maze.getStartColumn()), Direction.NORTH));
        System.out.println("Explorer position is " + explorer.toString());

        MazeExplorer mazeExplorer = new MazeExplorer();
        final List<Position> pathToExit = mazeExplorer.exploreMaze(explorer, maze);
        printStepsToExploreMaze(pathToExit);
        System.out.println("Number of steps to exit maze " + pathToExit.size());
        System.out.println("Number of forward moves to exit maze " + explorer.getForwardMoves());
    }

    private static void printStepsToExploreMaze(final List<Position> pathToExit)  {
        for (Position position : pathToExit) {
            System.out.println("Position was at grid position - row: " + position.coordinate().row() + ", column: " + position.coordinate().column() + " heading " + position.direction().name() + " direction.");
        }
    }

}

