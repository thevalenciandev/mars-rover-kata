package com.thevalenciandev.katas.marsrover;

import java.util.HashSet;
import java.util.Set;

public final class Grid {

    public static class Builder {

        private final int lenX;
        private final int lenY;
        private Set<Coordinate> obstacles = new HashSet<>();

        public Builder(int lenX, int lenY) {
            this.lenX = lenX;
            this.lenY = lenY;
        }

        public Builder withObstacle(int x, int y) {
            obstacles.add(new Coordinate(x, y));
            return this;
        }

        public Grid build() {
            return new Grid(lenX, lenY, obstacles);
        }

    }

    private final int lenX;
    private final int lenY;
    private final Set<Coordinate> obstacles;

    private Grid(int lenX, int lenY, Set<Coordinate> obstacles) {
        this.lenX = lenX;
        this.lenY = lenY;
        this.obstacles = obstacles;
    }

    int lenX() {
        return lenX;
    }

    int lenY() {
        return lenY;
    }

    boolean isObstacle(Coordinate targetCoordinate) {
        return obstacles.contains(targetCoordinate);
    }
}