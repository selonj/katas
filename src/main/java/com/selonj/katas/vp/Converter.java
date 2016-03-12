package com.selonj.katas.vp;

/**
 * Created by L.x on 16-3-12.
 */
public interface Converter {
    //todo: marshall null if a marshaller registered
    <T> T convert(String value, Class<T> targetType);

    <T> void register(Class<T> type, Marshaller<T> marshaller);
}
