package uk.gov.dwp.maze.util;

import uk.gov.dwp.maze.Maze;
import uk.gov.dwp.maze.exception.MazeLoaderException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class MazeUtil {


    public static Maze createMazeFromFile (String fileName) throws MazeLoaderException {
        try {
            final List<String> lines = Files.readAllLines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()));
            return new Maze(lines);
        } catch (IOException | URISyntaxException e) {
            throw new MazeLoaderException("Failed to load file: " + fileName, e);
        }
    }
}
