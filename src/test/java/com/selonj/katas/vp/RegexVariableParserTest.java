package com.selonj.katas.vp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

/**
 * Created by L.x on 16-3-12.
 */
@RunWith(MockitoJUnitRunner.class)
public class RegexVariableParserTest {
    @Mock
    private TypeResolver typeResolver;
    @InjectMocks
    private VariableParser parser;

    @Test
    public void nameOnly() throws Exception {
        given(typeResolver.lookup(any(String.class))).willReturn(String.class);

        assertThat(parser.parse("foo"), equalTo(new Variable("foo", String.class)));
        assertThat(parser.parse("bar"), equalTo(new Variable("bar", String.class)));
    }

    @Test
    public void variableWithinType() throws Exception {
        given(typeResolver.lookup("date")).willReturn(Date.class);

        assertThat(parser.parse("birthday:date"), equalTo(new Variable("birthday", Date.class)));
    }

    @Test
    public void variableWithinDefaultValue() throws Exception {
        given(typeResolver.lookup(null)).willReturn(String.class);
        //todo: combine Converter & TypeResolver as ?Registry by using : register(String).as('string').with(Converter)
        assertThat(parser.parse("name?:guest"), equalTo(new Variable("name", String.class, "guest")));
    }
}
