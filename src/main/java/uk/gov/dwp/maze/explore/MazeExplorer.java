package uk.gov.dwp.maze.explore;

import uk.gov.dwp.maze.Maze;
import uk.gov.dwp.maze.Node;
import uk.gov.dwp.maze.exception.MazeExploreException;

public class MazeExplorer {


    public void exploreMaze(final Explorer explorer, final Maze maze) {
        boolean reachedExit;
        do {
            reachedExit = explore(explorer, maze);
        } while (!reachedExit);
    }

    private boolean explore(final Explorer explorer, final Maze maze) {
        final Coordinate currentCoordinate = explorer.getCurrentPosition().coordinate();
        final Direction currentDirection = explorer.getCurrentPosition().direction();
        final Node currentNode = maze.getNodeAtLocation(currentCoordinate).orElseThrow(() -> new MazeExploreException("Invalid maze node"));

        if (currentNode.getNodeType().isExit()) {
            //if we are at the exit then we're done.
            return true;
        }

        final int currentRow = currentCoordinate.row();
        final int currentColumn = currentCoordinate.column();

        //get node ahead of me
        final Coordinate forwardCoordinates = currentDirection.getForwardCooordinate();
        final Node nodeInFrontOfMe = maze.getNodeAtLocation(new Coordinate(currentRow + forwardCoordinates.row(), currentColumn + forwardCoordinates.column())).orElseThrow(() -> new MazeExploreException("Invalid maze node"));

        //get node to my left
        final Coordinate leftCoordinates = currentDirection.getLeftCoordinate();
        final Direction leftDirection = currentDirection.getLeftDirection();
        final Node nodeToLeftOfMe = maze.getNodeAtLocation(new Coordinate(currentRow + leftCoordinates.row(), currentColumn + leftCoordinates.column())).orElseThrow(() -> new MazeExploreException("Invalid maze node"));

        //get node to my right
        final Coordinate rightCoordinates = currentDirection.getRightCoordinate();
        final Direction rightDirection = currentDirection.getRightDirection();
        final Node nodeToRightOfMe = maze.getNodeAtLocation(new Coordinate(currentRow + rightCoordinates.row(), currentColumn + rightCoordinates.column())).orElseThrow(() -> new MazeExploreException("Invalid maze node"));

        if (!nodeToLeftOfMe.getNodeType().isWall() && !nodeToLeftOfMe.isExplored()) {
            //try go left first
            progressMazePosition(explorer, nodeToLeftOfMe, leftDirection);
            return false;
        } else if (!nodeToRightOfMe.getNodeType().isWall() && !nodeToRightOfMe.isExplored()) {
            //else try go right
            progressMazePosition(explorer, nodeToRightOfMe, rightDirection);
            return false;
        } else if (!nodeInFrontOfMe.getNodeType().isWall() ) {
            //otherwise just go forward even if explored node
            progressMazePosition(explorer, nodeInFrontOfMe, currentDirection);
            explorer.incrementForwardMoves();
            return false;
        }

        //if we are here then we are stuck, so find the nearest direction we can head back in
        //just turn in that direction, explorer will move on next iteration
        if (!nodeToLeftOfMe.getNodeType().isWall()) {
            setExplorerNewPosition(explorer, currentNode, leftDirection);
        } else if (!nodeToRightOfMe.getNodeType().isWall()) {
            setExplorerNewPosition(explorer, currentNode, rightDirection);
        } else {//can't go left or right so will need to head back
            setExplorerNewPosition(explorer, currentNode, currentDirection.getReverseDirection());
        }
        return false;
    }

    private void setExplorerNewPosition(final Explorer explorer, final Node node, final Direction direction) {
        explorer.setCurrentPosition(new Position(node.getCoordinate(), direction));
    }

    private void progressMazePosition(final Explorer explorer, final Node node, final Direction direction) {
        setExplorerNewPosition(explorer, node, direction);
        node.setExplored(true);
    }


}
