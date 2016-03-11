package com.selonj.katas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L.x on 16-3-12.
 */
public class TypeResolverGroup implements TypeResolver {
    private TypeResolver resolver;
    private List<TypeResolver> resolvers = new ArrayList<>();

    @Override
    public Class lookup(String type) throws UnresolvedTypeException {
        for (TypeResolver resolver : resolvers) {
            try {
                return resolver.lookup(type);
            } catch (UnresolvedTypeException skipped) {
            }
        }
        return resolver.lookup(type);
    }

    public void add(TypeResolver resolver) {
        resolvers.add(resolver);
    }
}
