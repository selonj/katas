package com.selonj.katas;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by L.x on 16-3-11.
 */
public class JavaTypeResolverTest {
    private TypeResolver registry = new JavaTypeResolver();

    @Test
    public void lookupNullAsStringClass() throws Exception {
        assertThat(registry.lookup(null), equalTo((Class) String.class));
    }

    @Test
    public void loadClassIfLookupTypeIsNotNull() throws Exception {
        assertThat(registry.lookup("java.util.Date"), equalTo((Class) Date.class));
    }

    @Test
    public void throwsExceptionIfTypeCannotResolved() throws Exception {
        try {
            registry.lookup("unknown type");
            fail("should raising exception");
        } catch (UnresolvedTypeException expected) {
            assertThat(expected.getMessage(), equalTo("unknown type"));
        }
    }
}
