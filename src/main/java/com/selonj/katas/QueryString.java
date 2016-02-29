package com.selonj.katas;

/**
 * Created by L.x on 16-2-29.
 */
public class QueryString {
    private Parameter parameter;

    public static QueryString within(Parameter... parameters) {
        QueryString instance = new QueryString();
        instance.parameter = parameters[0];
        return instance;
    }

    public String toString() {
        return "?" + parameter.asString();
    }

}
