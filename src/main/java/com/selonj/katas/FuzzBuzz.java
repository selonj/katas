package com.selonj.katas;

/**
 * Created by L.x on 16-3-5.
 */
public class FuzzBuzz {
    public static String of(int n) {
        if (n == 3) {//fuzz?
            return "Fuzz";
        }
        return String.valueOf(n);
    }
}
