package com.mtantawy.logparser.kodi;

import com.mtantawy.logparser.Parser;

import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KodiParser implements Parser {
    public static final String PARSER_TYPE = "kodi";
    private static final String PATTERN = "(^\\S+)(\\s+)(\\S+)(\\s+)(\\S+)(\\s+)(\\S+)(\\s+)(.+)";

    @Override
    public Optional<LogLine> parseLine(String line) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(line);
        if (!matcher.matches()) {
            System.out.println("No matches found!");
            System.out.printf("Line: %s\n", line);
            return Optional.empty();
        }

        LogLine logLine = new LogLine();
        logLine.setSourceLine(matcher.group(0));
        try {
            logLine.setTimestamp(matcher.group(1) + "T" + matcher.group(3));
        } catch (DateTimeParseException exception) {
            System.out.println("Failed to parse Timestamp: " + matcher.group(1) + "T" + matcher.group(3));
            return Optional.empty();
        }
        String[] threadInfo = matcher.group(5).split(":");
        logLine.setThreadId((threadInfo.length == 2) ? threadInfo[1] : "0");
        logLine.setLevel(matcher.group(7).split(":")[0]);
        logLine.setMessage(matcher.group(9));

        return Optional.of(logLine);
    }
}
