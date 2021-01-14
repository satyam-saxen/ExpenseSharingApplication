package services;

import models.User;

import java.util.Map;
import java.util.Optional;

public interface UserService {
    Integer registerUser(String name,String phone);
    Map<Integer, User> getAllUsers();

    Optional<User> getUserById(Integer id);
    Optional<User> updateUser(Integer id,String name,String phone);
}
