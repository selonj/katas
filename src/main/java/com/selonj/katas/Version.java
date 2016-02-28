package com.selonj.katas;

/**
 * Created by L.x on 16-2-28.
 */
public class Version implements Comparable<Version> {
    public static final String VERSION_SEP = "\\.";
    private String[] parts;

    public static Version version(String version) {
        return new Version(version);
    }

    public Version(String version) {
        this.parts = version.split(VERSION_SEP);
    }

    @Override
    public int compareTo(Version that) {
        int i = 0;
        int result = Double.valueOf(parts[i]).compareTo(Double.valueOf(that.parts[i]));
        i++;
        if (result == 0 && parts.length > 1) {
            result = Double.valueOf(parts[i]).compareTo(Double.valueOf(that.parts[i]));
        }
        return result;
    }
}
