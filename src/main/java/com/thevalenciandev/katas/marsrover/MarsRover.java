package com.thevalenciandev.katas.marsrover;

public class MarsRover {
    private final Grid grid;
    private final State state = new State();

    public MarsRover(Grid grid) {
        this.grid = grid;
    }

    public String execute(String command) {
        for (int i = 0; i < command.length(); i++) {
            char move = command.charAt(i);
            state.apply(move);
        }
        return state.get();
    }

    private final class State {

        int currentX = 0;
        int currentY = 0;
        Direction currentDir = new Direction();

        public void apply(char move) {
            if (move == 'M') {
                if (currentDir.get() == 'N') {
                    currentX = (currentX + 1) % grid.lenX();
                }
            } else if (move == 'R') {
                currentDir.rotateRight();
            }
        }

        public String get() {
            return currentX + ":" + currentY + ":" + currentDir;
        }
    }

    private final class Direction {

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

        char get() {
            return currentDir;
        }

        @Override
        public String toString() {
            return String.valueOf(currentDir);
        }
    }
}
