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
        assertThat(Factorial.factorial(1), equalTo(1));
        assertThat(Factorial.factorial(2), equalTo(2));
        assertThat(Factorial.factorial(3), equalTo(6));
        assertThat(Factorial.factorial(4), equalTo(24));
    }
}
