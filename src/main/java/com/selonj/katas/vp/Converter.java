package com.selonj.katas.vp;

import com.selonj.katas.vp.marshallers.StringMarshaller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by L.x on 16-3-12.
 */
//todo: can convert subtypes
public class Converter {
    private Map<Class<?>, Marshaller<?>> marshallers = new HashMap<>();

    public Converter() {
        register(String.class, new StringMarshaller());
    }

    //todo: convert null return null directly?
    public <T> T convert(String value, Class<T> targetType) {
        Marshaller<T> marshaller = (Marshaller<T>) marshallers.get(targetType);
        if (marshaller != null) {
            return marshaller.marshall(value);
        }
        if (value == null) {
            return null;
        }
        throw new ConvertException(targetType);
    }

    public <T> void register(Class<T> type, Marshaller<T> marshaller) {
        marshallers.put(type, marshaller);
    }
}
