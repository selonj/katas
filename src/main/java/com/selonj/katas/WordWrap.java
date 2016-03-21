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
        if (source.length() > maxColumns) {
            String result = "";
            int pos = 0;
            while (source.length() - pos > maxColumns) {
                result += source.substring(pos, pos + maxColumns - 1) + LINE_BREAK;
                pos += maxColumns;
            }
            result += source.substring(pos);

            return result;
        }
        return source;
    }
}
