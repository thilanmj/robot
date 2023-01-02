package com.devoteam.robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RobotTest {

    Robot robot;

    @BeforeEach
    public void setup() {
        robot = new Robot();
    }

    @Test
    public void shouldShowReport() {
        robot.setRoomSize(5, 5);
        robot.setStartPosition(1, 2, 'N');
        robot.runRobot("RFRFFRFRF");
        String result = robot.reportPosition();
        String splittedResult[] = result.split(" ");

        assertEquals(1, splittedResult[0]);
        assertEquals(3, splittedResult[1]);
        assertEquals("N", splittedResult[2]);

    }

    @Test
    public void shouldExit() {
        robot.setRoomSize(5, 5);
        robot.setStartPosition(0, 0, 'E');
        robot.runRobot("RFLFFLRF");
        String result = robot.reportPosition();
        String splittedResult[] = result.split(" ");

        assertEquals(1, splittedResult[0]);
        assertEquals(3, splittedResult[1]);
        assertEquals("N", splittedResult[2]);
    }
}
