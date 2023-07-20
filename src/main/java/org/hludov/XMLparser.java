package org.hludov;

public class XMLparser {

    public static String parseXML(String xmlData, String charCode) {

        String[] lines = xmlData.split("<Valute");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String code = getValueByTag(line, "CharCode");

            if (code.equals(charCode)) {
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
