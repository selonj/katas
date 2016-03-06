package com.selonj.katas;

/**
 * Created by L.x on 16-3-6.
 */
public class Fib {
    public static int of(int n) {
        if (n > 2) {
            return of(n - 2) + of(n - 1);
        }
        return 1;
    }
}
