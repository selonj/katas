package com.selonj.katas.vp;

/**
 * Created by L.x on 16-3-12.
 */
//todo: can convert subtypes
public class Converter {
    //todo: convert null return null directly?
    public <T> T convert(String value, Class<T> targetType) {
        return (T) value;
    }
}
