package com.disney.film.models;

import com.disney.film.repositories.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserModelTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.save(new UserModel(1L, "Pedro", "pedro@mail.com", 2));
    }

    @Test
    @Rollback(false)
    @DisplayName("test to save user in database")
    public void testSaveUser() {
        UserModel userModel = userRepository.save(new UserModel(2L, "Stephen", "stephen@mail.com", 1));

        Assertions.assertNotNull(userModel);
        Assertions.assertEquals(userModel.getName(), "Stephen");
    }

    @Test
    @DisplayName("test to get user by name")
    public void testGetUserByName() {
        String name = "Pedro";
        UserModel userModel = userRepository.findByName(name);

        Assertions.assertEquals(userModel.getName(), name);
    }

    @Test
    @DisplayName("test to get user by name not existing")
    public void testGetUserByNameNotFound() {
        String name = "Tuki";
        UserModel userModel = userRepository.findByName(name);

        Assertions.assertNull(userModel);
    }

    @Test
    @Rollback(false)
    @DisplayName("test to update user in database")
    public void testUpdateUser() {
        String nameUpdate = "Mijo";
        String emailUpdate = "mijo@mail.com";
        Integer priorityUpdate = 2;
        UserModel user = new UserModel(1L, nameUpdate, emailUpdate, priorityUpdate);
        user.setId(1L);

        userRepository.save(user);
        UserModel userModel = userRepository.findByName("Mijo");

        Assertions.assertEquals(userModel.getName(), "Mijo");
    }

    @Test
    @Rollback(false)
    @DisplayName("test list all users")
    public void testListAllUsers() {
        List<UserModel> usersList = (List<UserModel>) userRepository.findAll();

        for (UserModel userModel : usersList) {
            System.out.println(userModel);
        }

        Assertions.assertFalse(usersList.isEmpty());
        Assertions.assertEquals(usersList.size(), 4);
    }

    @Test
    @Rollback(false)
    public void testDeleteUser() {
        Long id = 7L;
        boolean userExistBeforeBeingDelete = userRepository.existsById(id);
        userRepository.deleteById(id);
        boolean userNotExistBeforeBeingDelete = userRepository.existsById(id);

        Assertions.assertTrue(userExistBeforeBeingDelete);
        Assertions.assertFalse(userNotExistBeforeBeingDelete);
    }
}