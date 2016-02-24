package com.selonj.katas;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-2-25.
 */
public class UniqueOrderedArrayTest {
    @Test
    public void emptyArray() throws Exception {
        assertThat(unique(new int[0]), returns(new int[0]));
    }

    @Test
    public void nothing() throws Exception {
        assertThat(unique(new int[1]), returns(new int[1]));
    }

    @Test
    public void distinction() throws Exception {
        assertThat(unique(1), returns(1));
    }

    private int[] unique(int... array) {
        return new int[array.length];
    }

    private Matcher<? super int[]> returns(int... expected) {
        return equalTo(expected);
    }
}
