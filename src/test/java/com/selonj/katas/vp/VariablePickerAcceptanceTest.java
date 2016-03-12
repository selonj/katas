package com.selonj.katas.vp;

import org.junit.Test;

import java.util.*;

import static java.util.Collections.singleton;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by L.x on 16-3-11.
 */
public class VariablePickerAcceptanceTest {
    private AliasTypeRegistry customTypeRegistry = new AliasTypeRegistry();
    private final VariablePicker picker = new VariablePicker(customTypeRegistry);

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

    @Test
    public void aVariableWithinAliasType() throws Exception {
        Set<Variable> variables = picker.pick("${name:string}");
        assertThat(variables, equalTo(singleton(new Variable("name", String.class))));
    }

    @Test
    public void aVariableWithinCustomType() throws Exception {
        customTypeRegistry.alias(Object.class, "object");
        Set<Variable> variables = picker.pick("${custom:object}");
        assertThat(variables, equalTo(singleton(new Variable("custom", Object.class))));
    }

    @Test
    public void aVariableUsingCustomTypeWithHighPriority() throws Exception {
        customTypeRegistry.alias(Integer.class, "bigint");

        Set<Variable> variables = picker.pick("${balance:bigint}");

        assertThat(variables, equalTo(singleton(new Variable("balance", Integer.class))));
    }

    @Test
    public void aVariableWithinDefaultValue() throws Exception {
        Set<Variable> variables = picker.pick("${name?:guest}");

        assertThat(variables, equalTo(singleton(new Variable("name", String.class, "guest"))));
    }

    @Test
    public void aVariableWithinDefaultValueOfCustomType() throws Exception {
        customTypeRegistry.alias(Time.class, "time");
        Set<Variable> variables = picker.pick("${start:time?:03:25}");

        assertThat(variables, equalTo(singleton(new Variable("start", Time.class, Time.at(3, 25)))));
    }

    @Test
    public void parseVariablesInOrder() throws Exception {
        customTypeRegistry.alias(Time.class, "time");

        Set<Variable> variables = picker.pick("${start:time?:03:25}${end:time?:22:10}");

        assertThat(new ArrayList<>(variables), equalTo(Arrays.asList(
                new Variable("start", Time.class, Time.at(3, 25)),
                new Variable("end", Time.class, Time.at(22, 10))
        )));
    }


}
