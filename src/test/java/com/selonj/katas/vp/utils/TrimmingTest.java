package com.selonj.katas.vp.utils;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-12.
 */
public class TrimmingTest {
    @Test
    public void trimString() throws Exception {
        assertThat(Trimming.on(" foo "), equalTo("foo"));
        assertThat(Trimming.on(" bar "), equalTo("bar"));
    }

    @Test
    public void trimNull() throws Exception {
        assertThat(Trimming.on(null), nullValue());
    }
}
