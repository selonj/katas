package com.selonj.katas;

import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.Arrays;

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
    public void distinctions() throws Exception {
        assertThat(unique(1), returns(1));
        assertThat(unique(1, 2), returns(1, 2));
        assertThat(unique(1, 2, 3), returns(1, 2, 3));
    }

    @Test
    public void duplications() throws Exception {
        assertThat(unique(1, 1), returns(1));
        assertThat(unique(1, 1, 1), returns(1));
    }

    private int[] unique(int... array) {
        int[] results = new int[array.length];
        int n = 0;
        for (int i = 0; array.length > i; i++) {
            if (i > 0 && array[i] == results[n - 1]) ;
            else
                results[n++] = array[i];
        }
        return Arrays.copyOfRange(results, 0, n);
    }

    private Matcher<? super int[]> returns(int... expected) {
        return equalTo(expected);
    }
}
