package org.hludov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.hludov.XMLparser.parseXML;

public class CurrencyValueConnection {

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



}
