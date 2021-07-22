package com.thevalenciandev.katas.marsrover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

    @Test
    void canMoveOnce_North() {
        var marsRover = new MarsRover(new Grid(10,10));

        String finishingPoint = marsRover.execute("M");
        assertEquals("1:0:N", finishingPoint);
    }

    @Test
    void canWrapAroundNorth_xAxis() {
        var marsRover = new MarsRover(new Grid(10,10));

        String finishingPoint = marsRover.execute("M".repeat(10));
        assertEquals("0:0:N", finishingPoint);
    }

    @Test
    void canRotateRight_FromNorth() {
        var marsRover = new MarsRover(new Grid(10,10));

        String finishingPoint = marsRover.execute("R");
        assertEquals("0:0:E", finishingPoint);
    }

    @Test
    void canRotateLeft_FromNorth() {
        var marsRover = new MarsRover(new Grid(10,10));

        String finishingPoint = marsRover.execute("L");
        assertEquals("0:0:W", finishingPoint);
    }
}
