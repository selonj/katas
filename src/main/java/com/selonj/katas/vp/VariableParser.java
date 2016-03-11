package com.selonj.katas.vp;

/**
 * Created by L.x on 16-3-12.
 */
public class VariableParser {
    public Variable parse(String expression) {
        String[] parts = expression.split(":");
        return new Variable(parts[0], String.class);
    }
}
