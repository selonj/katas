package com.selonj.katas;

/**
 * Created by L.x on 16-2-26.
 */
public class Game {
    private int score;

    public void roll(int pins) {
        score += pins;
    }

    public int score() {
        return score;
    }
}
