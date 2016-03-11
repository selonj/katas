package com.selonj.katas;

import org.junit.Test;

import java.util.Set;

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
}
