package com.selonj.katas.vp;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

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
    public void lookupBuiltInAliases() throws Exception {
        assertThat(registry.lookup("string"), equalTo((Class) String.class));
        assertThat(registry.lookup("byte"), equalTo((Class) Byte.class));
        assertThat(registry.lookup("short"), equalTo((Class) Short.class));
        assertThat(registry.lookup("int"), equalTo((Class) Integer.class));
        assertThat(registry.lookup("long"), equalTo((Class) Long.class));
        assertThat(registry.lookup("bigint"), equalTo((Class) BigInteger.class));
        assertThat(registry.lookup("float"), equalTo((Class) Float.class));
        assertThat(registry.lookup("double"), equalTo((Class) Double.class));
        assertThat(registry.lookup("decimal"), equalTo((Class) BigDecimal.class));
        assertThat(registry.lookup("char"), equalTo((Class) Character.class));
        assertThat(registry.lookup("boolean"), equalTo((Class) Boolean.class));
        assertThat(registry.lookup("date"), equalTo((Class) Date.class));
    }
}
