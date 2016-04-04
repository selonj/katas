package com.selonj.katas;

import java.util.Arrays;

/**
 * Created by L.x on 16-4-4.
 */
public class Array<T> {
    private T[] items;

    public Array(T[] items) {
        this.items = items;
    }

    public static <T> Array<T> of(T... items) {
        return new Array<>(items);
    }

    public Array<T> map(Transformation<T> transformation) {
        return this;
    }

    public T[] toArray() {
        return items;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Array) {
            Array that = (Array) obj;
            return Arrays.equals(items, that.items);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(items);
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
