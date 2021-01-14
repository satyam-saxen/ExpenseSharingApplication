import models.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import repositories.UserRepository;
import repositories.impl.InMemoryUserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TestInMemoryUserRepository {

    UserRepository userRepository;
    @BeforeEach
    public void setUp(){
        userRepository = new InMemoryUserRepository();
    }

    @AfterEach
    public void tearDown(){
        userRepository = null;
    }

    @Test
    public void testForGetUserByIdWithInvalidId(){

        Optional<User> expectedUser = Optional.empty();
        Optional<User> user = userRepository.getUserById(2);
        Assert.assertEquals(expectedUser,user);
    }

    @Test
    public void testForUpdateUserIdWithInValidId(){
        Optional<User> expectedUser = Optional.empty();
        Optional<User> user = userRepository.updateUser(1,"Satyam","88");
        Assert.assertEquals(expectedUser,user);
    }

    @Test
    public void testForUpdateUserIdWithValidId(){
        User user2 = new User(2,"B","91");
        userRepository.addUserInDatabase(user2);
//        User user1 = new User(2,"Satyam","88");
        user2.setPhoneNumber("88");
        user2.setName("Satyam");
        Optional<User> expectedUser = Optional.of(user2);
        Optional<User> user = userRepository.updateUser(2,"Satyam","88");
        Assert.assertEquals(expectedUser,user);
    }



    @Test
    public void testAddUserInDatabase(){
        User user = new User(1,"Satyam","8865011413");
        Boolean actualResult = userRepository.addUserInDatabase(user);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void testGetAllUsers(){
        User user1 = new User(1,"A","9");
        User user2 = new User(2,"B","91");
        User user3 = new User(3,"C","92");
        userRepository.addUserInDatabase(user1);
        userRepository.addUserInDatabase(user2);
        userRepository.addUserInDatabase(user3);
        Map<Integer,User> actualUsers = userRepository.getAllUsers();
        Map<Integer,User> expectedUsers = new HashMap<>();
        expectedUsers.put(1,user1);
        expectedUsers.put(2,user2);
        expectedUsers.put(3,user3);
        Assert.assertEquals(expectedUsers,actualUsers);
    }

    @Test
    public void testForGetUserByIdWithValidId(){
        User user2 = new User(2,"B","91");
        userRepository.addUserInDatabase(user2);
        Optional<User> expectedUser = Optional.of(user2);
        Optional<User> user = userRepository.getUserById(2);
        Assert.assertEquals(expectedUser,user);
    }




}
