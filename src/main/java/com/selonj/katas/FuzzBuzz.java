package com.selonj.katas;

/**
 * Created by L.x on 16-3-5.
 */
public enum FuzzBuzz {
    Fuzz, Buzz;

    private final int mod;

    FuzzBuzz() {
        mod = 3;
    }

    public boolean test(int n) {
        return n % mod == 0;
    }

    public static String of(int n) {
        if (n > 0) {
            if (Fuzz.test(n) && isBuzz(n)) {
                return "FuzzBuzz";
            }
            if (Fuzz.test(n)) {
                return Fuzz.name();
            }
            if (isBuzz(n)) {
                return Buzz.name();
            }
        }

        return String.valueOf(n);
    }

    private static boolean isBuzz(int n) {
        return n % 5 == 0;
    }
}
