package com.selonj.katas.vp;

/**
 * Created by L.x on 16-3-12.
 */

public interface Marshaller<T> {
    T marshall(String value);
}
