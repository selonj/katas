package com.selonj.katas;

/**
 * Created by L.x on 16-3-21.
 */
public class WordWrap {
    private static final char LINE_BREAK = '\n';
    private int maxColumns;

    public WordWrap(int maxColumns) {
        this.maxColumns = maxColumns;
    }

    public static WordWrap of(int maxColumns) {
        return new WordWrap(maxColumns);
    }

    public String wrap(String source) {
        int pos = 0;
        if (source.length() > maxColumns) {
            String result = "";
            result += source.substring(pos, pos + maxColumns - 1) + LINE_BREAK;
            result += source.substring(pos + maxColumns);
            return result;
        }
        return source;
    }
}
