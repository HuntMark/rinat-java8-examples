package com.example.stepik_java.robotconnection;

public class RobotConnectionMain {
    public static void main(String[] args) {
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean robotMoved = false;
        int attemptsCount = 1;

        while (attemptsCount <= 3 && !robotMoved) {
            try (RobotConnection connection = robotConnectionManager.getConnection()) {
                connection.moveRobotTo(toX, toY);
                robotMoved = true;
            } catch (Throwable ex) {
                if (!(ex instanceof RobotConnectionException)) {
                    throw ex;
                }
            }
            attemptsCount++;
        }

        if (attemptsCount > 3) {
            throw new RobotConnectionException("Cannot create robot connection");
        }
    }
}
