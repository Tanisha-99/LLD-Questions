import entities.LogLevel;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LogManager logManager = LogManager.getInstance(null);

        Logger logger1 = logManager.getLogger("logger1");

        logger1.log(LogLevel.WARN, "This is a warning");
    }
}


/*
Requirements -

1. should support different log levels - debug, info, warn, error
2. should be able to append to multiple destinations (console, file, database, etc)
3. support for different log message formatting
4. ability to configure different logger appender and formatter


Entities:

1. Log message
2. logger
3. log level - enum
4. log config

Design patterns:

1. Strategy for different appenders and formatters
2. singleton
3. chain of responsibility
 */