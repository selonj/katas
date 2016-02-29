package com.selonj.katas;

/**
 * Created by L.x on 16-2-29.
 */
public class QueryString {
    private Parameter parameter;

    public static QueryString within(Parameter parameter) {
        QueryString instance = new QueryString();
        instance.parameter = parameter;
        return instance;
    }

    public String toString() {
        return "?" + "key" + "=" + "value";
    }
}
