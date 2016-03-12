package com.selonj.katas.vp;

import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-12.
 */
public class StringMarshallerTest {
    @Test
    public void marshall() throws Exception {
        assertThat(marshaller.marshall("foo"),equalTo("foo"));
    }
}
