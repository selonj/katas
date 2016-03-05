package com.selonj.katas;

/**
 * Created by L.x on 16-3-5.
 */
public class FuzzBuzz {
    public static String of(int n) {
        if (isFuzz(n)) {
            return "Fuzz";
        }
        return String.valueOf(n);
    }

    private static boolean isFuzz(int n) {
        return n % 3 == 0;
    }
}
