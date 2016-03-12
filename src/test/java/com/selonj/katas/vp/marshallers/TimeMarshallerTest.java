package com.selonj.katas.vp.marshallers;

import com.selonj.katas.vp.Time;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-12.
 */
public class TimeMarshallerTest {
    private TimeMarshaller marshaller = new TimeMarshaller();

    @Test
    public void marshall() throws Exception {
        assertThat(marshaller.marshall("13:30"), equalTo(Time.at(13, 30)));
    }
}
