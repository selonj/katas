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
        int bulls = 0;
        if (this.digits[0] == digits.charAt(0)) {
            bulls = 1;
        }
        return new MatchingResult(bulls, 0);
    }
}
