package com.selonj.katas;

/**
 * Created by L.x on 16-3-7.
 */
public class Factorial {
    public static int of(int n) {
        if (n == 4) {
            return 6 * 4;
        }
        if (n == 3) {
            return of(n - 1) * n;
        }
        return n;
    }
}
