package com.selonj.katas;

import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by L.x on 16-3-11.
 */
public class VariablePickerTest {
    @Test
    public void emptyString() throws Exception {
        VariablePicker picker = new VariablePicker();
        Set<Variable> variables = picker.pick("");
        assertTrue(variables.isEmpty());
    }

    @Test
    public void aVariable() throws Exception {
        VariablePicker picker = new VariablePicker();
        Set<Variable> variables = picker.pick("${name}");
        assertThat(variables.size(), is(1));
        Variable variable = variables.iterator().next();
        assertThat(variable.name, equalTo("name"));
    }

    @Test
    public void aVariable2() throws Exception {
        VariablePicker picker = new VariablePicker();
        Set<Variable> variables = picker.pick("${foo}");
        assertThat(variables.size(), is(1));
        Variable variable = variables.iterator().next();
        assertThat(variable.name, equalTo("foo"));
    }
}
