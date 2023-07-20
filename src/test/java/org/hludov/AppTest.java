package org.hludov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class AppTest {

    private static final String outputValue = "30,9436";


    @Test
    void testGetUSDValue() throws IOException {


        String date = "02/03/2002";
        String ChaCode = "USD";

        String currencyValue = CurrencyValueConnection.getCurrencyValue(date, ChaCode);


        assert currencyValue != null;
        Assertions.assertTrue(currencyValue.contains(outputValue));


    }
}