package test.java.net;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.verification.VerificationMode;

import java.net.*;
import java.util.*;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * Created by L.x on 16-4-2.
 */
@RunWith(MockitoJUnitRunner.class)
public class CookieManagerTest {
    @Mock
    public CookieStore store;
    @Mock
    public CookiePolicy policy;
    @InjectMocks
    public CookieManager manager;

    private URI uri = URI.create("http://www.baidu.com/search");
    private HttpCookie cookie = new HttpCookie("session_id", "uuid");

    @Test
    public void savingCookie() throws Exception {
        allowingSavingAnyCookies(true);

        manager.put(uri, cookie(cookie));

        checking(a(cookie).domain("www.baidu.com").path("/").of(uri)).saved(once());
    }

    @Test
    public void savingCookie2() throws Exception {
        allowingSavingAnyCookies(true);

        manager.put(uri, cookie2(cookie));

        checking(a(cookie).domain("www.baidu.com").path("/").of(uri)).saved(once());
    }

    @Test
    public void savingSameCookieWithDiffVersionsTwice() throws Exception {
        allowingSavingAnyCookies(true);

        manager.put(uri, headers(cookie(cookie), cookie2(cookie)));

        checking(a(cookie).domain("www.baidu.com").path("/").of(uri)).saved(twice());
    }

    @Test
    public void savingSameCookiesTwice() throws Exception {
        allowingSavingAnyCookies(true);

        manager.put(uri, headers(header("Set-Cookie", cookie, cookie)));

        checking(a(cookie).domain("www.baidu.com").path("/").of(uri)).saved(twice());
    }

    @Test
    public void thereIsNoCookiesBeSavedWhenHeadersHasNoCookies() throws Exception {
        allowingSavingAnyCookies(true);

        manager.put(uri, header("other", "value"));

        checking(anyCookies()).neverBeSaved();
    }


    @Test
    public void thereIsNoCookiesBeSavedWhenDisallowed() throws Exception {
        allowingSavingAnyCookies(false);

        manager.put(uri, cookie(cookie));

        checking(anyCookies()).neverBeSaved();
    }

    private void allowingSavingAnyCookies(boolean allowed) {
        Mockito.stub(policy.shouldAccept(any(URI.class), any(HttpCookie.class))).toReturn(allowed);
    }

    private CookieStoreVerifier checking(final CookieExpectation expectation) {
        return new CookieStoreVerifier() {
            @Override
            public void saved(VerificationMode cardinality) {
                verify(store, cardinality).add(expectation.uri(), expectation.cookie());
            }

            @Override
            public void neverBeSaved() {
                saved(never());
            }
        };
    }

    private VerificationMode once() {
        return only();
    }

    private VerificationMode twice() {
        return times(2);
    }


    private CookieExpectation anyCookies() {
        return new CookieExpectation() {
            @Override
            public HttpCookie cookie() {
                return any(HttpCookie.class);
            }

            @Override
            public URI uri() {
                return any(URI.class);
            }
        };
    }

    private CookieExpectationBuilder a(final HttpCookie cookie) {

        return new CookieExpectationBuilder() {

            private URI uri;
            private String path;
            private String domain;

            @Override
            public CookieExpectationBuilder domain(String domain) {
                this.domain = domain;
                return this;
            }

            @Override
            public CookieExpectationBuilder path(String path) {
                this.path = path;
                return this;
            }

            @Override
            public CookieExpectation of(URI uri) {
                this.uri = uri;
                return this;
            }

            @Override
            public HttpCookie cookie() {
                HttpCookie expected = (HttpCookie) cookie.clone();
                expected.setDomain(domain);
                expected.setPath(path);
                return eq(expected);
            }

            @Override
            public URI uri() {
                return eq(uri);
            }

        };
    }

    private Map<String, List<String>> cookie2(HttpCookie cookie) {
        return header("Set-Cookie2", cookie);
    }

    private Map<String, List<String>> cookie(HttpCookie cookie) {
        return header("Set-Cookie", cookie);
    }

    private Map<String, List<String>> headers(final Map<String, List<String>>... headers) {
        return new HashMap<String, List<String>>() {{
            for (Map<String, List<String>> header : headers) {
                putAll(header);
            }
        }};
    }

    private Map<String, List<String>> header(String name, Object... values) {
        return Collections.singletonMap(name, Arrays.asList(strings(values)));
    }

    private String[] strings(Object[] values) {
        String[] result = new String[values.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = values[i].toString();
        }
        return result;
    }

    private interface CookieExpectation {
        HttpCookie cookie();

        URI uri();
    }

    private interface CookieExpectationBuilder extends CookieExpectation {
        CookieExpectationBuilder domain(String domain);

        CookieExpectationBuilder path(String path);

        CookieExpectation of(URI uri);


    }

    private interface CookieStoreVerifier {
        void saved(VerificationMode cardinality);

        void neverBeSaved();
    }
}
