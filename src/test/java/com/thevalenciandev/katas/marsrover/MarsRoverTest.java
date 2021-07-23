package com.thevalenciandev.katas.marsrover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

    @ParameterizedTest
    @MethodSource("canMoveToAllDirectionsArgs")
    void canMoveToAllDirections(String command, String expectedFinishingPoint) {
        var marsRover = new MarsRover(new Grid(10, 10));

        String finishingPoint = marsRover.execute(command);
        assertEquals(expectedFinishingPoint, finishingPoint); // x:y:direction
    }

    private static Stream<Arguments> canMoveToAllDirectionsArgs() {
        return Stream.of(
                Arguments.of("M", "0:1:N"),
                Arguments.of("RM", "1:0:E"),
                Arguments.of("RMLM", "1:1:N"),
                Arguments.of("MMRMRM", "1:1:S")
        );
    }

    @ParameterizedTest
    @MethodSource("canWrapAroundArgs")
    void canWrapAround(String command, String expectedFinishingPoint) {
        var marsRover = new MarsRover(new Grid(10, 8));

        String finishingPoint = marsRover.execute(command);
        assertEquals(expectedFinishingPoint, finishingPoint);
    }

    private static Stream<Arguments> canWrapAroundArgs() {
        return Stream.of(
                Arguments.of("M".repeat(8), "0:0:N"),
                Arguments.of("R" + "M".repeat(10), "0:0:E")
        );
    }

}
