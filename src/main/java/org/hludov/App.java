package org.hludov;

import org.hludov.utils.DateConverter;

import static org.hludov.utils.XMLparser.getCurrencyValue;


public class App {
    public static void main(String[] args) {

        if (args.length != 3) {
            return;
        }
        String charCode = null;
        String date = null;
        try {
            charCode = args[1].substring(7);
            date = args[2].substring(7);

            String convertedDate = DateConverter.convertDateFormat(date);


            System.out.println(getCurrencyValue(convertedDate, charCode));

        } catch (StringIndexOutOfBoundsException e) {

            System.out.println("Неправильный формат ввода данных");
        }


    }


}




