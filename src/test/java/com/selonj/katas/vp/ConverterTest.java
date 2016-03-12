package com.selonj.katas.vp;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-12.
 */
public class ConverterTest {
    @Test
    public void convertToString() throws Exception {
        assertThat(converter.convert("foo", String.class), equalTo("foo"));
    }
}
