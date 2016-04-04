package com.selonj.katas;

import org.junit.Ignore;
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

    @Test
    public void returnsMappedArrayWhenMapsAnArrayWithDoubleMapping() throws Exception {
        Array<Integer> result = Array.of(1, 2, 3).map(doubleMapping());
        assertThat(result, equalTo(Array.of(2, 4, 6)));
    }

    @Test
    public void mapsAnArrayToAnotherType() throws Exception {
        Array<String> result = Array.of(1, 2, 3).map(stringify());
        assertThat(result, equalTo(Array.of("1", "2", "3")));
    }

    private Transformation<String> stringify() {
        return new Transformation<String>() {
            @Override
            public String transform(String item) {
                return null;
            }
        };
    }

    private Transformation<Integer> doubleMapping() {
        return new Transformation<Integer>() {
            public Integer transform(Integer item) {
                return item * 2;
            }
        };
    }

    private Transformation<Integer> withNoMapping() {
        return null;
    }
}
