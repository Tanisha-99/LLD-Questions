package repositories;

import entities.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    private final Map<String, User> users;

    public UserRepository() {
        users = new ConcurrentHashMap<>();
    }

    public void save(User user) {
        users.put(user.getUserId(), user);
    }

    public User getUserById(String userId) throws Exception {
        if(!users.containsKey(userId)) {
            throw new Exception("User not found");
        }

        return users.get(userId);
    }
}
