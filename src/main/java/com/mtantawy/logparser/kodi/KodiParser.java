package com.mtantawy.logparser.kodi;

import com.mtantawy.logparser.Parser;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KodiParser implements Parser {
    public static final String PARSER_TYPE = "kodi";
    private static final String PATTERN = "(^\\S+)(\\s+)(\\S+)(\\s+)(\\S+)(\\s+)(\\S+)(\\s+)(.+)";

    @Override
    public Optional<LogLine> parseLine(String line) {
        // remove all invisible control characters
        // http://www.regular-expressions.info/unicode.html
        line  = line.replaceAll("[\\p{C}]", "");
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(line);
        if (!matcher.matches()) {
            System.out.println("found nothing! :O");
            System.out.printf("Line: %s", line);
            return Optional.empty();
        }

        LogLine logLine = new LogLine();
        logLine.setSourceLine(matcher.group(0));
        logLine.setTimestamp(matcher.group(1) + "T" + matcher.group(3));
        logLine.setThreadId(matcher.group(5).split(":")[1]);
        logLine.setLevel(matcher.group(7).split(":")[0]);
        logLine.setMessage(matcher.group(9));

        return Optional.of(logLine);
    }
}
