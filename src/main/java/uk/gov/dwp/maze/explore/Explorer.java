package uk.gov.dwp.maze.explore;

public class Explorer {

    private Position position;
    private int forwardMoves;

    public Explorer(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void incrementForwardMoves () {
        forwardMoves++;
    }

    public int getForwardMoves() {
        return forwardMoves;
    }

    @Override
    public String toString() {
        return "Explorer{" +
                "position=" + position +
                '}';
    }
}
