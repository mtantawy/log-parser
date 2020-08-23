package com.mtantawy.logparser;

import com.mtantawy.logparser.kodi.KodiParser;
import com.mtantawy.logparser.kodi.LogLine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class Application {
    public Application(String parserType, String filePath) throws Exception {
        System.out.printf("ParserType: %s, FilePath: %s%n", parserType, filePath);

        File file = loadFile(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        Parser parser = getParser(parserType);
        parse(bufferedReader, parser);
    }

    private void parse(BufferedReader bufferedReader, Parser parser) throws IOException {
        String line;
        while((line = bufferedReader.readLine()) != null && line.length() > 0) {
            Optional<LogLine> logLine = parser.parseLine(line);
            logLine.ifPresent(l -> System.out.println(l.toString()));
        }
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

    private File loadFile(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists() || !file.canRead()) {
            throw new Exception("File does not exist or not readable!");
        }

        return file;
    }
}
