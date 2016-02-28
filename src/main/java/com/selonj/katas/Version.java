package com.selonj.katas;

/**
 * Created by L.x on 16-2-28.
 */
public class Version implements Comparable<Version> {
    private String version;

    public Version(String version) {

        this.version = version;
    }

    @Override
    public int compareTo(Version that) {
        return version.compareTo(that.version);
    }
}
