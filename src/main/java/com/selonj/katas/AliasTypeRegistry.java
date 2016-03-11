package com.selonj.katas;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by L.x on 16-3-12.
 */
public class AliasTypeRegistry implements TypeResolver {
    private Map<String, Class> registeredTypes = new HashMap<>();

    @Override
    public Class lookup(String type) {
        if (!registeredTypes.containsKey(type)) {
            throw new UnresolvedTypeException(type);
        }
        return registeredTypes.get(type);
    }

    public void alias(Class type, String alias) {
        registeredTypes.put(alias, type);
    }
}
