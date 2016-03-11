package com.selonj.katas.vp;

import org.junit.Test;

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
    }
}
