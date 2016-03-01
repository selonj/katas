package com.selonj.katas;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-1.
 */
public class BerlinClockTest {
    @Test
    @Ignore
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
    public void getHoursOfRow1() throws Exception {
        assertThat(BerlinClock.at("00:00").getHoursOfRow1(), equalTo("0000"));
        assertThat(BerlinClock.at("05:00").getHoursOfRow1(), equalTo("R000"));
        assertThat(BerlinClock.at("10:00").getHoursOfRow1(), equalTo("RR00"));
        assertThat(BerlinClock.at("15:00").getHoursOfRow1(), equalTo("RRR0"));
        assertThat(BerlinClock.at("20:00").getHoursOfRow1(), equalTo("RRRR"));
        assertThat(BerlinClock.at("17:00").getHoursOfRow1(), equalTo("RRR0"));
    }

    @Test
    public void getHoursOfRow2() throws Exception {
        assertThat(BerlinClock.at("00:00").getHoursOfRow2(), equalTo("0000"));
        assertThat(BerlinClock.at("01:00").getHoursOfRow2(), equalTo("R000"));
        assertThat(BerlinClock.at("02:00").getHoursOfRow2(), equalTo("RR00"));
        assertThat(BerlinClock.at("03:00").getHoursOfRow2(), equalTo("RRR0"));
        assertThat(BerlinClock.at("04:00").getHoursOfRow2(), equalTo("RRRR"));
        assertThat(BerlinClock.at("12:00").getHoursOfRow2(), equalTo("RR00"));
    }

    @Test
    public void getMinutesOfRow2() throws Exception {
        assertThat(BerlinClock.at("00:00").getMinutesOfRow2(), equalTo("0000"));
        assertThat(BerlinClock.at("00:01").getMinutesOfRow2(), equalTo("Y000"));
        assertThat(BerlinClock.at("00:02").getMinutesOfRow2(), equalTo("YY00"));
        assertThat(BerlinClock.at("00:03").getMinutesOfRow2(), equalTo("YYY0"));
        assertThat(BerlinClock.at("00:04").getMinutesOfRow2(), equalTo("YYYY"));
        assertThat(BerlinClock.at("00:06").getMinutesOfRow2(), equalTo("Y000"));
    }
}
