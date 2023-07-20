package org.hludov;

import org.hludov.utils.XMLparser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AppTest {

    private static final String outputValue = "30,9436";


    @Test
    void testGetUSDValue() throws IOException {


        String date = "02/03/2002";
        String ChaCode = "USD";

        String currencyValue = XMLparser.getCurrencyValue(date, ChaCode);


        assert currencyValue != null;
        Assertions.assertTrue(currencyValue.contains(outputValue));


    }
}