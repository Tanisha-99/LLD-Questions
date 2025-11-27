import COR.*;
import configuration.AppenderConfig;
import configuration.LogConfiguration;
import entities.LogLevel;
import strategy.appender.ConsoleAppender;
import strategy.appender.FileAppender;
import strategy.appender.LogAppender;
import strategy.formatter.SimpleTextFormatter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LogManager {
    private static LogManager instance;
    private final Map<String, Logger> loggers;
    private final LogConfiguration logConfiguration;

    private LogManager(LogConfiguration logConfiguration) {
        this.loggers = new ConcurrentHashMap<>();
        this.logConfiguration = logConfiguration;
    }

    public static synchronized LogManager getInstance(LogConfiguration logConfiguration) {
        if (instance == null) {
            instance = new LogManager(logConfiguration);
        }
        return instance;
    }

    public Logger getLogger(String name) {
        return loggers.computeIfAbsent(name, k -> new Logger(k, getLogHandler()));
    }

    public LogHandler getLogHandler() {
        LogHandler debugHandler = new DebugLogHandler(LogLevel.DEBUG.getLevel(), List.of(new ConsoleAppender(new SimpleTextFormatter())));
        LogHandler infoHandler = new InfoLogHandler(LogLevel.INFO.getLevel(), List.of(new ConsoleAppender(new SimpleTextFormatter())));
        LogHandler warnHandler = new WarnLogHandler(LogLevel.WARN.getLevel(), List.of(new ConsoleAppender(new SimpleTextFormatter())));
        LogHandler errorHandler = new ErrorLogHandler(LogLevel.ERROR.getLevel(), List.of(new ConsoleAppender(new SimpleTextFormatter())));

        debugHandler.setNext(infoHandler);
        infoHandler.setNext(warnHandler);
        warnHandler.setNext(errorHandler);

        return debugHandler;
    }


//    private LogHandler getLogHandler() {
//        // Map: LogLevel -> List of AppenderConfig
//        Map<LogLevel, List<AppenderConfig>> appenderConfigMap = logConfiguration.getAppendersConfig();
//
//        LogHandler previousHandler = null;
//        LogHandler firstHandler = null;
//
//        // Iterate LogLevels in order (DEBUG → INFO → ERROR)
//        LogLevel[] levels = LogLevel.values();
//
//        for (LogLevel level : levels) {
//            List<AppenderConfig> configs = appenderConfigMap.get(level);
//
//            if (configs == null || configs.isEmpty()) {
//                continue; // skip levels with no appenders
//            }
//
//            // Convert AppenderConfig to actual LogAppender objects
//            List<LogAppender> appenders = configs.stream()
//                    .map(cfg -> {
//                        if (cfg.getType() instanceof FileAppender) {
//                            return new FileAppender(cfg.getFormatterType(), cfg.getFilePath());
//                        } else if (cfg.getType() instanceof ConsoleAppender) {
//                            return new ConsoleAppender(cfg.getFormatterType());
//                        } else {
//                            throw new IllegalArgumentException("Unknown appender type: " + cfg.getType());
//                        }
//                    })
//                    .toList();
//
//            // Create LogHandler for this level
//            LogHandler handler;
//            switch (level) {
//                case DEBUG -> handler = new DebugLogHandler(level.getLevel(), appenders);
//                case INFO -> handler = new InfoLogHandler(level.getLevel(), appenders);
//                case ERROR -> handler = new ErrorLogHandler(level.getLevel(), appenders);
//                case WARN ->  handler = new WarnLogHandler(level.getLevel(), appenders);
//                default -> throw new IllegalArgumentException("Unknown log level: " + level);
//            }
//
//            // Link COR chain
//            if (previousHandler != null) {
//                previousHandler.setNext(handler);
//            } else {
//                firstHandler = handler; // first node of the chain
//            }
//
//            previousHandler = handler;
//        }
//
//        return firstHandler;
//    }


}
