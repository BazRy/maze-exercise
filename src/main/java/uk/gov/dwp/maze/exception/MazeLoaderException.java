package uk.gov.dwp.maze.exception;

public class MazeLoaderException extends RuntimeException {

    public MazeLoaderException(String message, Exception e) {
        super(message, e);
    }
}
