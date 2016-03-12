package com.selonj.katas.vp.marshallers;

import com.selonj.katas.vp.Marshaller;
import com.selonj.katas.vp.Time;

import static java.lang.Integer.parseInt;

/**
 * Created by L.x on 16-3-12.
 */
public class TimeMarshaller implements Marshaller<Time> {

    private static final int HOURS_POS = 0;
    private static final int MINUTES_POS = 1;

    @Override
    public Time marshall(String value) {
        if (value == null) {
            return null;
        }
        String[] parts = value.split(":");
        return Time.at(parseInt(parts[HOURS_POS]), parseInt(parts[MINUTES_POS]));
    }
}
