package com.selonj.katas;

/**
 * Created by L.x on 16-3-7.
 */
public class NMath {
    public static int factorial(int n) {
        if (n > 2) {
            return factorial(n - 1) * n;
        }
        return n;
    }
}
