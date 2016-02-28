package com.selonj.katas;

/**
 * Created by L.x on 16-2-28.
 */
public class Version implements Comparable<Version> {
    private String[] parts;

    public static Version version(String version) {
        return new Version(version);
    }

    public Version(String version) {
        this.parts = version.split("\\.");
    }

    @Override
    public int compareTo(Version that) {
        return Double.valueOf(parts[0]).compareTo(Double.valueOf(that.parts[0]));
    }
}
