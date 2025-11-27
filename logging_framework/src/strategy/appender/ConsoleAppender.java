package strategy.appender;

import entities.LogMessage;
import strategy.formatter.LogFormatter;

public class ConsoleAppender implements LogAppender{
    private LogFormatter logFormatter;

    public ConsoleAppender(LogFormatter logFormatter) {
        this.logFormatter = logFormatter;
    }

    @Override
    public void append(LogMessage logMessage) {
        System.out.println(logFormatter.format(logMessage));
    }

    @Override
    public void close() {

    }

    @Override
    public LogFormatter getFormatter() {
        return this.logFormatter;
    }

    @Override
    public void setFormatter(LogFormatter formatter) {
        this.logFormatter = formatter;
    }
}
