package com.selonj.katas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-6.
 */
@RunWith(Parameterized.class)
public class FibonacciTest {
    private int n, expected;

    public FibonacciTest(int n, int expected) {
        this.n = n;
        this.expected = expected;
    }

    @Parameters(name = "fib({0})")
    public static Collection<Integer[]> parameters() {
        return Arrays.asList(new Integer[][]{
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3},
                {5, 5},
                {6, 8}
        });
    }

    @Test
    public void fibN() throws Exception {
        assertThat(NMath.fib(n), equalTo(expected));
    }

}
