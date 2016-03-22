package com.selonj.katas.vp;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-12.
 */
public class StandardConverterWithinBuiltInMarshallersTest {
    @Test
    public void convertStringToBuiltInTypes() throws Exception {
        //todo: implement all built-in marshallers
        Converter converter = new StandardConverter();
        assertThat(converter.convert("foo", String.class), equalTo("foo"));
        assertThat(converter.convert("03:25", Time.class), equalTo(Time.at(3, 25)));
    }
}
