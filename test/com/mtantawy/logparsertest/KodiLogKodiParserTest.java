package com.mtantawy.logparsertest;

import com.mtantawy.logparser.kodi.KodiParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KodiLogKodiParserTest {
    @Test
    public void LogLineParsedCorrectly() {
        String logLine = "2020-08-02 19:22:27.057 T:1899965712  NOTICE: VideoPlayer: finished waiting";
        String parsed = KodiParser.parseLine(logLine);

        Assertions.assertEquals(logLine, parsed);
    }
}
