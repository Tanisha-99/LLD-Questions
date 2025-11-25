package strategy;

import entities.Split;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class ExactSplitStrategy implements SplitStrategy{
    @Override
    public List<Split> calculateSplits(Double amount, User paidBy, List<User> participants, List<Double> splitValues) throws IllegalAccessException {
        if(participants.size() != splitValues.size()) {
            throw new IllegalAccessException("No of participants and split values must match");
        }

        if(Math.abs(splitValues.stream().mapToDouble(Double::doubleValue).sum() - amount) > 0.01) {
            throw new IllegalAccessException("Sum of percentages must be " + amount);
        }

        List<Split> splits = new ArrayList<>();

        for(int i = 0; i < participants.size(); i++) {

            splits.add(new Split(participants.get(i), splitValues.get(i)));
        }

        return splits;
    }
}
