package uk.gov.dwp.maze.exception;

public class MazeLoaderException extends RuntimeException {

    public MazeLoaderException(String message, Exception e) {
        super(message, e);
    }
    public MazeLoaderException(String message) {
        super(message);
    }

}
