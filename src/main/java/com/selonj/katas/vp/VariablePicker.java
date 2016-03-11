package com.selonj.katas.vp;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.selonj.katas.vp.TypeResolverGroup.builtIn;
import static com.selonj.katas.vp.TypeResolverGroup.groupOf;

/**
 * Created by L.x on 16-3-11.
 */
public class VariablePicker {
    public static final int NAME_POS = 0;
    public static final int TYPE_POS = 1;
    private TypeResolver typeResolver;

    public VariablePicker(TypeResolver customTypeResolver) {
        typeResolver = groupOf(customTypeResolver, builtIn());
    }

    public VariablePicker() {
        typeResolver = builtIn();
    }

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
        String[] parts = expression.split(":");
        Class type = typeResolver.lookup(parts.length > 1 ? parts[TYPE_POS] : null);
        return new Variable(parts[NAME_POS], type);
    }
}
