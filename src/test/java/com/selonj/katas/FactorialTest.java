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
        assertThat(Factorial.of(1), equalTo(1));
    }
}
