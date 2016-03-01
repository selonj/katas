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


    }
}
