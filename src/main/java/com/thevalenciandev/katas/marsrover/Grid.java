package com.thevalenciandev.katas.marsrover;

import java.util.HashSet;
import java.util.Set;

public final class Grid {

    public static class Builder {

        private final int lenX;
        private final int lenY;
        private Set<Obstacle> obstacles = new HashSet<>();

        public Builder(int lenX, int lenY) {
            this.lenX = lenX;
            this.lenY = lenY;
        }

        public Builder withObstacle(int x, int y) {
            obstacles.add(new Obstacle(x, y));
            return this;
        }

        public Grid build() {
            return new Grid(lenX, lenY, obstacles);
        }

    }

    private static record Obstacle(int x, int y) {
    }

    private final int lenX;
    private final int lenY;
    private final Set<Obstacle> obstacles;

    private Grid(int lenX, int lenY, Set<Obstacle> obstacles) {
        this.lenX = lenX;
        this.lenY = lenY;
        this.obstacles = obstacles;
    }

    public int lenX() {
        return lenX;
    }

    public int lenY() {
        return lenY;
    }

    public boolean isObstacle(int targetX, int targetY) {
        return obstacles.contains(new Obstacle(targetX, targetY));
    }
}