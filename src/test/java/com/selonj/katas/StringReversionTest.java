package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-20.
 */
public class StringReversionTest {
    @Test
    public void returnDirectlyWhenReverseStringContainsOneLetter() throws Exception {
        assertThat(Strings.reverse("a"), equalTo("a"));
    }
}