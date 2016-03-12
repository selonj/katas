package com.selonj.katas.vp;

import java.util.Calendar;

/**
 * Created by L.x on 16-3-12.
 */
public class ConvertException extends RuntimeException {
    private Class<?> targetClass;

    public Class<?> getTargetClass() {
        return targetClass;
    }
}
