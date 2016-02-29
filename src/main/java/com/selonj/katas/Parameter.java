package com.selonj.katas;

/**
 * Created by L.x on 16-2-29.
 */
public class Parameter {
    private final String name;
    private final String value;

    public Parameter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public void build(QueryString queryString) {
        queryString.addParameter(this);
    }

    public String asString() {
        return name + "=" + value;
    }
}
