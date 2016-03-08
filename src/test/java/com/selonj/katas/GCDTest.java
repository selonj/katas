package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-8.
 */
public class GCDTest {

    @Test
    public void GCDBetweenTwoNumbers() throws Exception {
        assertThat(NMath.gcd(1,2),equalTo(1));
    }
}
