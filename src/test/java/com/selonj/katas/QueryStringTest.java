package com.selonj.katas;

import org.junit.Test;

import static com.selonj.katas.QueryString.param;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-2-29.
 */
public class QueryStringTest {
    @Test
    public void singleParameter() throws Exception {
        assertThat(QueryString.within(param("key", "value")).toString(), equalTo("?key=value"));
        assertThat(QueryString.within(param("foo", "bar")).toString(), equalTo("?foo=bar"));
    }

    @Test
    public void multiParameters() throws Exception {
        assertThat(QueryString.within(param("key", "value"), param("foo", "bar")).toString(), equalTo("?key=value&foo=bar"));
        assertThat(QueryString.within(param("a", "b"), param("c", "d"), param("e", "f")).toString(), equalTo("?a=b&c=d&e=f"));
    }

    @Test
    public void withoutAnyParameters() throws Exception {
        assertThat(QueryString.withNothing().toString(), equalTo(""));
    }

    @Test
    public void parameterWithNoValue() throws Exception {
        assertThat(QueryString.within(param("key", null)).toString(), equalTo("?key="));
    }
}
