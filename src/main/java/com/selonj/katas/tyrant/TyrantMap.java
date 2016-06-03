package com.selonj.katas.tyrant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Administrator on 2016-06-03.
 */
public class TyrantMap {

  public static final int COMMAND_GET = 0x1;
  public static final int COMMAND_PUT = 0x10;
  public static final int NULL_FIELD = -1;
  public static final int NOT_NULL_FIELD = 0;
  public static final String VERSION = "1.0";
  public static final int STATUS_BAD_VERSION = 100;
  public static final int STATUS_OK = 0;

  private Socket endpoint;
  private DataInputStream in;
  private DataOutputStream out;
  private String version;

  public TyrantMap() {
    this(VERSION);
  }

  public TyrantMap(String version) {
    this.version = version;
  }

  public void open() throws IOException {
    endpoint = new Socket("localhost", 8888);
    endpoint.setSoTimeout(1000);
    in = new DataInputStream(endpoint.getInputStream());
    out = new DataOutputStream(endpoint.getOutputStream());
  }

  public String get(String key) throws IOException {
    send(COMMAND_GET, key);
    return readValue();
  }

  private String readValue() throws IOException {
    return hasValue() ? null : in.readUTF();
  }

  private boolean hasValue() throws IOException {
    return in.readInt() == NULL_FIELD;
  }

  public void put(String key, String value) throws IOException {
    send(COMMAND_PUT, key, value);
  }

  private void writeField(String field) throws IOException {
    if (requiresField(field)) out.writeUTF(field);
  }

  private boolean requiresField(String field) throws IOException {
    if (field == null) {
      out.writeInt(NULL_FIELD);
      return false;
    } else {
      out.writeInt(NOT_NULL_FIELD);
      return true;
    }
  }

  private void send(int command, String... fields) throws IOException {
    request(command, fields);
    checkStatus();
  }

  private void request(int command, String[] fields) throws IOException {
    out.writeUTF(version);
    out.writeInt(command);
    for (String field : fields) writeField(field);
    out.flush();
  }

  private void checkStatus() throws IOException {
    int status = in.readInt();
    if (status == STATUS_BAD_VERSION) {
      throw new BadVersionException();
    }
  }

  public void close() {
    if (endpoint != null) {
      try {
        endpoint.close();
      } catch (IOException ignored) {
      }
    }
  }
}
