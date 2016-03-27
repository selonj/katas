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
        return new MatchingResult(bulls(that), 0);
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
