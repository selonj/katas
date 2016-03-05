package com.selonj.katas;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 2016-03-05.
 */
public class DomainTest {
    @Test
    public void domainOnly() throws Exception {
        assertThat(Domain.from("google.com").getName(), equalTo("google.com"));
        assertThat(Domain.from("baidu.com").getName(), equalTo("baidu.com"));
    }

    @Test
    public void secondaryDomain() throws Exception {
        assertThat(Domain.from("code.google.com").getName(), equalTo("google.com"));
        assertThat(Domain.from("wenku.baidu.com").getName(), equalTo("baidu.com"));
        assertThat(Domain.from("code.selonj.cn").getName(), equalTo("selonj.cn"));
    }

    @Test
    public void multiLevelDomain() throws Exception {
        assertThat(Domain.from("user.code.google.com").getName(), equalTo("google.com"));
        assertThat(Domain.from("user.wenku.baidu.com").getName(), equalTo("baidu.com"));
    }

    @Test
    public void topLevelDomainHasMultiParts() throws Exception {
        assertThat(Domain.from("sina.com.cn").getName(), equalTo("sina.com.cn"));
    }

    @Test
    public void domainFromUrl() throws Exception {
        assertThat(Domain.from("google.com/search?word=foo").getName(), equalTo("google.com"));
    }

    @Test
    public void urlWithinProtocols() throws Exception {
        assertThat(Domain.from("http://google.com/search?word=foo").getName(), equalTo("google.com"));
        assertThat(Domain.from("https://google.com/search?word=foo").getName(), equalTo("google.com"));
    }
}
