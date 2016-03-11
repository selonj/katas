package com.selonj.katas;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by L.x on 16-3-12.
 */
public class AliasTypeRegistry implements TypeResolver {
    private Map<String, Class> registeredTypes = new HashMap<>();

    public AliasTypeRegistry() {
        registerBuiltInAliases();
    }

    private void registerBuiltInAliases() {
        alias(String.class, "string");
        alias(Byte.class, "byte");
        alias(Short.class, "short");
        alias(Integer.class, "int");
        alias(Long.class, "long");
        alias(Float.class, "float");
        alias(Double.class, "double");
        alias(BigInteger.class, "bigint");
        alias(BigDecimal.class, "decimal");
        alias(Boolean.class, "boolean");
        alias(Character.class, "char");
        alias(Date.class, "date");
    }

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
