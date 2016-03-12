package com.selonj.katas.vp;

import com.selonj.katas.vp.marshallers.StringMarshaller;
import com.selonj.katas.vp.marshallers.TimeMarshaller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by L.x on 16-3-12.
 */
//todo: can convert subtypes
public class StandardConverter implements Converter {
    private Map<Class<?>, Marshaller<?>> marshallers = new HashMap<>();

    public StandardConverter() {
        register(String.class, new StringMarshaller());
        register(Time.class, new TimeMarshaller());
    }

    //todo: marshall null if a marshaller registered
    @Override
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

    @Override
    public <T> void register(Class<T> type, Marshaller<T> marshaller) {
        marshallers.put(type, marshaller);
    }
}
