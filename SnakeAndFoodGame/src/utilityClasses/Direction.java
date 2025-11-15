package utilityClasses;

public enum Direction {
    LEFT("L"),
    RIGHT("R"),
    UP("U"),
    DOWN("D");

    private final String code;

    Direction(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Direction fromCode(String code) {
        for (Direction d : values()) {
            if (d.code.equalsIgnoreCase(code)) {
                return d;
            }
        }
        return null;
    }
}

