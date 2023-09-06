package org.logica;

public class Clock {

    public int returnClockAngle(int hour, int minute) {
        if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60) {
            System.out.println("Invalid time! Please insert between hour (0-24) and minute (0-59)");
            return -1;
        }
        else {
            if (hour >= 12)
                hour -= 12;

            int angleMinute = minute * 6;
            int angleHour = hour * 30;

            return Math.abs(angleHour - angleMinute);
        }
    }
}