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

    public <O> Array<O> map(Transformation<T, O> transformation) {
        if (transformation == null) {
            return (Array<O>) this;
        }
        O[] mappedArray = (O[]) new Object[items.length];
        for (int i = 0; i < items.length; i++) {
            mappedArray[i] = transformation.transform(items[i]);
        }
        return Array.of(mappedArray);
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


    public void set(int index, T value) {
        items[index] = value;
    }


    public T get(int index) {
        return items[index];
    }
}
