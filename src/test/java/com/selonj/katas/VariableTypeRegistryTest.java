package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-11.
 */
public class VariableTypeRegistryTest {
    private TypeRegistry registry = new TypeRegistry();

    @Test
    public void lookupNullAsStringClass() throws Exception {
        assertThat(registry.lookup(null),equalTo((Class) String.class));
    }
}
