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
        final Matcher matcher = Pattern.compile("\\$\\{(.*?)\\}").matcher(source);
        if (matcher.find()) {
            final String expression = matcher.group(1);
            variables.add(resolveVariable(expression));
        }
        return variables;
    }

    private Variable resolveVariable(final String expression) {
        return new Variable() {{
            name = expression;
            type = String.class;
        }};
    }
}
