package COR;

import entities.LogMessage;
import strategy.appender.LogAppender;

import java.util.List;

public abstract class LogHandler {
    protected int level;
    protected LogHandler next;
    protected List<LogAppender> logAppenders;

    public LogHandler(int level, List<LogAppender> logAppenders) {
        this.level = level;
        this.logAppenders = logAppenders;
    }

    public void setNext(LogHandler next) {
        this.next = next;
    }

    public void logMessage(LogMessage message) {
        int level = message.getLevel().getLevel();
        if(this.level >= level) {
            handle(message);
        } else {
            if(next != null) {
                next.logMessage(message);
            }
        }

    }

    abstract protected void handle(LogMessage message);
    abstract protected void addAppender(LogAppender logAppender);
}
