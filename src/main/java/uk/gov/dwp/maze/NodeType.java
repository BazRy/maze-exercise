package uk.gov.dwp.maze;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public enum NodeType {

    WALL("X") {
        @Override
        public boolean isWall() {
            return true;
        }
    },
    SPACE(" "){
        @Override
        public boolean isSpace() {
            return true;
        }
    },
    START("S"){
        @Override
        public boolean isStart() {
            return true;
        }
    },
    EXIT("E"){
        @Override
        public boolean isExit() {
            return true;
        }
    };

    final private String value;
    private static final Map<String, NodeType> VALUE_ENUM_MAP;

    NodeType(String value) {
        this.value = value;
    }


    static {
        final Map<String, NodeType> map = new ConcurrentHashMap<>();
        for (NodeType nodeType : NodeType.values()) {
            map.put(nodeType.value.toLowerCase(), nodeType);
        }
        VALUE_ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static Optional<NodeType> get(String val) {
        return Optional.ofNullable(VALUE_ENUM_MAP.get(val.toLowerCase()));
    }

    public boolean isWall() {
        return false;
    }
    public boolean isSpace() {
        return false;
    }
    public boolean isStart() {
        return false;
    }
    public boolean isExit() {
        return false;
    }

}
