package com.selonj.katas;

/**
 * Created by L.x on 16-3-1.
 */
public class BerlinClock {
    private final int hours;

    public BerlinClock(String time) {
        String[] parts = time.split(":");
        this.hours = Integer.parseInt(parts[0]);
    }

    public static BerlinClock at(String time) {
        return new BerlinClock(time);
    }

    public String display() {
        return "0000" +
                "0000" +
                "00000000000" +
                "0000";
    }

    public String getHoursOfRow1() {
        if (hours / 5 == 2) {
            return "RR00";
        }
        if (hours / 5 == 1) {
            return "R000";
        }
        return "0000";
    }
}
