package com.mtantawy.logparser.kodi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public String parseLine(String line) {
//        String line = "2020-08-02 19:22:27.057 T:1899965712  NOTICE: VideoPlayer: finished waiting";

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
