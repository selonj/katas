package com.selonj.katas;

/**
 * Created by L.x on 16-3-1.
 */
public class BerlinClock {
    public static final String LIT_LIGHT_OF_HOURS = "RRRR";
    public static final String LIT_LIGHT_OF_MINUTES2 = "YYYY";
    private static final int HOURS_POS = 0;
    private static final int MINUTES_POS = 1;
    private static final String TIME_SEP = ":";
    private final int hours;
    private final int minutes;

    public BerlinClock(String time) {
        String[] parts = time.split(TIME_SEP);
        this.hours = Integer.parseInt(parts[HOURS_POS]);
        this.minutes = Integer.parseInt(parts[MINUTES_POS]);
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

    public String getMinutesOfRow1() {
        return litLightsOfMinutes1(minutes / 5) + unlitLights2(minutes / 5);
    }

    private String litLightsOfMinutes1(int n) {
        return "YYRYYRYYRYY".substring(0, n);
    }

    private String unlitLights2(int numberOfLitLights) {
        return "00000000000".substring(numberOfLitLights);
    }
}
