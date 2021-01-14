package services.impl;

import models.User;
import repositories.UserRepository;
import repositories.impl.InMemoryUserRepository;
import services.UserService;
import utils.UserDataValidator;
import utils.impl.UserIdGenerator;

import java.util.Map;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    UserDataValidator userDataValidator = new UserDataValidator();
    UserRepository userRepository = new InMemoryUserRepository();
    @Override
    public Integer registerUser(String name, String phoneNumber) {
        if(!userDataValidator.validateName(name))
            return -1;
        if(!userDataValidator.validatePhoneNumber(phoneNumber))
            return -1;
        Integer generatedId = UserIdGenerator.getUniqueId();
        User user = new User(generatedId,name,phoneNumber);
        userRepository.addUserInDatabase(user);
        return user.getId();
    }

    @Override
    public Map<Integer, User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.getUserById(id);
    }


    @Override
    public Optional<User> updateUser(String id, String name, String phoneNumber) {
        if(userDataValidator.validateName(name) && userDataValidator.validatePhoneNumber(phoneNumber)
          && userDataValidator.validateId(id)){
            return userRepository.updateUser(Integer.parseInt(id),name,phoneNumber);
        }
        return Optional.empty();
    }
}
