package com.selonj.katas.vp.marshallers;

import com.selonj.katas.vp.AbstractMarshaller;

/**
 * Created by L.x on 16-3-12.
 */
public class StringMarshaller extends AbstractMarshaller<String> {
    public String marshall(String value) {
        if (value == null) {
            return null;
        }
        return value;
    }
}
