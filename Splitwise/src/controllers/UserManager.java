package controllers;

import entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> users;

    public UserManager() {
        this.users = new HashMap<>();
    }

    public User addUser(String id, String name, String email) {
        User user = new User(id, name, email);
        users.put(user.getId(), user);
        return user;
    }

    public User getUser(String id) {
        return users.get(id);
    }

    public void showBalanceSheet(String userId) {
        User user = users.get(userId);
        user.getBalanceSheet().showBalance();
    }
}
