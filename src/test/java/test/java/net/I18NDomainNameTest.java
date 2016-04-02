package test.java.net;

import org.junit.Test;

import java.net.IDN;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-4-2.
 */
public class I18NDomainNameTest {
    @Test
    public void toAscii() throws Exception {
        assertThat(IDN.toASCII("www.中文.com"), equalTo("www.xn--fiq228c.com"));
        assertThat(IDN.toASCII("www.java.com"), equalTo("www.java.com"));
        assertThat(IDN.toASCII("www./?&#%-%.com"), equalTo("www./?&#%-%.com"));
    }

    @Test
    public void toUnicode() throws Exception {
        assertThat(IDN.toUnicode("www.中文.com"), equalTo("www.中文.com"));
        assertThat(IDN.toUnicode("www.java.com"), equalTo("www.java.com"));
        assertThat(IDN.toUnicode("www./?&#%-%.com"), equalTo("www./?&#%-%.com"));
    }
}
