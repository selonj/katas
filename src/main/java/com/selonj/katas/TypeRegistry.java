package com.selonj.katas;

/**
 * Created by L.x on 16-3-11.
 */
public class TypeRegistry {
    public Class lookup(String type) {
        if (type != null) {
            try {
                return Class.forName(type, false, null);
            } catch (ClassNotFoundException ex) {
            }
        }
        return String.class;
    }
}
