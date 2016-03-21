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
                if (chars[lastPos] == WHITE_SPACE) {
                    result.append(chars, startPos, maxColumns - 1);
                    result.append(LINE_BREAK);
                } else {
                    int lastSpacePos = lastSpacePosIn(chars, startPos, lastPos);
                    if (lastSpacePos != EOF) {
                        result.append(chars, startPos, lastSpacePos - startPos);
                        result.append(LINE_BREAK);
                    } else {
                        result.append(chars, startPos, maxColumns - 1);
                        result.append(chars[lastPos]);
                        result.append(LINE_BREAK);
                    }
                }
                startPos += columnsInRow(chars, startPos, lastPos);
            }
            result.append(chars, startPos, chars.length - startPos);

            return result.toString();
        }
        return source;
    }

    private int columnsInRow(char[] chars, int start, int last) {
        if (chars[last] == WHITE_SPACE) {
            return maxColumns;
        }
        int lastSpacePos = lastSpacePosIn(chars, start, last);
        return lastSpacePos == EOF ? maxColumns : lastSpacePos - start + 1;
    }

    private int lastSpacePosIn(char[] chars, int start, int last) {
        while (start <= last) {
            if (chars[last] == WHITE_SPACE) {
                return last;
            }
            last--;
        }
        return EOF;
    }

}
