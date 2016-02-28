package com.selonj.katas;

import org.junit.Test;

import static com.selonj.katas.Version.version;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-2-28.
 */
public class VersionComparisonTest {
    @Test
    public void withoutMinorVersions() throws Exception {
        assertThat(version("1").compareTo(version("0")), equalTo(1));
        assertThat(version("1").compareTo(version("2")), equalTo(-1));
        assertThat(version("1").compareTo(version("1")), equalTo(0));
        assertThat(version("11").compareTo(version("9")), equalTo(1));
    }

    @Test
    public void withinSameNumberOfMinorVersions() throws Exception {
        assertThat(version("1.10").compareTo(version("1.01")), equalTo(1));
        assertThat(version("1.10.1").compareTo(version("1.10.0")), equalTo(1));
    }

    @Test
    public void withinDiffNumberOfMinorVersions() throws Exception {
        assertThat(version("1").compareTo(version("1.01")), equalTo(-1));
        assertThat(version("11.0.0").compareTo(version("11")), equalTo(0));
    }
}
