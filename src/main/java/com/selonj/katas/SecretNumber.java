package com.selonj.katas;

/**
 * Created by L.x on 16-3-27.
 */
public class SecretNumber {
    private final char[] digits;

    public SecretNumber(String digits) {
        this.digits = digits.toCharArray();
    }

    public static SecretNumber of(String digits) {
        return new SecretNumber(digits);
    }

    public MatchingResult matching(String digits) {
        char[] that = digits.toCharArray();
        return new MatchingResult(bulls(that), cows(that));
    }

    private int cows(char[] that) {
        int cows = 0;
        int i = 0;
        int position;
        position = find(that[i]);
        if (position != -1 && position != i) {
            cows++;
        }
        i++;
        position = find(that[i]);
        if (position != -1 && position != i) {
            cows++;
        }
        i++;
        return cows;
    }

    private int find(char digit) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == digit) {
                return i;
            }
        }
        return -1;
    }

    private int bulls(char[] that) {
        int bulls = 0;
        for (int i = 0; i < this.digits.length; i++) {
            if (this.digits[i] == that[i]) {
                bulls++;
            }
        }
        return bulls;
    }
}
