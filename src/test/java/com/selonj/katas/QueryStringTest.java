package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-2-29.
 */
public class QueryStringTest {
    @Test
    public void singleParameter() throws Exception {
        assertThat(QueryString.within(param("key", "value")).toString(), equalTo("?key=value"));
    }

    private Parameter param(String name, String value) {
        return null;
    }
}
