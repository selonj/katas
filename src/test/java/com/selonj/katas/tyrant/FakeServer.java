package com.selonj.katas.tyrant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 2016-06-03.
 */
public class FakeServer {

  private ServerSocket server;
  private BlockingQueue<Socket> clients = new ArrayBlockingQueue<>(1);

  private BlockingQueue<Action> actions = new ArrayBlockingQueue<>(1);
  private String version;

  public FakeServer(String version) {
    this.version = version;
  }

  public void start() throws IOException {
    server = new ServerSocket(8888);
    Thread thread = new Thread() {
      @Override public void run() {
        try {
          Socket socket = server.accept();
          clients.add(socket);
          service(new DataInputStream(socket.getInputStream()), new DataOutputStream(socket.getOutputStream()));
        } catch (EOFException ignored) {
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    };
    thread.setDaemon(true);
    thread.start();
  }

  private void service(DataInputStream in, DataOutputStream out) throws IOException {
    try {
      if(isVersionCompatible(in.readUTF())){
        skipCommand(in);
        out.writeInt(TyrantMap.STATUS_OK);
        actions.take().execute(in, out);
      }else{
        out.writeInt(TyrantMap.STATUS_BAD_VERSION);
      }
    } catch (InterruptedException e) {
      throw new Error(e);
    }
  }

  private boolean isVersionCompatible(String requestVersion) {
    return requestVersion.equals(version);
  }

  private void skipCommand(DataInputStream in) throws IOException {
    in.readInt();
  }

  public void stop() throws IOException {
    if (server != null) {
      server.close();
    }
  }

  public void hasClientConnected() throws InterruptedException {
    assertThat(clients.poll(1, TimeUnit.SECONDS), is(notNullValue()));
  }

  public void expectsDisplaysFor(final String key, final String value) {
    expects(new Action() {
      @Override public void execute(DataInputStream in, DataOutputStream out) throws IOException {
        String fetchedKey = readField(in);
        if (fetchedKey.equals(key)) writeField(out, value);
      }
    });
  }

  private void expects(Action action) {
    actions.add(action);
  }

  public void blockingAnyRequest() {
    expects(new Action() {
      @Override public void execute(DataInputStream in, DataOutputStream out) throws IOException {
      }
    });
  }

  public void hasReceivedEntry(String key, String value) throws InterruptedException {
    final BlockingQueue<Map.Entry<String, String>> requests = new ArrayBlockingQueue<>(1);
    expects(new Action() {
      @Override public void execute(DataInputStream in, DataOutputStream out) throws IOException {
        String key = readField(in);
        String value = readField(in);
        requests.add(entry(key, value));
      }
    });

    Map.Entry<String, String> fetched = requests.poll(1, TimeUnit.SECONDS);
    assertThat(fetched, equalTo(entry(key, value)));
  }

  protected String readField(DataInputStream in) throws IOException {
    return hasField(in) ? in.readUTF() : null;
  }

  private boolean hasField(DataInputStream in) throws IOException {
    return in.readInt() == TyrantMap.NOT_NULL_FIELD;
  }

  private void writeField(DataOutputStream out, String value) throws IOException {
    if (value != null) {
      out.writeInt(TyrantMap.NOT_NULL_FIELD);
      out.writeUTF(value);
    } else {
      out.writeInt(TyrantMap.NULL_FIELD);
    }
  }

  protected AbstractMap.Entry<String, String> entry(String key, String value) {
    return new AbstractMap.SimpleEntry<>(key, value);
  }

  private interface Action {
    void execute(DataInputStream in, DataOutputStream out) throws IOException;
  }
}
