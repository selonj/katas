package com.selonj.katas;

import org.hamcrest.core.Every;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

import static java.util.Collections.singleton;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by L.x on 16-3-11.
 */
public class VariablePickerTest {

    private final VariablePicker picker = new VariablePicker();

    @Test
    public void emptyString() throws Exception {
        Set<Variable> variables = picker.pick("");
        assertTrue(variables.isEmpty());
    }

    @Test
    public void aVariable() throws Exception {
        Set<Variable> variables = picker.pick("${name}");
        assertThat(variables, equalTo(singleton(new Variable("name", String.class))));
    }

    @Test
    public void aVariableWithinOtherType() throws Exception {
        Set<Variable> variables = picker.pick("${date:java.util.Date}");
        assertThat(variables, equalTo(singleton(new Variable("date", Date.class))));
    }

}
