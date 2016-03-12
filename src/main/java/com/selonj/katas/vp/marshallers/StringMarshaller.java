package com.selonj.katas.vp.marshallers;

import com.selonj.katas.vp.AbstractMarshaller;

/**
 * Created by L.x on 16-3-12.
 */
public class StringMarshaller extends AbstractMarshaller<String> {

    protected String parse(String value) {
        return value;
    }
}
