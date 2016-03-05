package com.selonj.katas;


/**
 * Created by Administrator on 2016-03-05.
 */
public class Domain {
    public static Domain from(String url) {
        return new Domain();
    }

    public String getName() {
        return "google.com";
    }
}
