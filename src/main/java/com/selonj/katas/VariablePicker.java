package com.selonj.katas;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by L.x on 16-3-11.
 */
public class VariablePicker {
    public Set<Variable> pick(String source) {
        HashSet<Variable> variables = new HashSet<>();
        if (!source.isEmpty()) {
            variables.add(new Variable() {{
                name = "name";
            }});
        }
        return variables;
    }
}
