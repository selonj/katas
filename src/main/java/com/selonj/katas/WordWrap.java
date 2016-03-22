package com.selonj.katas;

/**
 * Created by L.x on 16-3-21.
 */
public class WordWrap {
    private static final char LINE_BREAK = '\n';
    private static final char WHITE_SPACE = ' ';
    private static final int EOF = -1;
    private int maxColumns;

    public WordWrap(int maxColumns) {
        this.maxColumns = maxColumns;
    }

    public static WordWrap maxColumnsInEachLine(int maxColumns) {
        return new WordWrap(maxColumns);
    }

    public String wrap(String source) {
        char[] chars = source.toCharArray();
        StringBuilder lines = new StringBuilder();

        int startPos = 0;
        while (chars.length - startPos > maxColumns) {
            int lastPos = lastColumnPosInLine(chars, startPos);
            lines.append(columnsInLine(chars, startPos, lastPos));
            lines.append(LINE_BREAK);
            startPos = lastPos + 1;
        }

        return lines.append(columnsInLastLine(chars, startPos)).toString();
    }

    private int lastColumnPosInLine(char[] chars, int start) {
        int last = start + maxColumns - 1;
        if (chars[last] == WHITE_SPACE) {
            return last;
        }
        int lastSpacePos = lastSpacePosInLine(chars, start, last);
        return lastSpacePos == EOF ? last : lastSpacePos;
    }

    private CharSequence columnsInLine(char[] chars, int startPos, int lastPos) {
        if (chars[lastPos] == WHITE_SPACE) {
            return substring(chars, startPos, lastPos);
        }
        return substring(chars, startPos, lastPos + 1);
    }

    private int lastSpacePosInLine(char[] chars, int start, int last) {
        while (start <= last) {
            if (chars[last] == WHITE_SPACE) {
                return last;
            }
            last--;
        }
        return EOF;
    }

    private String substring(char[] chars, int startPos, int lastPos) {
        return String.valueOf(chars, startPos, lastPos - startPos);
    }

    private String columnsInLastLine(char[] chars, int startPos) {
        return substring(chars, startPos, chars.length);
    }
}
