package org.hludov.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateConverterTest {

    private static final String OUTPUT_VALUE = "08/10/2022";


    @Test
    void testConvertDateFormat() {

        String inputDate = "2022-10-08";
        String outputDate = DateConverter.convertDateFormat(inputDate);
        Assertions.assertEquals(outputDate, OUTPUT_VALUE);

    }

}