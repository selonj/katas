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
        assertThat(QueryString.within(QueryString.param("key", "value")).toString(), equalTo("?key=value"));
        assertThat(QueryString.within(QueryString.param("foo", "bar")).toString(), equalTo("?foo=bar"));
    }

    @Test
    public void multiParameters() throws Exception {
        assertThat(QueryString.within(QueryString.param("key", "value"), QueryString.param("foo", "bar")).toString(), equalTo("?key=value&foo=bar"));
        assertThat(QueryString.within(QueryString.param("a", "b"), QueryString.param("c", "d"), QueryString.param("e", "f")).toString(), equalTo("?a=b&c=d&e=f"));
    }

    @Test
    public void withoutAnyParameters() throws Exception {
        assertThat(QueryString.withNothing().toString(),equalTo(""));
    }

}
