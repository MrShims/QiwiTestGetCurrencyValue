package org.hludov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class AppTest {

    private static final String OUTPUT_USD = "30,9436";
    private static final String OUTPUT_GBP="43,8254";



    @Test
    void testGetUSDValue() {

        String date = "02/03/2002";
        String CharCode = "USD";
        String responseData = CurrencyValueConnection.getCurrencyValue(date);
        String currencyValue= XMLparser.parseXML(responseData,CharCode);


        assert currencyValue != null;
        Assertions.assertNotNull(currencyValue);
        Assertions.assertTrue(currencyValue.contains(OUTPUT_USD));
    }
    @Test
    void testGetGBPValue() {

        String date = "02/03/2002";
        String CharCode = "GBP";
        String responseData = CurrencyValueConnection.getCurrencyValue(date);
        String currencyValue= XMLparser.parseXML(responseData,CharCode);


        assert currencyValue != null;
        Assertions.assertNotNull(currencyValue);
        Assertions.assertTrue(currencyValue.contains( OUTPUT_GBP));
    }




}