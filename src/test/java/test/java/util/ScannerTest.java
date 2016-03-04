package test.java.util;

import org.junit.Test;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

/**
 * Created by L.x on 16-3-4.
 */
public class ScannerTest {

    public static final String TEXT = "123 welcome to 456!";
    private Scanner scanner = new Scanner(TEXT);

    @Test
    public void defaultValues() throws Exception {
        assertThat(scanner.delimiter().pattern(), equalTo("\\p{javaWhitespace}+"));
        assertThat(scanner.radix(), equalTo(10));
        assertThat(scanner.locale(), equalTo(Locale.getDefault()));
    }

    @Test
    public void next() throws Exception {
        assertTrue(scanner.hasNext());

        assertThat(scanner.next(), equalTo("123"));
        assertThat(scanner.next(), equalTo("welcome"));
        assertThat(scanner.next(), equalTo("to"));
        assertThat(scanner.next(), equalTo("456!"));

        assertFalse(scanner.hasNext());
    }

    @Test
    public void nextLine() throws Exception {
        assertTrue(scanner.hasNextLine());

        assertThat(scanner.nextLine(), equalTo(TEXT));
        assertFalse(scanner.hasNextLine());
    }

    @Test
    public void throwsExceptionIfNoItemExists() throws Exception {
        scanner.nextLine();
        try {
            scanner.nextLine();
            fail("should raising exception");
        } catch (NoSuchElementException ignored) {
        }
    }

    @Test
    public void findInLine() throws Exception {
        assertThat(scanner.findInLine("<not found>"), nullValue());
        assertThat(scanner.findInLine(""), equalTo(""));
        assertThat(scanner.findInLine("to.*"), equalTo("to 456!"));
    }

    @Test
    public void nextInt() throws Exception {
        assertTrue(scanner.hasNextInt());
        assertThat(scanner.nextInt(), equalTo(123));
        assertFalse(scanner.hasNextInt());
    }

    @Test
    public void resetNotErasingMatchingPosition() throws Exception {
        assertThat(scanner.findInLine("\\w+"), equalTo("123"));

        scanner.reset();

        assertThat(scanner.findInLine("\\w+"), equalTo("welcome"));
    }

    @Test
    public void skip() throws Exception {
        scanner.skip("\\d+");
        assertThat(scanner.next(), equalTo("welcome"));
    }

    @Test
    public void throwsExceptionIfSkipTheFollowingNotMatching() throws Exception {
        try {
            scanner.skip("nomatching");
            fail("should raising exception");
        } catch (NoSuchElementException expected) {
        }
    }
}
