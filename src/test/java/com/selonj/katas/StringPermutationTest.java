package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-2-27.
 */
public class StringPermutationTest {

    @Test
    public void emptyStrings() throws Exception {
        assertThat(Strings.isPermutationOf("", ""), is(true));
    }

    @Test
    public void diffLengthStrings() throws Exception {
        assertThat(Strings.isPermutationOf("a", "bc"), is(false));
    }
}
