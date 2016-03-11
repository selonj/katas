package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-12.
 */
public class AliasTypeRegistryTest {
    @Test
    public void lookupByAliasWithinCustomType() throws Exception {
        AliasTypeRegistry registry = new AliasTypeRegistry();
        registry.alias(Object.class, "object");
        assertThat(registry.lookup("object"),equalTo((Class) Object.class));
    }
}
