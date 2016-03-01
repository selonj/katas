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

    public String getHoursOfRow1() {
        int numberOfLitLights = hours / 5;
        return "RRRR".substring(0, numberOfLitLights) + "0000".substring(numberOfLitLights);
    }

    public String getHoursOfRow2() {
        int numberOfLitLights = hours % 5;
        return "RRRR".substring(0, numberOfLitLights) + "0000".substring(numberOfLitLights);
    }

    public String getMinutesOfRow2() {
        int numberOfLitLights = minutes % 5;
        return "YYYY".substring(0, numberOfLitLights) + "0000".substring(numberOfLitLights);
    }

    public String getMinutesOfRow1() {
        int numberOfLitLights = minutes / 5;
        return "YYRYYRYYRYY".substring(0, numberOfLitLights) + "00000000000".substring(numberOfLitLights);
    }

}
