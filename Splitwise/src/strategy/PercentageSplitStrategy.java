package strategy;

import entities.Split;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class PercentageSplitStrategy implements SplitStrategy{
    @Override
    public List<Split> calculateSplits(Double amount, User paidBy, List<User> participants, List<Double> splitValues) throws IllegalAccessException {
        if(participants.size() != splitValues.size()) {
            throw new IllegalAccessException("No of participants and split values must match");
        }

        if(Math.abs(splitValues.stream().mapToDouble(Double::doubleValue).sum() - 100.0) > 0.01) {
            throw new IllegalAccessException("Sum of percentages must be 100");
        }

        List<Split> splits = new ArrayList<>();

        for(int i = 0; i < participants.size(); i++) {
            Double amt = (amount * splitValues.get(i)) / 100.0;
            splits.add(new Split(participants.get(i), amt));
        }

        return splits;
    }
}
