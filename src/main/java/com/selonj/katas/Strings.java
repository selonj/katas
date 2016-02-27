package com.selonj.katas;

/**
 * Created by L.x on 16-2-27.
 */
public class Strings {
    public static boolean isPermutationOf(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return s1.equals(s2);
    }
}
