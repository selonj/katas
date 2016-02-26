package com.selonj.katas;

/**
 * Created by L.x on 16-2-26.
 */
public class Game {
    public static final int ROLLS_COUNT = 21;
    private int[] rolls = new int[ROLLS_COUNT];
    private int size;

    public void roll(int pins) {
        rolls[size++] = pins;
    }

    public int score() {
        int score = 0;
        int i = 0;
        for (int frame = 0; frame < 10; frame++) {
            score += rolls[i] + rolls[i + 1];
            i += 2;
        }
        return score;
    }
}
