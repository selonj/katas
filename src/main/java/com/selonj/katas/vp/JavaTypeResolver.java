package com.selonj.katas.vp;

/**
 * Created by L.x on 16-3-11.
 */
public class JavaTypeResolver implements TypeResolver {

    private static final JavaTypeResolver INSTANCE = new JavaTypeResolver();

    private JavaTypeResolver() {
    }

    public static JavaTypeResolver instance() {
        return INSTANCE;
    }

    @Override
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
