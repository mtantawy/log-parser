package com.mtantawy.logparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileTailer {
    final Path path;
    BufferedReader reader;
    Long fileLength;

    public FileTailer(String filePath) throws Exception {
        path = Path.of(filePath);
        initialize();
    }

    private void initialize() throws IOException {
        InputStream in = Files.newInputStream(path);
        reader = new BufferedReader(new InputStreamReader(in));
        fileLength = path.toFile().length();
    }

    private boolean fileTruncated() {
        File file = path.toFile();
        boolean fileLengthDecreased = file.length() < fileLength;
        fileLength = file.length();
        return fileLengthDecreased;
    }

    public String pollForLine() throws IOException, InterruptedException {
        String line;
        while (true) {
            if (fileTruncated()) {
                System.out.println("file was truncated!");
                initialize();
            }

            line = reader.readLine();
            if (line == null) {
                // Can wait/notify be used here instead?
                Thread.sleep(1000);
                continue;
            }

            // remove all invisible control characters
            // http://www.regular-expressions.info/unicode.html
            line  = line.replaceAll("[\\p{C}]", "");
            if (line.length() == 0) {
                continue;
            }

            return line;
        }
    }
}
