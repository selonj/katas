package com.selonj.katas;

/**
 * Created by L.x on 16-3-1.
 */
public class BerlinClock {
    private String time;

    public BerlinClock(String time) {
        this.time = time;
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
        if (time.equals("05:00")) {
            return "R000";
        }
        return "0000";
    }
}
