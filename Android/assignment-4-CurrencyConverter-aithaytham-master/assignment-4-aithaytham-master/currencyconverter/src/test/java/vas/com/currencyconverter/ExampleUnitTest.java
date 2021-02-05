package vas.com.currencyconverter;

import org.junit.Test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.junit.Assert.assertNotNull;

/
public class ExampleUnitTest {
    private static final String BANKEU_XML_URL = "http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";

    @Test
    public void addition_isCorrect() throws Exception {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(BANKEU_XML_URL).build();
        Response response = client.newCall(request).execute();
        if (response != null && response.body() != null) {
            String responceString = response.body().string();
            assertNotNull(responceString);
        }
    }
}