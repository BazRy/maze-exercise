package uk.gov.dwp.maze;

import uk.gov.dwp.maze.explore.Coordinate;

public class Node {

    private final NodeType nodeType;
    private final Coordinate coordinate;
    private boolean explored;

    public Node(NodeType nodeType, Coordinate coordinate) {
        this.nodeType = nodeType;
        this.coordinate = coordinate;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public boolean isExplored() {
        return explored;
    }

    public void setExplored(boolean explored) {
        this.explored = explored;
    }
}
