package repositories;

import models.User;

import java.util.Map;
import java.util.Optional;

public interface UserRepository {
    void addUserInDatabase(User user);
    Map<Integer, User> getAllUsers();
    Optional<User> getUserById(Integer id);
    Optional<User> updateUser(Integer id,String name,String phoneNumber);
}
