package com.mtantawy.logparser;

import com.mtantawy.logparser.kodi.KodiParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Application {
    public Application(String parserType, String filePath) throws Exception {
        System.out.printf("ParserType: %s, FilePath: %s%n", parserType, filePath);
        File file = loadFile(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        Class<? extends Parser> parser;
        switch (parserType.toLowerCase()) {
            case KodiParser.PARSER_TYPE:
                parser = KodiParser.class;
                break;
            default:
                System.out.printf("Parser Type not supported: %s%n", parserType);
                return;
        }

        String line;
        while((line = bufferedReader.readLine()) != null && line.length() > 0) {
            String parsed = (String) parser.getMethod("parseLine", String.class).invoke(null, line);
            System.out.println(parsed);
        }
    }
    private File loadFile(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists() || !file.canRead()) {
            throw new Exception("File does not exist or not readable!");
        }

        return file;
    }
}
