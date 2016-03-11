package com.selonj.katas.vp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by L.x on 16-3-12.
 */
public class VariableParser {
    private static final Pattern VARIABLE_REGEX = Pattern.compile("(.*?)(?:\\:(.*?))?(?:\\?\\:(.*?))?");
    private static final int NAME_GROUP = 1;
    private static final int TYPE_GROUP = 2;
    private static final int DEFAULT_VALUE_GROUP = 3;
    private TypeResolver typeResolver;

    public VariableParser(TypeResolver typeResolver) {
        this.typeResolver = typeResolver;
    }

    public Variable parse(String expression) {
        //todo:trim name,type and defaultValue
        Matcher matcher = VARIABLE_REGEX.matcher(expression);
        //todo:throw VariableParseException if can't matching
        matcher.matches();
        String name = matcher.group(NAME_GROUP);
        String typeName = matcher.group(TYPE_GROUP);
        String defaultValue = matcher.group(DEFAULT_VALUE_GROUP);
        return new Variable(name, typeResolver.lookup(typeName),defaultValue);
    }
}
