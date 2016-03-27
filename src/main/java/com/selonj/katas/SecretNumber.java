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
        int bulls = 0;
        int i = 0;
        while (i < this.digits.length) {
            if (this.digits[i] == that[i]) {
                bulls++;
            }
            i++;
        }
        return new MatchingResult(bulls, 0);
    }
}
