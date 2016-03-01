package com.selonj.katas;

/**
 * Created by L.x on 16-3-1.
 */
public class BerlinClock {
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
        return getHoursOfRow1() +
                getHoursOfRow2() +
                getMinutesOfRow1() +
                getMinutesOfRow2();
    }

    private static final String[] LIT_LIGHTS = new String[]{
            "RRRR",
            "RRRR",
            "YYRYYRYYRYY",
            "YYYY"
    };
    private static final String[] UNLIT_LIGHTS = new String[]{
            "0000",
            "0000",
            "00000000000",
            "0000"
    };

    public String getHoursOfRow1() {
        int numberOfLitLights = hours / 5;
        int row = 0;
        return litLightsAt(row, numberOfLitLights) + unlitLightsAt(row, numberOfLitLights);
    }

    public String getHoursOfRow2() {
        int numberOfLitLights = hours % 5;
        int row = 1;
        return litLightsAt(row, numberOfLitLights) + unlitLightsAt(row, numberOfLitLights);
    }

    public String getMinutesOfRow2() {
        int numberOfLitLights = minutes % 5;
        int row = 3;
        return litLightsAt(row, numberOfLitLights) + unlitLightsAt(row, numberOfLitLights);
    }

    public String getMinutesOfRow1() {
        int numberOfLitLights = minutes / 5;
        int row = 2;
        return litLightsAt(row, numberOfLitLights) + unlitLightsAt(row, numberOfLitLights);
    }

    private String litLightsAt(int row, int numberOfLitLights) {
        return LIT_LIGHTS[row].substring(0, numberOfLitLights);
    }

    private String unlitLightsAt(int row, int numberOfLitLights) {
        return UNLIT_LIGHTS[row].substring(numberOfLitLights);
    }

}
