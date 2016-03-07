package com.selonj.katas;

import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-2-25.
 */
public class PrimeFactorsTest {
    @Test
    public void noFactors() throws Exception {
        assertThat(NMath.primeFactors(1), returnsEmptyList());
    }

    @Test
    public void primeNumbers() throws Exception {
        assertThat(NMath.primeFactors(2), returnListAs(2));
        assertThat(NMath.primeFactors(3), returnListAs(3));
    }

    @Test
    public void sameFactors() throws Exception {
        assertThat(NMath.primeFactors(4), returnListAs(2, 2));
        assertThat(NMath.primeFactors(8), returnListAs(2, 2, 2));
        assertThat(NMath.primeFactors(9), returnListAs(3, 3));
    }

    @Test
    public void diffFactors() throws Exception {
        assertThat(NMath.primeFactors(6), returnListAs(2, 3));
        assertThat(NMath.primeFactors(30), returnListAs(2, 3, 5));
    }

    private Matcher<? super List<Integer>> returnListAs(Integer... numbers) {
        return equalTo(Arrays.asList(numbers));
    }

    private Matcher<? super List<Integer>> returnsEmptyList() {
        return equalTo(Collections.<Integer>emptyList());
    }


}
