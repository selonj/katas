package com.selonj.katas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by L.x on 16-2-29.
 */
public class QueryString {
    private List<Parameter> parameters = new ArrayList<>();

    public static QueryString within(Parameter... parameters) {
        QueryString instance = new QueryString();
        instance.parameters.addAll(Arrays.asList(parameters));
        return instance;
    }

    public String toString() {
        String queryString = "?";
        queryString += parameters.get(0).asString();
        if (parameters.size() > 1) {
            queryString += "&" + parameters.get(1).asString();
        }
        return queryString;
    }

}
