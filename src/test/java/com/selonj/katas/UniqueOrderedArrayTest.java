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

    private int[] unique(int[] array) {
        return null;
    }

    private Matcher<? super int[]> returns(int[] expected) {
        return equalTo(expected);
    }
}
