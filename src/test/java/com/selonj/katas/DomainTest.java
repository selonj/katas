package com.selonj.katas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 2016-03-05.
 */
public class DomainTest {
    @Test
    public void domainOnly() throws Exception {
        assertThat(Domain.from("google.com").getName(),equalTo("google.com"));
        assertThat(Domain.from("baidu.com").getName(),equalTo("baidu.com"));
    }
}
