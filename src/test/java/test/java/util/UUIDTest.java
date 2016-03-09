package test.java.util;

import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-4.
 */
public class UUIDTest {

    int bits = 128;
    int countOfHex = bits / 4;
    int parts = 5;
    int countOfSeparators = parts - 1;


    @Test
    public void lengthOfUUID() throws Exception {
        int expectedLength = countOfHex + countOfSeparators;

        for (any of : times) {
            String id = UUID.randomUUID().toString();
            assertThat(id, id.length(), equalTo(expectedLength));
        }
    }

    private static final any[] times = new any[20];

    private interface any {
    }

}
