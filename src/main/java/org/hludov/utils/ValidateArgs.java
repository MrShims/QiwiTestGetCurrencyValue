package org.hludov.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class ValidateArgs {

    public static final String MESSAGE= "Формат входных данных: currency_rates --code={Укажите charCode} --date={Укажите дату}";




    public static boolean validateArgsLine(String... args)
    {

        if (args.length!=3)
        {
            System.out.println("Неправильный формат ввода");
            System.out.println(MESSAGE);
            return false;
        }

        if (!args[1].contains("--code="))
        {
            System.out.println("Строка не содержит параметра --code");
            System.out.println(MESSAGE);
            return false;

        }
        if (!args[2].contains("--date="))
        {
            System.out.println("Строка не содержит параметра --date");
            System.out.println(MESSAGE);
            return false;
        }

        if (args[1].substring(7).length()==0)
        {
            System.out.println("Укажите валюту");
            return false;
        }
        if (args[2].substring(7).length()==0)
        {
            System.out.println("Укажите дату");
            return false;

        }
        String date = args[2].substring(7);
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
           inputDateFormat.parse(date);

        } catch (ParseException e) {
            System.out.println("Неправильный формат даты: yyyy-MM-dd");
            return false;
        }


        return true;


    }






}
