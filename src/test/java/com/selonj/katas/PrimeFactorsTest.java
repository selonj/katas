package com.selonj.katas;

import org.hamcrest.Matcher;
import org.junit.Test;

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
        assertThat(PrimeFactors.of(1), returnsEmptyList());
    }

    private Matcher<? super List<Integer>> returnsEmptyList() {
        return equalTo(Collections.<Integer>emptyList());
    }


}
