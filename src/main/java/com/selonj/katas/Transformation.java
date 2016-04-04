package com.selonj.katas;

/**
 * Created by L.x on 16-4-4.
 */
public interface Transformation<S, T> {
    T transform(S item);
}
