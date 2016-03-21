package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-21.
 */
public class WordWrapTest {

    @Test
    public void returnDirectlyWhenWrapEmptyString() throws Exception {
        assertThat(WordWrap.of(5).wrap(""),equalTo(""));
    }
}
