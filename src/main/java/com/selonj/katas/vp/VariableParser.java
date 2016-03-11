package com.selonj.katas.vp;

/**
 * Created by L.x on 16-3-12.
 */
public class VariableParser {
    private TypeResolver typeResolver;

    public VariableParser(TypeResolver typeResolver) {
        this.typeResolver = typeResolver;
    }

    public Variable parse(String expression) {
        String[] parts = expression.split(":");
        Class type = typeResolver.lookup(parts.length > 1 ? parts[1] : null);
        return new Variable(parts[0], type);
    }
}
