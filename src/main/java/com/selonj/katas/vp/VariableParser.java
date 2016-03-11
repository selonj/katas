package com.selonj.katas.vp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by L.x on 16-3-12.
 */
public class VariableParser {
    private TypeResolver typeResolver;

    public VariableParser(TypeResolver typeResolver) {
        this.typeResolver = typeResolver;
    }

    public Variable parse(String expression) {
        //todo:trim name,type and defaultValue
        Matcher matcher = Pattern.compile("(.*?)(?:\\:(.*?))?(?:\\?\\:(.*?))?").matcher(expression);
        //todo:throw VariableParseException if can't matching
        matcher.matches();
        String name = matcher.group(1);
        String typeName = matcher.group(2);
        String defaultValue = matcher.group(3);
        return new Variable(name, typeResolver.lookup(typeName),defaultValue);
    }
}
