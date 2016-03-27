package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-27.
 */
public class BullsAndCowsTest {

    @Test
    public void noBullsAndCowsWhenAllDigitsAreWrong() throws Exception {
        MatchingResult result = SecretNumber.of("1234").matching("5678");

        assertThat(result.bulls, equalTo(0));
        assertThat(result.cows, equalTo(0));
    }


}
