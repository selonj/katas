package com.selonj.katas.tyrant;

import java.io.IOException;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-06-03.
 */
public class TyrantMapTest extends AbstractTyrantMapTest {

  @Override protected TyrantMap tyrantMap() {
    return new TyrantMap(TyrantMap.VERSION);
  }

  @Test public void retrievesValueWhenServerContainingValueByKey() throws Exception {
    server.expectsDisplaysFor("foo", "bar");

    assertThat(tyrant.get("foo"), equalTo("bar"));
  }

  @Test public void retrievesNullWhenServerNotExistingKey() throws Exception {
    server.expectsDisplaysFor("foo", null);

    assertThat(tyrant.get("foo"), is(nullValue()));
  }

  @Test public void putsValueToServerWithKey() throws Exception {
    tyrant.put("foo", "bar");

    server.hasReceivedEntry("foo", "bar");
  }

  @Test public void putsValueToServerWithNullKey() throws Exception {
    tyrant.put(null, "bar");

    server.hasReceivedEntry(null, "bar");
  }

  @Test public void putsNullValueToServerWithKey() throws Exception {
    tyrant.put("foo", null);

    server.hasReceivedEntry("foo", null);
  }

  @Test public void throwsIOExceptionWhenRetrievesValueTimeoutFromServer() throws Exception {
    server.blockingAnyRequest();

    try {
      tyrant.get("foo");
      fail("should failed");
    } catch (IOException expected) {
      assertThat(expected.getMessage(), containsString("timed out"));
    }
  }
}
