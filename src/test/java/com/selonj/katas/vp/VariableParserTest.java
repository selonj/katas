package com.selonj.katas.vp;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-12.
 */
public class VariableParserTest {
    private VariableParser parser = new VariableParser();

    @Test
    public void nameOnly() throws Exception {
        assertThat(parser.parse("foo"), equalTo(new Variable("foo", String.class)));
        assertThat(parser.parse("bar"), equalTo(new Variable("bar", String.class)));
    }

    @Test
    public void variableWithinType() throws Exception {
        assertThat(parser.parse("name:string"), equalTo(new Variable("name", String.class)));
        assertThat(parser.parse("birthday:date"), equalTo(new Variable("birthday", Date.class)));
    }
}
