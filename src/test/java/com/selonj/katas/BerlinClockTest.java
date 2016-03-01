package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-1.
 */
public class BerlinClockTest {
    @Test
    public void displayTime() throws Exception {
        assertThat(BerlinClock.at("00:00").display(), equalTo(
                    /**/"0000" +
                        "0000" +
                        "00000000000" +
                        "0000"
        ));

        assertThat(BerlinClock.at("23:59").display(), equalTo(
                    /**/"RRRR" +
                        "RRR0" +
                        "YYRYYRYYRYY" +
                        "YYYY"
        ));
    }

    @Test
    public void displayLightsOfHours1() throws Exception {
        assertThat(BerlinClock.at("00:00").displayLightsOfHours1(), equalTo("0000"));
        assertThat(BerlinClock.at("05:00").displayLightsOfHours1(), equalTo("R000"));
        assertThat(BerlinClock.at("10:00").displayLightsOfHours1(), equalTo("RR00"));
        assertThat(BerlinClock.at("15:00").displayLightsOfHours1(), equalTo("RRR0"));
        assertThat(BerlinClock.at("20:00").displayLightsOfHours1(), equalTo("RRRR"));
        assertThat(BerlinClock.at("17:00").displayLightsOfHours1(), equalTo("RRR0"));
    }

    @Test
    public void displayLightsOfHours2() throws Exception {
        assertThat(BerlinClock.at("00:00").displayLightsOfHours2(), equalTo("0000"));
        assertThat(BerlinClock.at("01:00").displayLightsOfHours2(), equalTo("R000"));
        assertThat(BerlinClock.at("02:00").displayLightsOfHours2(), equalTo("RR00"));
        assertThat(BerlinClock.at("03:00").displayLightsOfHours2(), equalTo("RRR0"));
        assertThat(BerlinClock.at("04:00").displayLightsOfHours2(), equalTo("RRRR"));
        assertThat(BerlinClock.at("12:00").displayLightsOfHours2(), equalTo("RR00"));
    }

    @Test
    public void displayLightsOfMinutes2() throws Exception {
        assertThat(BerlinClock.at("00:00").displayLightsOfMinutes2(), equalTo("0000"));
        assertThat(BerlinClock.at("00:01").displayLightsOfMinutes2(), equalTo("Y000"));
        assertThat(BerlinClock.at("00:02").displayLightsOfMinutes2(), equalTo("YY00"));
        assertThat(BerlinClock.at("00:03").displayLightsOfMinutes2(), equalTo("YYY0"));
        assertThat(BerlinClock.at("00:04").displayLightsOfMinutes2(), equalTo("YYYY"));
        assertThat(BerlinClock.at("00:06").displayLightsOfMinutes2(), equalTo("Y000"));
    }

    @Test
    public void displayLightsOfMinutes1() throws Exception {
        assertThat(BerlinClock.at("00:00").displayLightsOfMinutes1(), equalTo("00000000000"));
        assertThat(BerlinClock.at("00:05").displayLightsOfMinutes1(), equalTo("Y0000000000"));
        assertThat(BerlinClock.at("00:15").displayLightsOfMinutes1(), equalTo("YYR00000000"));
        assertThat(BerlinClock.at("00:55").displayLightsOfMinutes1(), equalTo("YYRYYRYYRYY"));
    }
}
