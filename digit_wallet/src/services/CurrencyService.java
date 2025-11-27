package services;

import java.math.BigDecimal;
import entities.Currency;

import java.util.Map;

public class CurrencyService {
    private static final Map<String, BigDecimal> rates = Map.of(
            "INR->USD", new BigDecimal("0.012"),
            "USD->INR", new BigDecimal("83"),
            "INR->EUR", new BigDecimal("0.011"),
            "EUR->INR", new BigDecimal("89")
    );


    public BigDecimal convert(BigDecimal amt, Currency from, Currency to) {
        if (from == to) return amt;
        return amt.multiply(rates.get(from + "->" + to));
    }
}
