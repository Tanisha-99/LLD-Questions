package configuration;

import COR.LogHandler;
import entities.LogLevel;
import strategy.appender.ConsoleAppender;
import strategy.appender.FileAppender;
import strategy.appender.LogAppender;

import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

public class LogConfiguration {
    private LogLevel minLogLevel;

    // Map: Appender name -> properties
    private Map<LogLevel, List<AppenderConfig>> appendersConfig;

    public LogConfiguration(LogLevel minLogLevel, Map<LogLevel, List<AppenderConfig>> appendersConfig) {
        this.minLogLevel = minLogLevel;
        this.appendersConfig = appendersConfig;
    }

    public LogLevel getMinLogLevel() {
        return minLogLevel;
    }

    public Map<LogLevel, List<AppenderConfig>> getAppendersConfig() {
        return appendersConfig;
    }

}
