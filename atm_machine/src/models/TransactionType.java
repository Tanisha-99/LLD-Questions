package models;

public enum TransactionType {
    CASH_WITHDRAWAL(1),
    CHECK_BALANCE(2);

    private final int option;

    TransactionType(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }

    public static TransactionType getTypeFromOption(int option) {
        for (TransactionType type : TransactionType.values()) {
            if (type.getOption() == option) {
                return type;
            }
        }
        return null;
    }
}
