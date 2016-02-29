package com.selonj.katas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L.x on 16-2-29.
 */
public class QueryString {
    public static final String QUERY_STRING_PREFIX = "?";
    public static final String PARAM_SEP = "&";
    private List<Component> parameters = new ArrayList<>();

    public static QueryString withNothing() {
        return new QueryString();
    }

    public static QueryString within(Component... components) {
        QueryString instance = new QueryString();

        for (Component component : components)
            component.build(instance);

        return instance;
    }

    public static Component param(String name, String value) {
        return new Parameter(name, value);
    }

    public void addParameter(Component parameter) {
        parameters.add(parameter);
    }

    public String toString() {
        if (parameters.isEmpty()) {
            return "";
        }

        String queryString = QUERY_STRING_PREFIX;
        queryString += parameters.get(0).asString();
        for (int i = 1; i < parameters.size(); i++) {
            queryString += PARAM_SEP + parameters.get(i).asString();
        }

        return queryString;
    }

    private static class Parameter implements Component {
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
            return name + "=" + (value == null ? "" : value);
        }
    }
}
