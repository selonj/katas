package com.selonj.katas;

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
}
