package com.mtantawy.logparser;

import com.mtantawy.logparser.kodi.KodiParser;

public class Application {
    public Application(String parserType, String filePath) {
        System.out.printf("ParserType: %s, FilePath: %s%n", parserType, filePath);
        switch (parserType.toLowerCase()) {
            case KodiParser.PARSER_TYPE:
                KodiParser parser = new KodiParser();
                String logLine = "2020-08-02 19:22:27.057 T:1899965712  NOTICE: VideoPlayer: finished waiting";
                String parsed = parser.parseLine(logLine);
                System.out.println(parsed);
                break;
            default:
                System.out.printf("Parser Type not supported: %s%n", parserType);
        }
    }
}
