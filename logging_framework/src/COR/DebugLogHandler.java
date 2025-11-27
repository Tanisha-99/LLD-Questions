package COR;

import entities.LogMessage;
import strategy.appender.LogAppender;

import java.util.List;

public class DebugLogHandler extends LogHandler{

    public DebugLogHandler(int level, List<LogAppender> appenders) {
        super(level, appenders);
    }

    @Override
    protected void handle(LogMessage message) {

        List<LogAppender> appenders = this.logAppenders;

        for(LogAppender appender: appenders) {
            appender.append(message);
        }
    }

    @Override
    protected void addAppender(LogAppender logAppender) {
        this.logAppenders.add(logAppender);
    }
}
