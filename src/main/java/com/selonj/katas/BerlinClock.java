package com.selonj.katas;

/**
 * Created by L.x on 16-3-1.
 */
public class BerlinClock {
    public static BerlinClock at(String time) {
        return new BerlinClock();
    }

    public String display() {
        return "0000" +
                "0000" +
                "00000000000" +
                "0000";
    }
}
