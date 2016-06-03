package com.selonj.katas.tyrant;

import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-06-03.
 */
public class TyrantMapIncompatibleVersionTest extends AbstractTyrantMapTest {

  protected TyrantMap tyrantMap() {
    return new TyrantMap("2.0");
  }

  @Test public void reportsErrorWhenRetrievesValueWithBadVersion() throws Exception {
    try {
      tyrant.get("foo");
      fail("should failed");
    } catch (BadVersionException expected) {
    }
  }

  @Test public void reportsErrorWhenPutValueWithBadVersion() throws Exception {
    try {
      tyrant.put("foo", "bar");
      fail("should failed");
    } catch (BadVersionException expected) {
    }
  }
}
