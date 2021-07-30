package com.thevalenciandev.katas.marsrover;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

    @ParameterizedTest
    @MethodSource("canMoveToAllDirectionsArgs")
    void canMoveToAllDirections(String command, String expectedFinishingPoint) {
        var marsRover = new MarsRover(new Grid.Builder(10, 10).build());

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
        var marsRover = new MarsRover(new Grid.Builder(10, 8).build());

        String finishingPoint = marsRover.execute(command);
        assertEquals(expectedFinishingPoint, finishingPoint);
    }

    private static Stream<Arguments> canWrapAroundArgs() {
        return Stream.of(
                Arguments.of("L" + "M", "9:0:W"),
                Arguments.of("L" + "M".repeat(10), "0:0:W"),
                Arguments.of("RRM", "0:7:S"),
                Arguments.of("RR" + "M".repeat(8), "0:0:S")
        );
    }

    @ParameterizedTest
    @MethodSource("canReportObstaclesArgs")
    void canReportObstacles(int obstacleX, int obstacleY, String command, String expectedFinishingPoint) {
        var marsRover = new MarsRover(new Grid.Builder(10, 8)
                .withObstacle(obstacleX, obstacleY).build());

        String finishingPoint = marsRover.execute(command);
        assertEquals(expectedFinishingPoint, finishingPoint);
    }

    private static Stream<Arguments> canReportObstaclesArgs() {
        return Stream.of(
                Arguments.of(0, 3, "MMM", "O:0:2:N"),
                Arguments.of(3, 0, "RMMM","O:2:0:E"),
                Arguments.of(9, 0, "LM",  "O:0:0:W"),
                Arguments.of(0, 7, "LLM", "O:0:0:S")
        );
    }
}
