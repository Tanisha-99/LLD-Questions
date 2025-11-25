package entities;

import observer.BalanceObserver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Group implements BalanceObserver {
    private String id;
    private String name;
    private Map<String, User> members;

    public Group(String name, List<User> members) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.members = new HashMap<>();
        for (User user : members) {
            this.members.put(user.getId(), user);
            user.getBalanceSheet().addObserver(this);
        }
    }

    @Override
    public void balanceUpdated(User user, double amount, String message) {
        // Notify all members except the user who triggered the change
        for (User member : members.values()) {
            if (!member.equals(user)) {
                System.out.println("Group Notification to " + member.getName() + ": " + message + " Amount: $" + String.format("%.2f", amount));
            }
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, User> getMembers() {
        return members;
    }

    public void addMember(User user) {
        this.members.put(user.getId(), user);
    }
}
