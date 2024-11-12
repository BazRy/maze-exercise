package uk.gov.dwp.maze.explore;

import java.util.ArrayList;
import java.util.List;

public class Explorer {

    private Position currentPosition;
    private int forwardMoves;
    final List<Position> movementRecord = new ArrayList<>();

    public Explorer(final Position startPosition) {
        this.currentPosition = startPosition;
        //record the explorer's start position
        movementRecord.add(this.currentPosition);
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
        //update the movement record
        movementRecord.add(currentPosition);
    }

    public void incrementForwardMoves () {
        forwardMoves++;
    }

    public int getForwardMoves() {
        return forwardMoves;
    }

    public List<Position> getMovementRecord() {
        return movementRecord;
    }
}
