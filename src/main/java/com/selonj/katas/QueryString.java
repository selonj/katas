package com.selonj.katas;

/**
 * Created by L.x on 16-2-29.
 */
public class QueryString {
    public static QueryString within(Parameter parameter) {
        return new QueryString();
    }

    public String toString() {
        return "?key=value";
    }
}
