package com.selonj.katas.vp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Created by L.x on 16-3-12.
 */
@RunWith(MockitoJUnitRunner.class)
public class StandardConverterTest {
    @Mock
    private Marshaller<Time> timeMarshaller;
    @Mock
    private Marshaller<String> stringMarshaller;

    private Converter converter = new StandardConverter();

    @Before
    public void registerMarshallers() throws Exception {
        converter.register(Time.class, timeMarshaller);
        converter.register(String.class, stringMarshaller);
    }

    @Test
    public void convertStringToTargetType() throws Exception {
        given(timeMarshaller.marshall("03:25")).willReturn(Time.at(3, 25));

        assertThat(converter.convert("03:25", Time.class), equalTo(Time.at(3, 25)));
    }

    @Test
    public void convertStringToTargetTypeWithinCorrespondingMarshaller() throws Exception {
        converter.convert("03:25", Time.class);

        verifyZeroInteractions(stringMarshaller);
        verify(timeMarshaller, only()).marshall("03:25");
    }

    @Test
    public void throwsExceptionIfConvertSomethingAndNoMarshallerRegistered() throws Exception {
        try {
            converter.convert("03:25", Calendar.class);
            fail("should raising exception");
        } catch (ConvertException expected) {
            assertThat(expected.getTargetClass(), equalTo((Class) Calendar.class));
        }
    }

    @Test
    public void returnNullValueIfConvertNullAndNoMarshallerRegistered() throws Exception {
        assertThat(converter.convert(null, Calendar.class), nullValue());
    }

    @Test
    public void returnNullValueIfConvertNullAndMarshallerRegistered() throws Exception {
        converter.convert(null, Time.class);
        verify(timeMarshaller, only()).marshall(null);
    }
}
