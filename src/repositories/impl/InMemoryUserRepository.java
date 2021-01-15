package repositories.impl;

import models.User;
import repositories.UserRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {
    private static Map<Integer,User> users = new HashMap<Integer, User>();


    @Override
    public Boolean addUserInDatabase(User user) {
        users.put(user.getId(),user);
        return users.containsKey(user.getId());
    }

    @Override
    public Map<Integer, User> getAllUsers(){
        return users;
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Optional<User> updateUser(Integer id, String name, String phoneNumber) {
        Optional<User> maybeExistingUser = getUserById(id);
        return maybeExistingUser.map(user -> updateUser(user,id,name,phoneNumber));
    }

    private User updateUser(User existingUser, Integer id, String name, String phoneNumber) {
        existingUser.setName(name);
        existingUser.setPhoneNumber(phoneNumber);
        users.put(id,existingUser);
        return existingUser;
    }
}
