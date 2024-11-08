package uk.gov.dwp.maze;

import uk.gov.dwp.maze.util.MazeUtil;

import java.util.stream.Stream;

public class MazeMain {

    public static void main(String[] args) {
        Stream<String> lines = MazeUtil.loadMaze("Maze1.txt");
        lines.forEach(MazeMain::print);
    }


    public static void print(String line) {

        for (int i = 0; i < line.length(); i++) {
            char character = line.charAt(i);
            System.out.print(character);
        }
        System.out.println("");
    }

}
