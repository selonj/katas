package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-20.
 */
public class StringReversionTest {
    @Test
    public void returnDirectlyWhenReverseStringContains1Char() throws Exception {
        assertThat(Strings.reverse("a"), equalTo("a"));
        assertThat(Strings.reverse("b"), equalTo("b"));
    }

    @Test
    public void swaps2CharsWhenReverseStringContains2Chars() throws Exception {
        assertThat(Strings.reverse("ab"), equalTo("ba"));
    }

    @Test
    public void swapsTwoSidesOfCharsWhenReverseStringContainsEvenChars() throws Exception {
        assertThat(Strings.reverse("abcd"), equalTo("dcba"));
    }
}
