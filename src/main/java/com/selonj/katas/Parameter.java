package com.selonj.katas;

/**
 * Created by L.x on 16-2-29.
 */
public class Parameter implements Component {
    private final String name;
    private final String value;

    public Parameter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void build(QueryString queryString) {
        queryString.addParameter(this);
    }

    @Override
    public String asString() {
        return name + "=" + value;
    }
}
