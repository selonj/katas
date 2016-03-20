package com.selonj.katas.vp.marshallers;

import com.selonj.katas.vp.AbstractMarshaller;
import com.selonj.katas.vp.Time;

import static java.lang.Integer.parseInt;

/**
 * Created by L.x on 16-3-12.
 */
public class TimeMarshaller extends AbstractMarshaller<Time> {

    private static final int HOURS_POS = 0;
    private static final int MINUTES_POS = 1;

    @Override
    protected Time parse(String value) {
        String[] parts = value.split(":");
        return Time.at(parseInt(parts[HOURS_POS]), parseInt(parts[MINUTES_POS]));
    }
}
