package com.selonj.katas;

/**
 * Created by L.x on 16-3-1.
 */
public class BerlinClock {
    public static final String LITED_LIGHT = "RRRR";
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
            return litLightsOfRow1() + "00";
        }
        if (hours / 5 == 1) {
            return litLightsOfRow1() + "000";
        }
        return litLightsOfRow1() + "0000";
    }

    private String litLightsOfRow1() {
        return LITED_LIGHT.substring(0, hours / 5);
    }
}
