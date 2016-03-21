package com.selonj.katas;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-21.
 */
public class WordWrapTest {

    @Test
    public void returnDirectlyWhenWrapEmptyString() throws Exception {
        assertThat(WordWrap.of(5).wrap(""), equalTo(""));
    }

    @Test
    public void returnStringWhenStringLengthLessThanMaxColumns() throws Exception {
        assertThat(WordWrap.of(5).wrap("word"), equalTo("word"));
    }

    @Test
    public void replaceWithLineBreakWhenLastColumnIsWhitespace() throws Exception {
        assertThat(WordWrap.of(5).wrap("word word"), equalTo("word\nword"));
        assertThat(WordWrap.of(5).wrap("word word word"), equalTo("word\nword\nword"));
    }

    @Test
    public void replaceWithLineBreakAtMaxColumns() throws Exception {
        assertThat(WordWrap.of(10).wrap("word word word"), equalTo("word word\nword"));
    }

    @Test
    public void breakLongWordWhenWordLengthLargeThanMaxColumns() throws Exception {
        assertThat(WordWrap.of(4).wrap("wordword"), equalTo("word\nword"));
    }

    @Test
    @Ignore
    public void breakingAtTheSpaceWhenCurrentRowContainsWhitespace() throws Exception {
        assertThat(WordWrap.of(4).wrap("a word"), equalTo("a\nword"));
    }

}
