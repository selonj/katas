package com.selonj.katas;

/**
 * Created by L.x on 16-3-5.
 */
public enum FuzzBuzz {
    Fuzz(3), Buzz(5);

    private final int mod;

    FuzzBuzz(int mod) {
        this.mod = mod;
    }

    public boolean test(int n) {
        return n > 0 && n % mod == 0;
    }

    public static String of(int n) {
        if (Fuzz.test(n) && Buzz.test(n)) {
            return Fuzz.name() + Buzz.name();
        }

        if (Fuzz.test(n)) {
            return Fuzz.name();
        }
        if (Buzz.test(n)) {
            return Buzz.name();
        }

        return String.valueOf(n);
    }
}
