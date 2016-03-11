package com.selonj.katas;

/**
 * Created by L.x on 16-3-11.
 */
public class TypeRegistry {
    public Class lookup(String type) {
        if (type != null) {
            return loadClass(type);
        }
        return String.class;
    }

    private Class loadClass(String className) {
        try {
            return Class.forName(className, false, null);
        } catch (ClassNotFoundException ex) {
            throw new UnresolvedTypeException(className);
        }
    }
}
