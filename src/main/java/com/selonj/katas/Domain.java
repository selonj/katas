package com.selonj.katas;


/**
 * Created by Administrator on 2016-03-05.
 */
public class Domain {
    public static final String HTTP_PROTOCOL = "http://";
    public static final String HTTPS_PROTOCOL = "https://";
    private String hostName;

    public Domain(String url) {
        url = dropProtocol(url);
        int index = url.indexOf('/');
        this.hostName = index != -1 ? url.substring(0, index) : url;
    }

    private String dropProtocol(String url) {
        if (url.startsWith(HTTP_PROTOCOL))
            return url.substring(HTTP_PROTOCOL.length());
        if (url.startsWith(HTTPS_PROTOCOL))
            return url.substring(HTTPS_PROTOCOL.length());
        return url;
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
