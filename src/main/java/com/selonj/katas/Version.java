package com.selonj.katas;

/**
 * Created by L.x on 16-2-28.
 */
public class Version implements Comparable<Version> {
    private String version;

    public static Version version(String version) {
        return new Version(version);
    }

    public Version(String version) {
        this.version = version;
    }

    @Override
    public int compareTo(Version that) {
        return Double.valueOf(version).compareTo(Double.valueOf(that.version));
    }
}
