package uk.gov.dwp.maze;

import uk.gov.dwp.maze.exception.MazeLoaderException;
import uk.gov.dwp.maze.explore.Coordinate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Maze {


    private final Node[][] nodes;
    private int startNodes;
    private int exitNodes;;
    private int wallNodes;
    private int spaceNodes;;
    private int startRow;
    private int startColumn;

    public Maze (final List<String> lines) {
        if (null == lines || lines.isEmpty()) {
            throw new MazeLoaderException("Cannot create maze from null or empty list");
        }
        this.nodes = constructMazeNodes(lines);
    }

    private Node[][] constructMazeNodes (final List<String> lines) {
        checkMazeIsBalanced(lines);
        final String[][] mazeCharacters = lines.stream()
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        final Node[][] temp = new Node[mazeCharacters.length][mazeCharacters[0].length];

        for (int row = 0; row < mazeCharacters.length; row++) {
            final String[] rowOfChars = mazeCharacters[row];
            for (int column = 0; column < rowOfChars.length; column++) {
                final Optional<NodeType> opt = NodeType.get(mazeCharacters[row][column]);
                final NodeType nodeType = opt.orElseThrow(() -> new MazeLoaderException("Invalid character within maze"));
                temp[row][column] = new Node(nodeType, new Coordinate(row, column));
                if(nodeType.isStart()) {
                    this.startRow = row;
                    this.startColumn = column;
                    this.startNodes++;
                }
                this.exitNodes += nodeType.isExit() ? 1 : 0;
                this.wallNodes += nodeType.isWall() ? 1 : 0;
                this.spaceNodes += nodeType.isSpace() ? 1 : 0;
            }
        }
        verifyStartAndExits();
        return temp;
    }

    private void checkMazeIsBalanced(final List<String> lines) {
        if (lines.stream().collect(Collectors.groupingBy(String::length)).size() > 1) {
            throw new MazeLoaderException("Maze is unbalanced, it should be square/rectangular");
        }
    }

    private void verifyStartAndExits() {
        if(startNodes != 1 || exitNodes < 1) {
            throw new MazeLoaderException("Maze should have a single start and at least one exit");
        }
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartColumn() {
        return startColumn;
    }


    public Optional<Node> getNodeAtLocation(Coordinate coordinate) {
        int row = coordinate.row();
        int column = coordinate.column();
        if (row >= 0 && row < nodes.length) {
            Node[] nodeRow = nodes[row];
            if (column >= 0 && column < nodeRow.length) {
                return Optional.of(nodes[row][column]);
            }
        }
        return Optional.empty();
    }

    public int getStartNodes() {
        return startNodes;
    }

    public int getExitNodes() {
        return exitNodes;
    }

    public int getWallNodes() {
        return wallNodes;
    }

    public int getSpaceNodes() {
        return spaceNodes;
    }
}
