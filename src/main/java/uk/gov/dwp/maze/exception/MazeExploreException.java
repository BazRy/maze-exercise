package uk.gov.dwp.maze.exception;

public class MazeExploreException extends RuntimeException {

    public MazeExploreException(String message, Exception e) {
        super(message, e);
    }
    public MazeExploreException(String message) {
        super(message);
    }

}
