package com.selonj.katas;

/**
 * Created by L.x on 16-2-26.
 */
public class Game {
    public static final int FRAMES = 10;
    public static final int ROLLS_COUNT = 2 * FRAMES + 1;

    private int[] rolls = new int[ROLLS_COUNT];
    private int size;

    public void roll(int pins) {
        rolls[size++] = pins;
    }

    public int score() {
        int score = 0;
        int i = 0;
        for (int frame = 0; frame < FRAMES; frame++) {
            score += rolls[i] + rolls[i + 1];
            i += 2;
        }
        return score;
    }
}
