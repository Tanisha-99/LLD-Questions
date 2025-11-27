package configuration;

import entities.LogLevel;
import strategy.appender.LogAppender;
import strategy.formatter.LogFormatter;

public class AppenderConfig {
    private final LogAppender type;          // ConsoleAppender, FileAppender
    private final LogFormatter formatterType; // SimpleFormatter, JSONFormatter
    private final String filePath;      // optional for file appenders

    public AppenderConfig(LogAppender type, LogFormatter formatterType, String filePath) {
        this.type = type;
        this.formatterType = formatterType;
        this.filePath = filePath;
    }

    public LogAppender getType() { return type; }
    public LogFormatter getFormatterType() { return formatterType; }
    public String getFilePath() { return filePath; }
}
