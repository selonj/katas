package com.selonj.katas.vp;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.selonj.katas.vp.TypeResolverGroup.builtIn;
import static com.selonj.katas.vp.TypeResolverGroup.groupOf;

/**
 * Created by L.x on 16-3-11.
 */
//todo:add Builder to build VariablePicker
public class VariablePicker {
    //todo:can use custom variable parser
    //todo: combine Converter & TypeResolver as ?Registry by using : register(String).as('string').with(Converter)
    private VariableParser variableParser;

    public VariablePicker(TypeResolver customTypeResolver) {
        TypeResolver typeResolver = groupOf(customTypeResolver, builtIn());
        variableParser = new RegexVariableParser(typeResolver, new StandardConverter());
    }

    public VariablePicker() {
        TypeResolver typeResolver = builtIn();
        variableParser = new RegexVariableParser(typeResolver, new StandardConverter());
    }

    public Set<Variable> pick(String source) {
        Set<Variable> variables = new LinkedHashSet<>();
        final Matcher matcher = Pattern.compile("\\$\\{(.*?)\\}").matcher(source);
        while (matcher.find()) {
            final String expression = matcher.group(1);
            variables.add(variableParser.parse(expression));
        }
        return variables;
    }

}
