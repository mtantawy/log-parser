package com.mtantawy.logparser.kodi;

import java.time.LocalDateTime;

// TODO: make this implement an interface
public class LogLine {
    enum Level {
        DEBUG,
        INFO,
        NOTICE,
        WARNING,
        ERROR,
        FATAL
    }

    private LocalDateTime timestamp;
    private long threadId;
    private Level level;
    private String message;
    private String sourceLine;

    @Override
    public String toString() {
        return "LogLine{" +
                "timestamp=" + timestamp +
                ", threadId=" + threadId +
                ", level=" + level +
                ", message='" + message + '\'' +
                ", sourceLine='" + sourceLine + '\'' +
                '}';
    }

    public String getSourceLine() {
        return sourceLine;
    }

    public void setSourceLine(String sourceLine) {
        this.sourceLine = sourceLine;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = LocalDateTime.parse(timestamp);
    }

    public long getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = Long.parseLong(threadId);
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = Level.valueOf(level);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
