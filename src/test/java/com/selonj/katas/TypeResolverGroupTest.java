package com.selonj.katas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by L.x on 16-3-12.
 */
@RunWith(MockitoJUnitRunner.class)
public class TypeResolverGroupTest {
    @Mock
    private TypeResolver registry1;

    @Test
    public void lookupInAddedRegistry() throws Exception {
        given(registry1.lookup("string")).willReturn(String.class);

        TypeResolverGroup group = new TypeResolverGroup();
        group.add(registry1);

        assertThat(group.lookup("string"), equalTo((Class) String.class));
    }
}
