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
            StringBuilder rows = new StringBuilder();

            int startPos = 0;
            while (chars.length - startPos > maxColumns) {
                int lastPos = startPos + maxColumns - 1;
                rows.append(columnsInRow(chars, startPos, lastPos));
                rows.append(LINE_BREAK);
                startPos += columnsWidthInRow(chars, startPos, lastPos);
            }

            return rows.append(columnsInLastRow(chars, startPos)).toString();
        }
        return source;
    }

    private String columnsInLastRow(char[] chars, int startPos) {
        return String.valueOf(chars, startPos, chars.length - startPos);
    }

    private CharSequence columnsInRow(char[] chars, int startPos, int lastPos) {
        if (chars[lastPos] == WHITE_SPACE) {
            return String.valueOf(chars, startPos, lastPos - startPos);
        }
        int lastSpacePos = lastSpacePosIn(chars, startPos, lastPos);
        if (lastSpacePos != EOF) {
            return String.valueOf(chars, startPos, lastSpacePos - startPos);
        } else {
            return String.valueOf(chars, startPos, lastPos - startPos + 1);
        }
    }

    private int columnsWidthInRow(char[] chars, int start, int last) {
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
