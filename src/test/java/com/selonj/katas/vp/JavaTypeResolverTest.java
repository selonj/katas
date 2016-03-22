package com.selonj.katas.vp;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-11.
 */
public class JavaTypeResolverTest {
    private TypeResolver registry = JavaTypeResolver.instance();

    @Test
    public void lookupNullAsStringClass() throws Exception {
        assertThat(registry.lookup(null), equalTo((Class) String.class));
    }

    @Test
    public void loadClassIfLookupTypeIsNotNull() throws Exception {
        assertThat(registry.lookup("java.util.Date"), equalTo((Class) Date.class));
    }
}
