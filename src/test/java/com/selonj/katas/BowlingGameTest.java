package com.selonj.katas;

import org.junit.Before;
import org.junit.Ignore;
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

    @Test
    public void oneSpare() throws Exception {
        rollASpare();
        game.roll(3);
        rollMany(17, 0);

        assertGameScoreEquals(16);
    }

    @Test
    public void oneStrike() throws Exception {
        rollAStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);

        assertGameScoreEquals(24);
    }

    @Test
    public void perfectGame() throws Exception {
        rollMany(12, 10);

        assertGameScoreEquals(300);
    }

    private void rollAStrike() {
        game.roll(10);
    }

    private void rollASpare() {
        game.roll(5);
        game.roll(5);
    }


}
