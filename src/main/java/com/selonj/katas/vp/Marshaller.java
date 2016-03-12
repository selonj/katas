package com.selonj.katas.vp;

/**
 * Created by L.x on 16-3-12.
 */
//todo: implement all built-in marshallers
public interface Marshaller<T> {
    T marshall(String value);
}
