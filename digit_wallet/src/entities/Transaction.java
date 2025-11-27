package entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private final String transactionId;
    private final String sourceAccountId;
    private final String destinationAccountId;
    private final BigDecimal amount;
    private final LocalDateTime timestamp;

    public Transaction(String transactionId, String sourceAccountId, String destinationAccountId, BigDecimal amount) {
        this.transactionId = transactionId;
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }
}
