package com.selonj.katas;

import java.util.Objects;

/**
 * Created by L.x on 16-3-11.
 */
public class Variable {
    public String name;
    public Class type;

    public Variable(String name, Class type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!Variable.class.isInstance(o)) return false;
        Variable variable = (Variable) o;
        return Objects.equals(name, variable.name) &&
                Objects.equals(type, variable.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return name + ":" + type.getName();
    }
}
