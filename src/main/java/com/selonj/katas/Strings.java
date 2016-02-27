package com.selonj.katas;

/**
 * Created by L.x on 16-2-27.
 */
public class Strings {
    public static boolean isPermutationOf(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }
        int pos = -1;
        while (true) {
            pos = s2.indexOf(s1.charAt(0), pos + 1);
            if (pos == -1) {
                break;
            }
            if (s1.equals(s2.substring(pos) + s2.substring(0, pos))) {
                return true;
            }
        }
        return false;
    }
}
