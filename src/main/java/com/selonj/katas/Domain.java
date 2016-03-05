package com.selonj.katas;


/**
 * Created by Administrator on 2016-03-05.
 */
public class Domain {
    private String url;

    public Domain(String url) {
        this.url = url;
    }

    public static Domain from(String url) {
        return new Domain(url);
    }

    public String getName() {
        String[] parts = url.split("\\.");
        int last = parts.length - 1;
        return parts[last - 1] + '.' + parts[last];
    }
}
