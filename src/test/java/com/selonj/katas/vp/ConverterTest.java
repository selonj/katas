package com.selonj.katas.vp;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Created by L.x on 16-3-12.
 */
@RunWith(MockitoJUnitRunner.class)
public class ConverterTest {
    @Mock
    private Marshaller<Time> marshaller;
    @Mock
    private Marshaller<String> marshaller2;

    private Converter converter = new Converter();

    @Test
    public void convertStringToTargetType() throws Exception {
        given(marshaller.marshall("03:25")).willReturn(Time.at(3, 25));

        converter.register(Time.class, marshaller);

        assertThat(converter.convert("03:25", Time.class), equalTo(Time.at(3, 25)));
    }

    @Test
    public void convertStringToTargetTypeWithinCorrespondingMarshaller() throws Exception {
        converter.register(Time.class, marshaller);
        converter.register(String.class, marshaller2);

        converter.convert("03:25", Time.class);

        verifyZeroInteractions(marshaller2);
        verify(marshaller, only()).marshall("03:25");
    }
}
