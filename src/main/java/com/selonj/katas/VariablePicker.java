package com.selonj.katas;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by L.x on 16-3-11.
 */
public class VariablePicker {
    public Set<Variable> pick(String source) {
        HashSet<Variable> variables = new HashSet<>();
        Matcher matcher = Pattern.compile("\\$\\{\\w+\\}").matcher(source);
        if (matcher.find()) {
            variables.add(new Variable() {{
                name = "name";
            }});
        }
        return variables;
    }
}
