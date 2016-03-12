package com.selonj.katas.vp;

/**
 * Created by L.x on 16-3-12.
 */
//todo: can convert subtypes
public class Converter {
    private Marshaller marshaller;

    //todo: convert null return null directly?
    public <T> T convert(String value, Class<T> targetType) {
        return (T) marshaller.marshall(value);
    }

    public <T> void register(Class<T> type, Marshaller<T> marshaller) {

        this.marshaller = marshaller;
    }
}
