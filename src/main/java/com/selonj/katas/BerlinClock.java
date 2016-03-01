package com.selonj.katas;

/**
 * Created by L.x on 16-3-1.
 */
public class BerlinClock {
    public static final String LIT_LIGHT_OF_HOURS = "RRRR";
    public static final String LIT_LIGHT_OF_MINUTES2 = "YYYY";
    private final int hours;
    private final int minutes;

    public BerlinClock(String time) {
        String[] parts = time.split(":");
        this.hours = Integer.parseInt(parts[0]);
        this.minutes = Integer.parseInt(parts[1]);
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
        return litLightsOfHours(hours / 5) + unlitLights(hours / 5);
    }

    private String unlitLights(int numberOfLintLights) {
        return "0000".substring(numberOfLintLights);
    }

    private String litLightsOfHours(int n) {
        return LIT_LIGHT_OF_HOURS.substring(0, n);
    }

    public String getHoursOfRow2() {
        return litLightsOfHours(hours % 5) + unlitLights(hours % 5);
    }

    public String getMinutesOfRow2() {
        return litLightsOfMinutes2(minutes % 5) + unlitLights(minutes % 5);
    }

    private String litLightsOfMinutes2(int numberOfLitLights) {
        return LIT_LIGHT_OF_MINUTES2.substring(0, numberOfLitLights);
    }
}
