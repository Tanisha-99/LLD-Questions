package strategy;

import entities.Split;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy{

    @Override
    public List<Split> calculateSplits(Double amount, User paidBy, List<User> participants, List<Double> splitValues) {
        List<Split> splits = new ArrayList<>();

        Double amountPerPerson = amount / participants.size();
        for(User user: participants) {
            Split split = new Split(user, amountPerPerson);
            splits.add(split);
        }

        return splits;
    }
}
