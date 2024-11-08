package uk.gov.dwp.maze;

public enum NodeType {

    WALL("W"),
    SPACE(" "),
    START("S"),
    END("E");

    final private String value;

    NodeType(String value) {
        this.value = value;
    }

    public String getValue () {
        return value;
    }


}
