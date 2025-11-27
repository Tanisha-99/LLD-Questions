package entities;

public enum LogLevel {
    DEBUG(0),
    INFO(1),
    WARN(2),
    ERROR(3);

    private final int level;

    LogLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean isGreaterOrEqual(LogLevel logLevel) {
        return this.level >= logLevel.getLevel();
    }
}
