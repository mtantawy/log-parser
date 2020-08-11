package com.mtantawy.logparser.kodi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KodiParser {
    public static final String PARSER_TYPE = "kodi";

    public String parseLine(String line) {
        String patternString = "(^\\S+)(\\s+)(\\S+)(\\s+)(\\S+)(\\s+)(\\S+)(\\s+)(.+)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(line);
        if (!matcher.matches()) {
            System.out.println("found nothing! :O");
        } else {
            for (int i = 0; i < matcher.groupCount() + 1; i++) {
                if (matcher.group(i).trim().length() == 0) continue;
                System.out.printf("Part %d: %s%n", i, matcher.group(i));
            }
        }

        return matcher.group(0);
    }
}
