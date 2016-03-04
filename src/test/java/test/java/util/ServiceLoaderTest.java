package test.java.util;

import com.selonj.katas.data.JTATransaction;
import com.selonj.katas.data.LocalTransaction;
import com.selonj.katas.data.Transaction;
import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-3.
 */
public class ServiceLoaderTest {
    @Test
    public void canLoadMultiServicesInOrder() throws Exception {
        Iterator<Transaction> services = ServiceLoader.load(Transaction.class).iterator();

        assertThat(services.next(), instanceOf(LocalTransaction.class));
        assertThat(services.next(), instanceOf(JTATransaction.class));

        assertFalse(services.hasNext());
    }


}
