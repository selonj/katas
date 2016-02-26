package com.selonj.katas;

/**
 * Created by L.x on 16-2-26.
 */
public class Game {
    public static final int FRAMES = 10;
    public static final int ROLLS_COUNT = 2 * FRAMES + 1;
    public static final int FRAME_PINS = 10;

    private int[] rolls = new int[ROLLS_COUNT];
    private int size;

    public void roll(int pins) {
        rolls[size++] = pins;
    }

    public int score() {
        int score = 0;
        int i = 0;
        for (int frame = 0; frame < FRAMES; frame++) {
            if (rolls[i] + rolls[i + 1] == FRAME_PINS) {
                score += FRAME_PINS + rolls[i + 2];
                i += 2;
            } else {
                score += rolls[i] + rolls[i + 1];
                i += 2;
            }
        }
        return score;
    }
}
