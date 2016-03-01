package com.selonj.katas;

/**
 * Created by L.x on 16-3-1.
 */
public class BerlinClock {
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
    private static final int ROW_OF_HOURS1 = 0;
    private static final int ROW_OF_HOURS2 = 1;
    private static final int ROW_OF_MINUTES1 = 2;
    private static final int ROW_OF_MINUTES2 = 3;

    private static final String TIME_SEP = ":";
    private static final int HOURS_POS = 0;
    private static final int MINUTES_POS = 1;
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
        return displayLightsOfHours1() +
                displayLightsOfHours2() +
                displayLightsOfMinutes1() +
                displayLightsOfMinutes2();
    }


    public String displayLightsOfHours1() {
        return displayLightsAt(ROW_OF_HOURS1, hours / 5);
    }

    public String displayLightsOfHours2() {
        return displayLightsAt(ROW_OF_HOURS2, hours % 5);
    }

    public String displayLightsOfMinutes1() {
        return displayLightsAt(ROW_OF_MINUTES1, minutes / 5);
    }

    public String displayLightsOfMinutes2() {
        return displayLightsAt(ROW_OF_MINUTES2, minutes % 5);
    }

    private String displayLightsAt(int row, int numberOfLitLights) {
        return litLightsAt(row, numberOfLitLights) + unlitLightsAt(row, numberOfLitLights);
    }

    private static String litLightsAt(int row, int numberOfLitLights) {
        return LIT_LIGHTS[row].substring(0, numberOfLitLights);
    }

    private static String unlitLightsAt(int row, int numberOfLitLights) {
        return UNLIT_LIGHTS[row].substring(numberOfLitLights);
    }

}
