package uk.gov.dwp.maze.util;

import uk.gov.dwp.maze.exception.MazeLoaderException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MazeUtil {

    public Stream<String> loadMaze(String filename) throws MazeLoaderException {
        try {
            return Files.lines(Paths.get(ClassLoader.getSystemResource(filename).toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new MazeLoaderException("Failed to load file: " + filename, e);
        }
    }
}
