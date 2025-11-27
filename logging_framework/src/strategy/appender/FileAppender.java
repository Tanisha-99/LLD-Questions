package strategy.appender;

import entities.LogMessage;
import strategy.formatter.LogFormatter;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender {
    private FileWriter writer;
    private LogFormatter logFormatter;

    public FileAppender(LogFormatter logFormatter, String filePath) {
        this.logFormatter = logFormatter;
        try {
            this.writer = new FileWriter(filePath, true);
        } catch (Exception e) {
            System.out.println("Failed to create writer for file logs, exception: " + e.getMessage());
        }
    }

    @Override
    public void append(LogMessage logMessage) {
        try {
            writer.write(logFormatter.format(logMessage) + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Failed to write logs to file, exception: " + e.getMessage());
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to close logs file, exception: " + e.getMessage());
        }
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
