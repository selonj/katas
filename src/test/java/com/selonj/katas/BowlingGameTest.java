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
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }

        assertThat(game.score(), equalTo(0));
    }

    @Test
    public void onePinKnockedDownInAllRolls() throws Exception {
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }

        assertThat(game.score(), equalTo(20));
    }
}
