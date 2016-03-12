package com.selonj.katas.vp;

import com.selonj.katas.vp.utils.Trimming;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by L.x on 16-3-12.
 */
public class RegexVariableParser implements VariableParser {
    private static final Pattern VARIABLE_REGEX = Pattern.compile("(.*?)(?:\\:(.*?))?(?:\\?\\:(.*?))?");
    private static final int NAME_GROUP = 1;
    private static final int TYPE_GROUP = 2;
    private static final int DEFAULT_VALUE_GROUP = 3;
    private TypeResolver typeResolver;
    private Converter converter;

    public RegexVariableParser(TypeResolver typeResolver, Converter converter) {
        this.typeResolver = typeResolver;
        this.converter = converter;
    }

    @Override
    public Variable parse(String expression) {
        Matcher matcher = VARIABLE_REGEX.matcher(expression);
        //todo:throw VariableParseException if can't matching
        matcher.matches();
        String name = Trimming.on(matcher.group(NAME_GROUP));
        String typeName = Trimming.on(matcher.group(TYPE_GROUP));
        String defaultValue = Trimming.on(matcher.group(DEFAULT_VALUE_GROUP));
        Class type = typeResolver.lookup(typeName);
        return new Variable(name, type, converter.convert(defaultValue, type));
    }
}
