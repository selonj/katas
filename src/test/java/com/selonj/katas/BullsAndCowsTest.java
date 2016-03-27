package com.selonj.katas;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-27.
 */
public class BullsAndCowsTest {

    @Test
    public void noBullsAndCowsWhenAllDigitsAreWrong() throws Exception {

        assertResult(SecretNumber.of("1234").matching("5678"), 0, 0);
    }

    @Test
    public void hasBullsWhenDigitsMatchingAtTheRightPosition() throws Exception {
        assertResult(SecretNumber.of("1234").matching("1678"), 1, 0);
        assertResult(SecretNumber.of("1234").matching("1278"), 2, 0);
    }

    private void assertResult(MatchingResult result, int bulls, int cows) {
        assertThat("bulls", result.bulls, equalTo(bulls));
        assertThat("cows", result.cows, equalTo(cows));
    }


}
