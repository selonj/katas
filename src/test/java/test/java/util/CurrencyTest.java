package test.java.util;

import org.junit.Test;

import java.util.Currency;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-4.
 */
public class CurrencyTest {
    @Test
    public void currencyOfRMB() throws Exception {
        Currency currency = Currency.getInstance(Locale.CHINA);

        assertThat(currency.getSymbol(), equalTo("￥"));
        assertThat(currency.getDisplayName(), equalTo("人民币"));
        assertThat(currency.getDisplayName(Locale.US), equalTo("Chinese Yuan"));
        assertThat(currency.getCurrencyCode(), equalTo("CNY"));
    }
}
