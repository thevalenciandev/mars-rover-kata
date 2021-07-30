package com.thevalenciandev.katas.marsrover;

public final class MarsRover {
    private final State state;

    public MarsRover(Grid grid) {
        this.state = new State(grid);
    }

    public String execute(String command) {
        for (int i = 0; i < command.length(); i++) {
            char move = command.charAt(i);
            state.apply(move);
        }
        return state.get();
    }
}
