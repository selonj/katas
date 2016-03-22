package com.selonj.katas.vp;

import java.util.Objects;

/**
 * Created by L.x on 16-3-11.
 */
public class Variable<T> {
    public String name;
    public Class<T> type;
    private T defaultValue;

    public Variable(String name, Class type) {
        this.name = name;
        this.type = type;
    }

    public Variable(String name, Class<T> type, T defaultValue) {
        this.name = name;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable<?> variable = (Variable<?>) o;
        return Objects.equals(name, variable.name) &&
                Objects.equals(type, variable.type) &&
                Objects.equals(defaultValue, variable.defaultValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, defaultValue);
    }

    @Override
    public String toString() {
        return name + ":" + type.getName()+"?:"+defaultValue;
    }
}
