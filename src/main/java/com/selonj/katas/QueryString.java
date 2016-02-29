package com.selonj.katas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by L.x on 16-2-29.
 */
public class QueryString {
    public static final String QUERY_STRING_PREFIX = "?";
    public static final String PARAM_SEP = "&";
    private List<Parameter> parameters = new ArrayList<>();

    public static QueryString within(Parameter... parameters) {
        QueryString instance = new QueryString();
        instance.parameters.addAll(Arrays.asList(parameters));
        return instance;
    }

    public String toString() {
        String queryString = QUERY_STRING_PREFIX;

        queryString += parameters.get(0).asString();
        for (int i = 1; i < parameters.size(); i++) {
            queryString += PARAM_SEP + parameters.get(i).asString();
        }

        return queryString;
    }

}
