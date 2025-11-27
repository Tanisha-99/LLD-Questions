import COR.LogHandler;
import entities.LogLevel;
import entities.LogMessage;

public class Logger {
    private String name;
    private LogHandler logHandler;

    public Logger(String name, LogHandler logHandler) {
        this.name = name;
        this.logHandler = logHandler;
    }

    public void log(LogLevel logLevel, String message) {
        LogMessage logMessage = new LogMessage(logLevel, this.name, message);
        logHandler.logMessage(logMessage);
    }
}
