package org.hludov.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class XMLparser {

    public static String getCurrencyValue(String date, String charCode) {
        String apiURL = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + date;

        try {
            URL url = new URL(apiURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }
                reader.close();

                return parseXML(response.toString(), charCode);
            } else {
                System.out.println("Ошибка " + responseCode + ": Невозможно получить данные о курсах валют.");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String parseXML(String xmlData, String nameCurrency) {

        String[] lines = xmlData.split("<Valute");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String code = getValueByTag(line, "CharCode");

            if (code.equals(nameCurrency)) {
                String name = getValueByTag(line, "Name");
                String value = getValueByTag(line, "Value");


                return String.format("%s (%s): %s", code, name, value);

            }

        }
        return "Валюта не найдена";
    }

    public static String getValueByTag(String line, String tag) {
        String openTag = "<" + tag + ">";
        String closeTag = "</" + tag + ">";
        int startIndex = line.indexOf(openTag) + openTag.length();
        int endIndex = line.indexOf(closeTag);
        return line.substring(startIndex, endIndex);
    }

}
