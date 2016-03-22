package com.selonj.katas.vp;

import java.util.Objects;

/**
 * Created by L.x on 16-3-12.
 */
//todo: checking time constraints,e.g: hours in [0..23] & minutes in [0..59]
public class Time {
    private int hours;
    private int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hours == time.hours &&
                minutes == time.minutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, minutes);
    }

    public static Time at(int hours, int minutes) {
        return new Time(hours, minutes);
    }

    @Override
    public String toString() {
        return "at " + hours + ":" + minutes;
    }
}
