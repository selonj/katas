package com.selonj.katas.vp;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import static java.util.Collections.singleton;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by L.x on 16-3-11.
 */
public class VariablePickerTest {
    private AliasTypeRegistry customTypeRegistry = new AliasTypeRegistry();
    private final VariablePicker picker = new VariablePicker(customTypeRegistry);

    @Test
    public void emptyString() throws Exception {
        Set<Variable> variables = picker.pick("");
        assertTrue(variables.isEmpty());
    }

    @Test
    public void aVariable() throws Exception {
        Set<Variable> variables = picker.pick("${name}");
        assertThat(variables, equalTo(singleton(new Variable("name", String.class))));
    }

    @Test
    public void aVariableWithinOtherType() throws Exception {
        Set<Variable> variables = picker.pick("${date:java.util.Date}");
        assertThat(variables, equalTo(singleton(new Variable("date", Date.class))));
    }

    @Test
    public void aVariableWithinAliasType() throws Exception {
        Set<Variable> variables = picker.pick("${name:string}");
        assertThat(variables, equalTo(singleton(new Variable("name", String.class))));
    }

    @Test
    public void aVariableWithinCustomType() throws Exception {
        customTypeRegistry.alias(Object.class, "object");
        Set<Variable> variables = picker.pick("${custom:object}");
        assertThat(variables, equalTo(singleton(new Variable("custom", Object.class))));
    }

    @Test
    public void aVariableUsingCustomTypeWithHighPriority() throws Exception {
        customTypeRegistry.alias(Integer.class, "bigint");

        Set<Variable> variables = picker.pick("${balance:bigint}");

        assertThat(variables, equalTo(singleton(new Variable("balance", Integer.class))));
    }

    @Test
    public void aVariableWithinDefaultValue() throws Exception {
        Set<Variable> variables = picker.pick("${name?:guest}");

        assertThat(variables, equalTo(singleton(new Variable("name", String.class, "guest"))));
    }

    @Test
    public void aVariableWithinDefaultValueOfCustomType() throws Exception {
        customTypeRegistry.alias(Time.class, "time");
        Set<Variable> variables = picker.pick("${start:time?:03:25}");

        assertThat(variables, equalTo(singleton(new Variable("start", Time.class, Time.at(3, 25)))));
    }


    private static class Time {
        private int hours;
        private int minutes;

        public Time(int hours, int minutes) {
            this.hours = hours;
            this.minutes = minutes;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Time time = (Time) o;
            return hours == time.hours &&
                    minutes == time.minutes;
        }

        @Override
        public int hashCode() {
            return Objects.hash(hours, minutes);
        }

        public static Time at(int hours, int minutes) {
            return new Time(hours, minutes);
        }

        @Override
        public String toString() {
            return "at " + hours + ":" + minutes;
        }
    }
}
