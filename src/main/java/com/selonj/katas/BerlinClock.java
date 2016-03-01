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
        return litLightsOfHours(hours / 5) + unlitLightsOfHours(hours / 5);
    }

    private String unlitLightsOfHours(int numberOfLintLights) {
        return "0000".substring(numberOfLintLights);
    }

    private String litLightsOfHours(int n) {
        return LITED_LIGHT.substring(0, n);
    }

    public String getHoursOfRow2() {
        return litLightsOfHours(hours % 5) + unlitLightsOfHours(hours % 5);
    }

}
