package vas.com.currencyconverter;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import static android.content.ContentValues.TAG;


@SuppressWarnings({"unused", "WeakerAccess"})
public class CurrencyConverter extends AsyncTask<Void, Void, Exception> {

    private static SortedMap<Currency, ArrayList<Locale>> currencyLocaleMap;
    private static HashMap<String, Double> rates = null;
    private static Calendar ratesDate = null;


    static {
        currencyLocaleMap = new TreeMap<>(new Comparator<Currency>() {
            @Override
            public int compare(Currency c1, Currency c2) {
                return c1.getCurrencyCode().compareTo(c2.getCurrencyCode());
            }
        });
        for (Locale locale : Locale.getAvailableLocales()) {
            try {
                Currency currency = Currency.getInstance(locale);
                if (!currencyLocaleMap.containsKey(currency)) {
                    ArrayList<Locale> array = new ArrayList<>();
                    array.add(locale);
                    currencyLocaleMap.put(currency, array);
                } else currencyLocaleMap.get(currency).add(locale);
            } catch (Exception ignored) {
            }
        }
    }

    Double retVal = null;
    final double mval;
    final String mvalCurrency;
    final String moutCurrency;
    final Callback callback;

    public CurrencyConverter(final double mval, final String mvalCurrency, final String moutCurrency, final Callback callback) {
        this.mval = mval;
        this.mvalCurrency = mvalCurrency;
        this.moutCurrency = moutCurrency;
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        retVal = null;
    }

    @Override
    protected Exception doInBackground(Void... params) {
        try {
            generateRatesFromFloatRates();
            retVal = calculate(mval, mvalCurrency, moutCurrency);
        } catch (Exception e) {
            e.printStackTrace();
            return e;
        }
        return null;
    }


    public interface Callback {
        void onValueCalculated(Double value, Exception e);
    }


    @Override
    protected void onPostExecute(Exception e) {
        callback.onValueCalculated(retVal, e);
    }
    public static String formatCurrencyVal(String currencyCode, double val) {
        Currency currency = Currency.getInstance(currencyCode);
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
        format.setCurrency(currency);
        return format.format(val);
    }

    public static ArrayList<Locale> getCurrencyLocale(Currency currencyCode) {
        return currencyLocaleMap.get(currencyCode);
    }

    public static String getCurrencyFlag(String currencyCode) {
        return "https://www.ecb.europa.eu/shared/img/flags/" + currencyCode + ".gif";
    }
    public static List<Currency> getCurrencyList() {
        return new ArrayList<>(currencyLocaleMap.keySet());
    }

    public String getStringFormat(String currencyCode, Number number) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
        format.setCurrency(Currency.getInstance(currencyCode));
        return format.format(number);
    }
    public static String getCurrencySymbol(String currencyCode) {
        Currency currency = Currency.getInstance(currencyCode);
        if (currencyLocaleMap.get(currency).size() > 0) {
            Locale locale = currencyLocaleMap.get(currency).get(0);
            return currency.getSymbol(locale);
        }
        return "";
    }

    public static void reset() {
        ratesDate = null;
        rates = null;
    }
    public static void calculate(final double mval, final Currency mvalCurrency, final Currency moutCurrency, final Callback callback) {
        calculate(mval, mvalCurrency.toString(), moutCurrency.toString(), callback);
    }

    public static void calculate(final double mval, final String mvalCurrency, final String moutCurrency, final Callback callback) {
        if (shouldGenerateRates()) {
            CurrencyConverter task = new CurrencyConverter(mval, mvalCurrency, moutCurrency, callback);
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else
            try {
                callback.onValueCalculated(calculate(mval, mvalCurrency, moutCurrency), null);
            } catch (Exception e) {
                e.printStackTrace();
                callback.onValueCalculated(null, e);
            }

    }



    private static boolean shouldGenerateRates() {
        if (ratesDate != null) {
            Calendar today = Calendar.getInstance();
            boolean isSameDay = ratesDate.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                    ratesDate.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR);
            return !isSameDay;
        }
        return true;
    }

    private static void generateRatesFromECB() throws Exception {
        rates = new HashMap<>();
        URL url = new URL("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
        InputStream stream = url.openStream();
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();

        XMLReader xr = sp.getXMLReader();
        xr.setContentHandler(new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                Log.d(TAG, "start element: localname=" + localName);
                for (int i = 0; i < attributes.getLength(); i++) {
                    Log.d(TAG, "start element: attr=" + attributes.getLocalName(i) + " mval=" + attributes.getValue(i));
                }

                if ("Cube".equals(localName)) {
                    String name = null;
                    Double rate = null;
                    for (int i = 0; i < attributes.getLength(); i++) {
//                        if ("time".equals(attributes.getLocalName(i))) {
//                            time = attributes.getValue(i);
//                        } else
                        if ("currency".equals(attributes.getLocalName(i))) {
                            name = attributes.getValue(i);
                        } else if ("rate".equals(attributes.getLocalName(i))) {
                            rate = Double.parseDouble(attributes.getValue(i));
                        }
                    }
                    // add new element in the list
                    if (name != null)
                        rates.put(name, rate);
                }
            }

        });
        xr.parse(new InputSource(stream));
        ratesDate = Calendar.getInstance();
    }
    private static void generateRatesFromFloatRates() throws Exception {
        rates = new HashMap<>();
        rates.put("BRL", 1D);

        URL url = new URL("http://www.floatrates.com/daily/brl.json");
        InputStream stream = url.openStream();

        JsonReader reader = new JsonReader(new InputStreamReader(stream));
        reader.setLenient(true);
        reader.beginObject();
        while (reader.hasNext()) {
            String codeName = reader.nextName();
            reader.beginObject();
            String code = null;
            double rate = 0;
            while (reader.hasNext()) {
                String name = reader.nextName();
                switch (name) {
                    case "code":
                        code = reader.nextString();
                        break;
                    case "rate":
                        rate = reader.nextDouble();
                        break;
                    default:
                        reader.skipValue();
                        break;
                }
            }
            reader.endObject();
            if (code != null)
                rates.put(code, rate);
        }
        reader.endObject();
        ratesDate = Calendar.getInstance();
    }
    private static Double calculate(Double mval, String mvalCurrency, String moutCurrency) throws Exception {
        Double rateValue = rates.get(mvalCurrency);
        Double rateDesired = rates.get(moutCurrency);
        if (rateValue != null && rateDesired != null)
            return rateValue == 0 ? 0 : rateDesired / rateValue * mval;
        else
            throw new Exception("Currency not found.");
    }

}
