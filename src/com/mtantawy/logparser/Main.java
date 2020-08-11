package com.mtantawy.logparser;

import com.mtantawy.logparser.kodi.Parser;

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser();
        String logLine = "2020-08-02 19:22:27.057 T:1899965712  NOTICE: VideoPlayer: finished waiting";
        String parsed = parser.parseLine(logLine);
        System.out.println(parsed);
    }
}
