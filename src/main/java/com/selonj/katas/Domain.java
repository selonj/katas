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
        int topLevelNamePos = url.lastIndexOf(topLevelName());
        int primaryDomainPos = url.lastIndexOf('.', topLevelNamePos - 2);
        return url.substring(primaryDomainPos + 1);
    }

    private String topLevelName() {
        return "com";
    }
}
