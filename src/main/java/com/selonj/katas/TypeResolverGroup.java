package com.selonj.katas;

/**
 * Created by L.x on 16-3-12.
 */
public class TypeResolverGroup implements TypeResolver {
    private TypeResolver resolver;

    @Override
    public Class lookup(String type) throws UnresolvedTypeException {
        return resolver.lookup(type);
    }

    public void add(TypeResolver resolver) {
        this.resolver = resolver;
    }
}
