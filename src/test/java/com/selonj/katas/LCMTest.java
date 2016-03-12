package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 2016-03-09.
 */
public class LCMTest {
    @Test
    public void noGCD() throws Exception {
        assertThat(NMath.lcm(2, 3), equalTo(6));
        assertThat(NMath.lcm(3, 5), equalTo(15));
    }

    @Test
    public void haveGCD() throws Exception {
        assertThat(NMath.lcm(6, 4), equalTo(12));
    }
}
