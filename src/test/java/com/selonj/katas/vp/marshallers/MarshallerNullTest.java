package com.selonj.katas.vp.marshallers;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-12.
 */
public class MarshallerNullTest {
    @Test
    public void marshallNullAsString() throws Exception {
        StringMarshaller marshaller = new StringMarshaller();
        assertThat(marshaller.marshall(null), equalTo(null));
    }

    @Test
    public void marshallNullAsTime() throws Exception {
        TimeMarshaller marshaller = new TimeMarshaller();
        assertThat(marshaller.marshall(null), equalTo(null));
    }
}
