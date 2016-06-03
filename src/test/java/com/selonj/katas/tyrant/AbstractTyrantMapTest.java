package com.selonj.katas.tyrant;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 * Created by Administrator on 2016-06-03.
 */
public abstract class AbstractTyrantMapTest {
  @Rule
  public final Timeout timeout = Timeout.millis(1100);
  protected final TyrantMap tyrant = tyrantMap();
  protected final FakeServer server = new FakeServer(TyrantMap.VERSION);

  protected abstract TyrantMap tyrantMap();

  @Before public void connect() throws Exception {
    server.start();

    tyrant.open();

    server.hasClientConnected();
  }

  @After public void stopServer() throws Exception {
    server.stop();
  }

  @After public void closeTyrantMap() throws Exception {
    tyrant.close();
  }
}
