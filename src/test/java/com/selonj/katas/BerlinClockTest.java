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
        assertThat(BerlinClock.at("00:00").getHoursOfRow1(),equalTo("0000"));
        assertThat(BerlinClock.at("05:00").getHoursOfRow1(),equalTo("R000"));
//        assertThat(BerlinClock.at("10:00").getHoursOfRow1(),equalTo("RR00"));
    }
}
