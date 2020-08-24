package com.mtantawy.logparser;

import com.mtantawy.logparser.kodi.KodiParser;
import com.mtantawy.logparser.kodi.LogLine;

import java.io.IOException;
import java.util.Optional;

public class Application {
    private final String parserType;
    private final String filePath;

    public Application(String parserType, String filePath) throws Exception {
        System.out.printf("ParserType: %s, FilePath: %s%n", parserType, filePath);

        this.parserType = parserType;
        this.filePath = filePath;
    }

    public void run() throws Exception {
        FileTailer reader = new FileTailer(filePath);
        String line;
        while ((line = reader.pollForLine()) != null) {
            Parser parser = getParser(parserType);
            parse(line, parser);
        }
    }

    private void parse(String line, Parser parser) throws IOException, InterruptedException {
            Optional<LogLine> logLine = parser.parseLine(line);
            logLine.ifPresent(l -> System.out.println(l.toString()));
    }

    private Parser getParser(String parserType) {
        Parser parser;
        switch (parserType.toLowerCase()) {
            case KodiParser.PARSER_TYPE:
                parser = new KodiParser();
                break;
            default:
                System.out.printf("Parser Type not supported: %s%n", parserType);
                throw new RuntimeException("Parser Type not supported: " + parserType);
        }
        return parser;
    }

}
