package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-7.
 */
public class FactorialTest {
    @Test
    public void factorial() throws Exception {
        assertThat(NMath.factorial(1), equalTo(1));
        assertThat(NMath.factorial(2), equalTo(2));
        assertThat(NMath.factorial(3), equalTo(6));
        assertThat(NMath.factorial(4), equalTo(24));
    }
}
