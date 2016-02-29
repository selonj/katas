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
        int i = 1;
        if (parameters.size() > i) {
            queryString += "&" + parameters.get(i).asString();
            i++;
        }
        if (parameters.size() > i) {
            queryString += "&" + parameters.get(i).asString();
        }
        return queryString;
    }

}
