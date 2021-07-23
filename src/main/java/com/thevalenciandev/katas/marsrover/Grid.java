package com.thevalenciandev.katas.marsrover;

public class Grid {
    private final int lenX;
    private final int lenY;

    public Grid(int lenX, int lenY) {
        this.lenX = lenX;
        this.lenY = lenY;
    }

    public int lenX() {
        return lenX;
    }

    public int lenY() {
        return lenY;
    }
}