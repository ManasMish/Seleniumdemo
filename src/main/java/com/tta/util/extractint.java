package com.tta.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class extractint {
    public static String extractInteger(String str) {
        String numericRegex = "\\d+\\.?\\d*";
        Pattern pattern = Pattern.compile(numericRegex); // Matches one or more digits
        Matcher matcher = pattern.matcher(str);

        StringBuilder builder = new StringBuilder();
        while (matcher.find()) {
            builder.append(matcher.group());
        }

        return builder.toString();
    }
}
