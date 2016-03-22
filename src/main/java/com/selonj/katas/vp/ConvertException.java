package com.selonj.katas.vp;

/**
 * Created by L.x on 16-3-12.
 */
public class ConvertException extends RuntimeException {
    private Class<?> targetClass;

    public ConvertException(Class<?> targetClass) {
        super("can't convert to " + targetClass.getName());
        this.targetClass = targetClass;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }
}
