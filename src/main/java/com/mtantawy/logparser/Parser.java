package com.mtantawy.logparser;

import com.mtantawy.logparser.kodi.LogLine;

import java.util.Optional;

public interface Parser {
    Optional<LogLine> parseLine(String line);
}
