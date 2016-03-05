package com.selonj.katas;


/**
 * Created by Administrator on 2016-03-05.
 */
public class Domain {
    public static final char PATH_SEP = '/';
    public static final char DOMAIN_SEP = '.';
    private String hostName;

    public static Domain from(String url) {
        return new Domain(url);
    }

    public Domain(String url) {
        this.hostName = dropUri(dropProtocol(url));
    }

    private String dropProtocol(String url) {
        for (Scheme candidate : Scheme.values()) {
            if (candidate.include(url)) {
                return candidate.truncate(url);
            }
        }
        return url;
    }

    private String dropUri(String url) {
        int index = url.indexOf(PATH_SEP);
        return index != -1 ? url.substring(0, index) : url;
    }

    public String getName() {
        int frontOfTopLevelNameSepPos = hostName.length() - topLevelName().length() - 1 - 1;
        int start = hostName.lastIndexOf(DOMAIN_SEP, frontOfTopLevelNameSepPos);
        return hostName.substring(start + 1);
    }

    private String topLevelName() {
        String topLevelName = "com.cn";
        if (hostName.endsWith(topLevelName))
            return topLevelName;
        return hostName.substring(hostName.lastIndexOf(DOMAIN_SEP) + 1);
    }

    private enum Scheme {
        HTTP,
        HTTPS;

        private static final String SUFFIX = "://";

        public String protocol() {
            return name().toLowerCase() + SUFFIX;
        }

        private boolean include(String url) {
            return url.startsWith(protocol());
        }

        private String truncate(String url) {
            return url.substring(protocol().length());
        }
    }
}
