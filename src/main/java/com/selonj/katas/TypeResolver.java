package com.selonj.katas;

/**
 * Created by L.x on 16-3-12.
 */
public interface TypeResolver {
    Class lookup(String type) throws UnresolvedTypeException;
}
