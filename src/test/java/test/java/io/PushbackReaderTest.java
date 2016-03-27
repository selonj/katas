package test.java.io;

import org.junit.Test;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by L.x on 16-3-27.
 */
public class PushbackReaderTest {

    private final PushbackReader reader = new PushbackReader(new StringReader("java io"));

    @Test
    public void doesNotSupportReset() throws Exception {
        try {
            reader.reset();
            fail("should failed");
        } catch (IOException expected) {
            assertThat(expected.getMessage(), equalTo("mark/reset not supported"));
        }
    }

    @Test
    public void doesNotSupportMark() throws Exception {
        try {
            reader.mark(1);
            fail("should failed");
        } catch (IOException expected) {
            assertThat(expected.getMessage(), equalTo("mark/reset not supported"));
        }
    }

    @Test
    public void pushesCharsBackToStreamEvenIfCharsNotPresentsInStream() throws Exception {
        reader.unread('n');//push back some chars not in stream

        assertEquals('n', reader.read());
    }

    @Test
    public void supportsSkippingChars() throws Exception {
        reader.skip(1);
        assertEquals('a', reader.read());

        reader.skip(Integer.MAX_VALUE);
        assertEquals(-1, reader.read());
    }

    @Test
    public void failsOnReadyWhenStreamClosed() throws Exception {
        assertTrue(reader.ready());
        reader.close();

        try {
            reader.ready();
            fail("should failed");
        } catch (IOException expected) {
            assertThat(expected.getMessage(), containsString("closed"));
        }
    }
}
