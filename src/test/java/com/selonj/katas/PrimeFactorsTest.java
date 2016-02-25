package com.selonj.katas;

import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-2-25.
 */
public class PrimeFactorsTest {
    @Test
    public void noFactors() throws Exception {
        assertThat(PrimeFactors.of(1), returnsEmptyList());
    }
}
