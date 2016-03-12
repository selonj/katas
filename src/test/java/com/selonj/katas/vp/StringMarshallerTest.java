package com.selonj.katas.vp;

import com.selonj.katas.vp.marshallers.StringMarshaller;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-12.
 */
public class StringMarshallerTest {
    private StringMarshaller marshaller = new StringMarshaller();

    @Test
    public void marshall() throws Exception {
        assertThat(marshaller.marshall("foo"), equalTo("foo"));
    }
}
