package com.mtantawy.logparsertest;

import com.mtantawy.logparser.kodi.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KodiLogParserTest {
    @Test
    public void LogLineParsedCorrectly() {
        Parser parser = new Parser();
        String logLine = "2020-08-02 19:22:27.057 T:1899965712  NOTICE: VideoPlayer: finished waiting";
        String parsed = parser.parseLine(logLine);

        Assertions.assertEquals(logLine, parsed);
    }
}
