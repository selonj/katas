package com.selonj.katas;


/**
 * Created by Administrator on 2016-03-05.
 */
public class Domain {
    private String hostName;

    public Domain(String url) {
        int index = url.indexOf('/');
        this.hostName = index != -1 ? url.substring(0, index) : url;
    }

    public static Domain from(String url) {
        return new Domain(url);
    }

    public String getName() {
        int topLevelNamePos = hostName.lastIndexOf(topLevelName());
        int primaryDomainPos = hostName.lastIndexOf('.', topLevelNamePos - 2);
        return hostName.substring(primaryDomainPos + 1);
    }

    private String topLevelName() {
        if (hostName.endsWith("com.cn"))
            return "com.cn";
        return hostName.substring(hostName.lastIndexOf('.') + 1);
    }
}
