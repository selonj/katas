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
        int frameIndex = 0;
        for (int frame = 0; frame < FRAMES; frame++) {
            if (isSpare(frameIndex)) {
                score += FRAME_PINS + rolls[frameIndex + 2];
                frameIndex += 2;
            } else {
                score += rolls[frameIndex] + rolls[frameIndex + 1];
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == FRAME_PINS;
    }
}
