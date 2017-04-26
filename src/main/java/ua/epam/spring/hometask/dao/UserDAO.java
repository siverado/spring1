package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by andrew on 4/20/17.
 */
public class UserDAO {

    private Set<User> users;

    public UserDAO() {
        this.users = new HashSet<>();
    }

    public User getUserByEmail(String email) {
        User result = null;
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                result = user;
            }
        }
        return result;
    }

    public void save(User object) {
        users.add(object);
    }

    public void remove(User object) {
        users.remove(object);
    }

    public User getById(Long id) {
        return null;
    }
}
