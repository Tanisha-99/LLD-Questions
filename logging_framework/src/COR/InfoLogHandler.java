package COR;

import entities.LogMessage;
import strategy.appender.LogAppender;

import java.util.List;

public class InfoLogHandler extends LogHandler{
    public InfoLogHandler(int level, List<LogAppender> logAppender) {
        super(level, logAppender);
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
