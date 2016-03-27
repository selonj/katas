package test.java.io;

import org.junit.Test;

import java.io.StreamTokenizer;
import java.io.StringReader;

import static java.io.StreamTokenizer.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-27.
 */
public class StreamTokenizerTest {
    private StreamTokenizer tokenizer = new StreamTokenizer(new StringReader("Java 1234.2\r\n#last"));

    @Test
    public void readTokens() throws Exception {
        assertEquals(TT_WORD, tokenizer.nextToken());
        assertEquals("Java", tokenizer.sval);

        assertEquals(TT_NUMBER, tokenizer.nextToken());
        assertEquals(1234.2, tokenizer.nval, .1);

        assertEquals('#', tokenizer.nextToken());//not word and number
        assertEquals(null, tokenizer.sval);

        assertEquals(TT_WORD, tokenizer.nextToken());
        assertEquals("last", tokenizer.sval);

        assertEquals(TT_EOF, tokenizer.nextToken());
    }

    @Test
    public void usingLineComments() throws Exception {
        tokenizer.commentChar('#');

        assertEquals(TT_WORD, tokenizer.nextToken());
        assertEquals(TT_NUMBER, tokenizer.nextToken());
        assertEquals(TT_EOF, tokenizer.nextToken());
    }

    @Test
    public void resetStringValueOnlyWhenNextTokenCalled() throws Exception {
        tokenizer.nextToken();
        assertThat(tokenizer.sval, is(notNullValue()));

        tokenizer.nextToken();
        assertThat(tokenizer.sval, is(nullValue()));
        assertThat(tokenizer.nval, is(1234.2));

        tokenizer.nextToken();
        assertThat(tokenizer.nval, is(1234.2));//number value not reset
    }

    @Test
    public void supportsPushTheLastTokenBackToTokenizer() throws Exception {
        tokenizer.nextToken();
        tokenizer.nextToken();

        tokenizer.pushBack();
        assertThat(tokenizer.nextToken(), is(TT_NUMBER));

        tokenizer.pushBack();
        tokenizer.pushBack();//disabled
        assertThat(tokenizer.nextToken(), is(TT_NUMBER));
    }

    @Test
    public void enableLowerCaseMode() throws Exception {
        tokenizer.lowerCaseMode(true);

        tokenizer.nextToken();
        assertThat(tokenizer.sval, equalTo("java"));
    }

    @Test
    public void markAsWordChars() throws Exception {
        tokenizer.wordChars('#', '#');

        tokenizer.nextToken();
        tokenizer.nextToken();
        tokenizer.nextToken();

        assertThat(tokenizer.sval, equalTo("#last"));
    }

    @Test
    public void ordinalChars() throws Exception {
        tokenizer.ordinaryChar('J');

        assertThat((char) tokenizer.nextToken(), is('J'));

        assertThat(tokenizer.nextToken(), is(TT_WORD));
        assertThat(tokenizer.sval, equalTo("ava"));
    }

    @Test
    public void enableEOLType() throws Exception {
        tokenizer.eolIsSignificant(true);

        tokenizer.nextToken();
        tokenizer.nextToken();
        assertThat(tokenizer.nextToken(), is(TT_EOL));
    }

}
