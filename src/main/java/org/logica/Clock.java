package org.logica;

public class Clock {

    public int returnClockAngle(int hour, int minute) {
        if (hour >= 12)
            hour -= 12;

        int angleMinute = minute * 6;
        int angleHour = hour * 30;

        return Math.abs(angleHour - angleMinute);
    }
}