package uk.gov.dwp.maze.explore;

public enum Direction {

    NORTH {
        @Override
        public Direction getLeftDirection () {
            return WEST;
        }
        @Override
        public Direction getRightDirection () {
            return EAST;
        }
        @Override
        public Direction getReverseDirection () {
            return SOUTH;
        }

        @Override
        public Coordinate getLeftCoordinate () {
            return new Coordinate(0, -1);
        }
        @Override
        public Coordinate getRightCoordinate () {
            return new Coordinate(0, 1);
        }
        @Override
        public Coordinate getForwardCooordinate() {
            return new Coordinate(-1, 0);
        }
    },

    SOUTH {
        @Override
        public Direction getLeftDirection () {
            return EAST;
        }
        @Override
        public Direction getRightDirection () {
            return WEST;
        }
        @Override
        public Direction getReverseDirection () {
            return NORTH;
        }

        @Override
        public Coordinate getLeftCoordinate () {
            return new Coordinate(0, 1);
        }
        @Override
        public Coordinate getRightCoordinate () {
            return new Coordinate(0, -1);
        }
        @Override
        public Coordinate getForwardCooordinate() {
            return new Coordinate(1, 0);
        }
    },

    EAST {
        @Override
        public Direction getLeftDirection () {
            return NORTH;
        }
        @Override
        public Direction getRightDirection () {
            return SOUTH;
        }
        @Override
        public Direction getReverseDirection () {
            return WEST;
        }

        @Override
        public Coordinate getLeftCoordinate () {
            return new Coordinate(-1, 0);
        }
        @Override
        public Coordinate getRightCoordinate () {
            return new Coordinate(1, 0);
        }
        @Override
        public Coordinate getForwardCooordinate() {
            return new Coordinate(0, 1);
        }
    },

    WEST {
        @Override
        public Direction getLeftDirection () {
            return SOUTH;
        }
        @Override
        public Direction getRightDirection () {
            return NORTH;
        }
        @Override
        public Direction getReverseDirection () {
            return EAST;
        }

        @Override
        public Coordinate getLeftCoordinate () {
            return new Coordinate(1, 0);
        }
        @Override
        public Coordinate getRightCoordinate () {
            return new Coordinate(-1, 0);
        }
        @Override
        public Coordinate getForwardCooordinate() {
            return new Coordinate(0, -1);
        }
    };

    public Direction getLeftDirection () {
        return null;
    }
    public Direction getRightDirection () {
        return null;
    }
    public Direction getReverseDirection() {
        return null;
    }
    public Coordinate getLeftCoordinate () {
        return null;
    }
    public Coordinate getRightCoordinate () {
        return null;
    }
    public Coordinate getForwardCooordinate() {
        return null;
    }
}