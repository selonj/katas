package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-12.
 */
public class TypeResolverGroupTest {
    @Test
    public void lookup() throws Exception {
        TypeResolverGroup group = new TypeResolverGroup();
        assertThat(group.lookup("string"), equalTo((Class) String.class));
    }
}
