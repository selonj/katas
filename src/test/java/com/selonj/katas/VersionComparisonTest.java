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
        assertThat(version("1").compare(version("0")), equalTo(1));
    }
}
