package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-2-28.
 */
public class VersionComparisonTest {
    @Test
    public void withoutMinorVersions() throws Exception {
        assertThat(Version.version("1").compareTo(Version.version("0")), equalTo(1));
        assertThat(Version.version("1").compareTo(Version.version("2")), equalTo(-1));
        assertThat(Version.version("1").compareTo(Version.version("1")), equalTo(0));
        assertThat(Version.version("11").compareTo(Version.version("9")), equalTo(1));
    }

    @Test
    public void withinSameNumberOfMinorVersions() throws Exception {
        assertThat(Version.version("1.10").compareTo(Version.version("1.01")), equalTo(1));
        assertThat(Version.version("1.10.1").compareTo(Version.version("1.10.0")), equalTo(1));
    }
}
