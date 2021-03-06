package com.selonj.katas;

/**
 * Created by L.x on 16-2-28.
 */
public class Version implements Comparable<Version> {
    public static final String VERSION_SEP = "\\.";
    public static final int NOTHING = 0;
    private String[] parts;

    public static Version version(String version) {
        return new Version(version);
    }

    public Version(String version) {
        this.parts = version.split(VERSION_SEP);
    }

    @Override
    public int compareTo(Version that) {
        int times = Math.max(parts.length, that.parts.length);
        for (int i = 0; i < times; i++) {
            int result = part(i).compareTo(that.part(i));
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

    private Integer part(int pos) {
        return pos < parts.length ? Integer.valueOf(parts[pos]) : NOTHING;
    }
}
