package com.selonj.katas;

import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-12.
 */
public class AliasTypeRegistryTest {

    private final AliasTypeRegistry registry = new AliasTypeRegistry();

    @Test
    public void lookupByAliasWithinCustomType() throws Exception {
        registry.alias(Object.class, "object");
        assertThat(registry.lookup("object"), equalTo((Class) Object.class));
    }

    @Test
    public void lookupByAliasWithinCustomType2() throws Exception {
        AliasTypeRegistry registry = new AliasTypeRegistry();
        registry.alias(BigInteger.class, "bigint");
        assertThat(registry.lookup("bigint"), equalTo((Class) BigInteger.class));
    }
}
