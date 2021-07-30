package com.thevalenciandev.katas.marsrover;

final class State {

    private final Grid grid;

    Coordinate currentCoordinate = new Coordinate(0, 0);
    Direction currentDir = new Direction();
    boolean foundObstacle = false;

    public State(Grid grid) {
        this.grid = grid;
    }

    public void apply(char move) {
        if (move == 'M') {
            move();
        } else if (move == 'R') {
            currentDir.rotateRight();
        } else if (move == 'L') {
            currentDir.rotateLeft();
        }
    }

    private void move() {
        Coordinate nextCoordinate = calculateNextCoordinate();
        if (nextCoordinate == null) {
            return; // unknown, just ignore
        }
        if (grid.isObstacle(nextCoordinate)) {
            foundObstacle = true;
            return;
        }
        // update coordinates, no obstacle found.
        this.currentCoordinate = nextCoordinate;
        foundObstacle = false;
    }

    private Coordinate calculateNextCoordinate() {
        if (currentDir.get() == 'N') {
            int nextY = (this.currentCoordinate.y() + 1) % grid.lenY();
            return new Coordinate(currentCoordinate.x(), nextY);
        } else if (currentDir.get() == 'E') {
            int nextX = (this.currentCoordinate.x() + 1) % grid.lenX();
            return new Coordinate(nextX, currentCoordinate.y());
        } else if (currentDir.get() == 'S') {
            int nextY = currentCoordinate.y() == 0 ? grid.lenY() - 1 : (currentCoordinate.y() - 1) % grid.lenY();
            return new Coordinate(currentCoordinate.x(), nextY);
        } else if (currentDir.get() == 'W') {
            int nextX = currentCoordinate.x() == 0 ? grid.lenX() - 1 : (currentCoordinate.x() - 1) % grid.lenX();
            return new Coordinate(nextX, currentCoordinate.y());
        } else {
            // unknown direction
            return null;
        }
    }

    public String get() {
        return (foundObstacle ? "O:" : "")
                + currentCoordinate.x() + ":" + currentCoordinate.y() + ":" + currentDir;
    }

    private static final class Direction {

        char currentDir = 'N';

        void rotateRight() {
            currentDir = switch (currentDir) {
                case 'N' -> 'E';
                case 'E' -> 'S';
                case 'S' -> 'W';
                case 'W' -> 'N';

                default -> throw new IllegalStateException("Unexpected value: " + currentDir);
            };
        }

        public void rotateLeft() {
            currentDir = switch (currentDir) {
                case 'N' -> 'W';
                case 'W' -> 'S';
                case 'S' -> 'E';
                case 'E' -> 'N';

                default -> throw new IllegalStateException("Unexpected value: " + currentDir);
            };
        }

        char get() {
            return currentDir;
        }

        @Override
        public String toString() {
            return String.valueOf(currentDir);
        }

    }
}
