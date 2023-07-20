package org.hludov.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    public static String convertDateFormat(String inputDate)
    {
        String convertedDate = "";
        String outputFormat= "dd/MM/yyyy";

        try {
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outputDateFormat = new SimpleDateFormat(outputFormat);

            Date date = inputDateFormat.parse(inputDate);
            convertedDate = outputDateFormat.format(date);
        } catch (ParseException e) {


            System.out.println("Ошибка преобазования даты в формат: dd/MM/yyyy");
        }

        return convertedDate;
    }
}
