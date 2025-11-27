package models;

import java.util.Date;

public class Card {
    private String cardHolderName;
    private String cardNumber;
    private Date expiryDate;
    private String pin;
    private String accountNumber;

    public Card(String cardHolderName, String cardNumber, Date expiryDate, String cvv, String accountNumber) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.pin = cvv;
        this.accountNumber = accountNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public boolean isCardValid() {
        return expiryDate != null && expiryDate.after(new Date());
    }

    public boolean isCardAuthenticated(String pin) {
        return this.pin.equals(pin);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPin() {
        return pin;
    }
}
