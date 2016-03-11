package com.selonj.katas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by L.x on 16-3-12.
 */
@RunWith(Parameterized.class)
public class AllTypeRegistryOfUnresolvedTypeTest {

    private final TypeResolver registry;

    public AllTypeRegistryOfUnresolvedTypeTest(TypeResolver registry) {
        this.registry = registry;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new JavaTypeResolver()},
                {new AliasTypeRegistry()}
        });
    }

    @Test
    public void throwsExceptionIfTypeCannotResolved() throws Exception {
        try {
            registry.lookup("unknown");
            fail("should raising exception");
        } catch (UnresolvedTypeException expected) {
            assertThat(expected.getMessage(), equalTo("unknown"));
        }
    }
}
