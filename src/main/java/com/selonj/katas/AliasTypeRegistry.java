package com.selonj.katas;

/**
 * Created by L.x on 16-3-12.
 */
public class AliasTypeRegistry implements TypeResolver {
    @Override
    public Class lookup(String type) {
        return Object.class;
    }

    public void alias(Class type, String alias) {
    }
}
