package com.selonj.katas;

/**
 * Created by L.x on 16-2-27.
 */
public class Strings {

    public static final int BEFORE_FIRST = -1;
    public static final int NOT_FOUND = -1;

    public static boolean isPermutationOf(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.length() == 0) {
            return true;
        }

        char header = s1.charAt(0);
        int pos = BEFORE_FIRST;
        while (true) {
            pos = s2.indexOf(header, pos + 1);
            if (pos == NOT_FOUND) {
                return false;
            }
            if (s1.equals(swapAt(s2, pos))) {
                return true;
            }
        }
    }

    private static String swapAt(String s, int pos) {
        return s.substring(pos) + s.substring(0, pos);
    }

    public static String reverse(String source) {
        if (source.length() > 1) {
            char[] chars = source.toCharArray();
            int i = 0;
            int j = source.length() - 1;
            for (; i < j; i++, j--) {
                swap(chars, i, j);
            }
            return new String(chars);
        }
        return source;
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
