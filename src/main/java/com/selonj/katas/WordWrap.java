package com.selonj.katas;

/**
 * Created by L.x on 16-3-21.
 */
public class WordWrap {
    private static final char LINE_BREAK = '\n';
    private static final char WHITE_SPACE = ' ';
    private int maxColumns;

    public WordWrap(int maxColumns) {
        this.maxColumns = maxColumns;
    }

    public static WordWrap of(int maxColumns) {
        return new WordWrap(maxColumns);
    }

    public String wrap(String source) {
        if (source.length() > maxColumns) {
            char[] chars = source.toCharArray();
            StringBuilder result = new StringBuilder();

            int startPos = 0;
            while (chars.length - startPos > maxColumns) {
                int lastPos = startPos + maxColumns - 1;
                result.append(chars, startPos, maxColumns - 1);
                if (chars[lastPos] == WHITE_SPACE) {
                    result.append(LINE_BREAK);
                } else {
                    result.append(chars[lastPos]);
                    result.append(LINE_BREAK);
                }
                startPos = lastPos + 1;
            }
            result.append(chars, startPos, chars.length - startPos);

            return result.toString();
        }
        return source;
    }

}
