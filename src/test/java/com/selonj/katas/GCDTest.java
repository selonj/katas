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
        assertThat(NMath.gcd(1, 2), equalTo(1));
        assertThat(NMath.gcd(2, 4), equalTo(2));
        assertThat(NMath.gcd(2, 1), equalTo(1));
    }

    @Test
    public void gcdGeneratedBy2Times() throws Exception {
        assertThat(NMath.gcd(6, 4), equalTo(2));
        assertThat(NMath.gcd(9, 6), equalTo(3));
    }

    @Test
    public void gcdGeneratedByMoreThan2Times() throws Exception {
//        assertThat(NMath.gcd(131, 57), equalTo(1));
    }
}
