package models;

public enum Cash {
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    THOUSAND(1000);

    public int value;

    Cash(int value) {
        this.value = value;
    }
}
