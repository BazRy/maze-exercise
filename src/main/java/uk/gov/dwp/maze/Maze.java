package uk.gov.dwp.maze;

import uk.gov.dwp.maze.exception.MazeLoaderException;
import uk.gov.dwp.maze.explore.Coordinate;

import java.util.List;
import java.util.Optional;

public class Maze {


    private final Node[][] nodes;
    private int walls;
    private int spaces;
    private int exits;;
    private int startRow;
    private int startColumn;

    public Maze (final List<String> lines) {
        if (null == lines || lines.isEmpty()) {
            throw new MazeLoaderException("Cannot create maze from null or empty list");
        }
        this.nodes = constructMazeNodes(lines);
    }

    private Node[][] constructMazeNodes (final List<String> lines) {

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
                incrementTotals(nodeType);
                if(nodeType.isStart()) {
                    this.startRow = row;
                    this.startColumn = column;
                }
            }
        }
        return temp;
    }

    private void incrementTotals(final NodeType node) {

        if(node.isWall()) {
            walls++;
            return;
        }
        if(node.isSpace()) {
            spaces++;
            return;
        }
        if(node.isExit()) {
            exits++;
        }
    }

    public int getWallTotal() {
        return walls;
    }

    public int getSpacesTotal() {
        return spaces;
    }

    public int getExitsTotal() {
        return exits;
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
}
