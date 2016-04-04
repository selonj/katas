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

    @Test
    public void mapsAnArrayToAnotherType() throws Exception {
        Array<String> result = Array.of(1, 2, 3).map(stringify());
        assertThat(result, equalTo(Array.of("1", "2", "3")));
    }

    @Test
    public void cannotEffectedOriginalArrayWhenMappedArrayChanged() throws Exception {
        Array<Integer> original = Array.of(1, 2, 3);
        Array<Integer> result = original.map(withNoMapping());

        result.set(0, 50);

        assertThat(result.get(0), equalTo(50));
        assertThat(original.get(0), equalTo(1));
    }

    private Transformation<Integer, String> stringify() {
        return new Transformation<Integer, String>() {
            @Override
            public String transform(Integer item) {
                return item.toString();
            }
        };
    }

    private Transformation<Integer, Integer> doubleMapping() {
        return new Transformation<Integer, Integer>() {
            public Integer transform(Integer item) {
                return item * 2;
            }
        };
    }

    private Transformation<Integer, Integer> withNoMapping() {
        return null;
    }
}
