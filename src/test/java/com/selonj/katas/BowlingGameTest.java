package com.selonj.katas;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-2-26.
 */
public class BowlingGameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void noPinsKnockedDownInAllRolls() throws Exception {
        rollMany(20, 0);
        assertGameScoreEquals(0);
    }

    @Test
    public void onePinKnockedDownInAllRolls() throws Exception {
        rollMany(20, 1);
        assertGameScoreEquals(20);
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }

    private void assertGameScoreEquals(int expected) {
        assertThat(game.score(), equalTo(expected));
    }
}
