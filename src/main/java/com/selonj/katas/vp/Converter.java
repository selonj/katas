package com.selonj.katas.vp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by L.x on 16-3-12.
 */
//todo: can convert subtypes
public class Converter {
    private Map<Class<?>, Marshaller<?>> marshallers = new HashMap<>();

    //todo: convert null return null directly?
    public <T> T convert(String value, Class<T> targetType) {
        Marshaller<T> marshaller = (Marshaller<T>) marshallers.get(targetType);
        if (marshaller == null) {
            throw new ConvertException();
        }
        return (T) marshaller.marshall(value);
    }

    public <T> void register(Class<T> type, Marshaller<T> marshaller) {
        marshallers.put(type, marshaller);
    }
}
