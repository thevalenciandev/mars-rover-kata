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
        char currentDir = 'N';

        public void apply(char move) {
            if (move == 'M') {
                if (currentDir == 'N') {
                    currentX = (currentX + 1) % grid.lenX();
                }
            }
        }

        public String get() {
            return currentX + ":" + currentY + ":" + currentDir;
        }
    }
}
