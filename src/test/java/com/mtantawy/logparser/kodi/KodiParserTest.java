package com.mtantawy.logparser.kodi;

import com.mtantawy.logparser.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class KodiParserTest {

    private Parser parser;

    @BeforeEach
    void setUp() {
        this.parser = new KodiParser();
    }

    @Test
    public void LogLineParsedCorrectly() {
        String logLineString = "2020-08-02 19:22:27.057 T:1899965712  NOTICE: VideoPlayer: finished waiting";
        Optional<LogLine> logLine = parser.parseLine(logLineString);

        Assertions.assertTrue(logLine.isPresent());
        logLine.ifPresent(logLineObj -> Assertions.assertEquals(logLineString, logLineObj.getSourceLine()));
        logLine.ifPresent(logLineObj -> Assertions.assertEquals("2020-08-02T19:22:27.057", logLineObj.getTimestamp().toString()));
        logLine.ifPresent(logLineObj -> Assertions.assertEquals(1899965712, logLineObj.getThreadId()));
        logLine.ifPresent(logLineObj -> Assertions.assertEquals(LogLine.Level.NOTICE, logLineObj.getLevel()));
        logLine.ifPresent(logLineObj -> Assertions.assertEquals("VideoPlayer: finished waiting", logLineObj.getMessage()));
    }

    @Test
    public void IncorrectLogLineReturnsEmptyOptional() {
        String logLineString = "";
        Optional<LogLine> logLine = parser.parseLine(logLineString);

        Assertions.assertTrue(logLine.isEmpty());
    }
}
