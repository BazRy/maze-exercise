package uk.gov.dwp.maze.explore;

import uk.gov.dwp.maze.Maze;
import uk.gov.dwp.maze.Node;

import java.util.ArrayList;
import java.util.List;

public class MazeExplorer {


    public List<Position> exploreMaze(final Explorer explorer, final Maze maze) {
        final List<Position> pathToExit = new ArrayList<>();
        //add start position to the list
        pathToExit.add(explorer.getPosition());
        boolean reachedExit = false;

        do {
            reachedExit = explore2(explorer, maze, pathToExit);
        } while (!reachedExit);

        return pathToExit;
    }

    private boolean explore2(final Explorer explorer, final Maze maze, final List<Position> pathToExit) {
        final Coordinate currentCoordinate = explorer.getPosition().coordinate();
        final Direction currentDirection = explorer.getPosition().direction();
        final Node currentNode = maze.getNodeAtLocation(currentCoordinate).orElseThrow();

        if (currentNode.getNodeType().isExit()) {
            //if we are at the exit then we're done.
            return true;
        }

        final int currentRow = currentCoordinate.row();
        final int currentColumn = currentCoordinate.column();

        //get node ahead of me
        final Coordinate forwardCoordinates = currentDirection.getForwardCooordinate();
        final Node nodeInFrontOfMe = maze.getNodeAtLocation(new Coordinate(currentRow + forwardCoordinates.row(), currentColumn + forwardCoordinates.column())).orElseThrow();

        //get node to my left
        final Coordinate leftCoordinates = currentDirection.getLeftCoordinate();
        final Direction leftDirection = currentDirection.getLeftDirection();
        final Node nodeToLeftOfMe = maze.getNodeAtLocation(new Coordinate(currentRow + leftCoordinates.row(), currentColumn + leftCoordinates.column())).orElseThrow();

        //get node to my right
        final Coordinate rightCoordinates = currentDirection.getRightCoordinate();
        final Direction rightDirection = currentDirection.getRightDirection();
        final Node nodeToRightOfMe = maze.getNodeAtLocation(new Coordinate(currentRow + rightCoordinates.row(), currentColumn + rightCoordinates.column())).orElseThrow();

        if (!nodeToLeftOfMe.getNodeType().isWall() && !nodeToLeftOfMe.isExplored()) {
            //try go left first
            progressMazePosition(explorer, nodeToLeftOfMe, leftDirection, pathToExit);
            return false;
        } else if (!nodeToRightOfMe.getNodeType().isWall() && !nodeToRightOfMe.isExplored()) {
            //else try go right
            progressMazePosition(explorer, nodeToRightOfMe, rightDirection, pathToExit);
            return false;
        } else if (!nodeInFrontOfMe.getNodeType().isWall() ) {
            //otherwise just go forward even if visited node
            progressMazePosition(explorer, nodeInFrontOfMe, currentDirection, pathToExit);
            explorer.incrementForwardMoves();
            return false;
        }

        //if we are here then we are stuck, so find the nearest direction we can head back in
        if (!nodeToLeftOfMe.getNodeType().isWall()) {
            setExplorerNewPosition(explorer, currentNode, leftDirection);
        } else if (!nodeToRightOfMe.getNodeType().isWall()) {
            setExplorerNewPosition(explorer, currentNode, rightDirection);
        } else {
            setExplorerNewPosition(explorer, currentNode, currentDirection.getReverseDirection());
        }

        pathToExit.add(explorer.getPosition());
        return false;
    }

    private void setExplorerNewPosition(final Explorer explorer, final Node node, final Direction direction) {
        explorer.setPosition(new Position(node.getCoordinate(), direction));
    }

    private void progressMazePosition(final Explorer explorer, final Node node, final Direction direction, final List<Position> pathToExit) {
        setExplorerNewPosition(explorer, node, direction);
        pathToExit.add(explorer.getPosition());
        node.setExplored(true);
    }


}
