package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-4-4.
 */
public class ArrayMappingTest {
    @Test
    public void clonesAnArrayWhenMapsAnArrayWithNoMapping() throws Exception {
        Array<Integer> result = Array.of(1, 2, 3).map(withNoMapping());
        assertThat(result, equalTo(Array.of(1, 2, 3)));
    }

    private Transformation<Integer> withNoMapping() {
        return null;
    }
}
