package com.mtantawy.logparser.kodi;

import com.mtantawy.logparser.Parser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KodiParser implements Parser {
    public static final String PARSER_TYPE = "kodi";
    private static final String PATTERN = "(^\\S+)(\\s+)(\\S+)(\\s+)(\\S+)(\\s+)(\\S+)(\\s+)(.+)";

    public static String parseLine(String line) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(line);
        if (!matcher.matches()) {
            System.out.println("found nothing! :O");
            System.out.printf("Line: %s", line);
            return "";
        } else {
            for (int i = 0; i < matcher.groupCount() + 1; i++) {
                if (matcher.group(i).trim().length() == 0) continue;
                System.out.printf("Part %d: %s%n", i, matcher.group(i));
            }
        }

        return matcher.group(0);
    }
}
