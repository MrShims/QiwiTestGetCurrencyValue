package org.hludov;

import org.hludov.utils.DateConverter;
import org.hludov.utils.ValidateArgs;

import static org.hludov.CurrencyValueConnection.getCurrencyValue;


public class App {
    public static void main(String[] args) {


        if (args[0].equals(Command.CURRENCY_RATES.getValue())) {

            if (ValidateArgs.validateArgsLine(args)) {

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


    }


}




