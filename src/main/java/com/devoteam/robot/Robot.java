package com.devoteam.robot;

public class Robot {

    private int x;
    private int y;
    private char direction;
    private int width;
    private int depth;

    public void setRoomSize(int width, int depth) {
        this.width = width;
        this.depth = depth;
    }

    public void setStartPosition(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'E':
                direction = 'N';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'W':
                direction = 'S';
                break;
        }

    }

    public void turnRight() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }

    public void moveForward() {
        if (x < 0 || x >= width || y < 0 || y >= depth) {
            System.out.println("Error: Robot has walked outside of the room bounds");
            System.exit(1);
        }
        switch (direction) {
            case 'N':
                y++;
                break;
            case 'E':
                x++;
                break;
            case 'S':
                y--;
                break;
            case 'W':
                x--;
                break;
        }

    }

    public void runRobot(String commands) {
        for (char c : commands.toCharArray()) {
            switch (c) {
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'F':
                    moveForward();
                    break;
            }
        }
    }

    public String reportPosition() {
        return x + " " + y + " " + direction;
    }
}
