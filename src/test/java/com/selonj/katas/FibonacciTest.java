package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-6.
 */
public class FibonacciTest {
    @Test
    public void previous2() throws Exception {
        assertThat(Fib.of(1),equalTo(1));
        assertThat(Fib.of(2),equalTo(1));
    }
}
