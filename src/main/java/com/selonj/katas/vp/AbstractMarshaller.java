package com.selonj.katas.vp;

/**
 * Created by L.x on 16-3-12.
 */
public abstract class AbstractMarshaller<T> implements Marshaller<T> {
    @Override
    public T marshall(String value) {
        if (value == null) {
            return null;
        }
        return parse(value);
    }

    protected abstract T parse(String value);
}
