package com.project.test.demo.service;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.test.demo.db.entities.User;
import com.project.test.demo.db.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testFindById()
    {
        User mockUser = new User(1 , "John" , "Doe" , "1231233" , "JohnDoe@gmail.com" , 1, "Administrator,Support,Assistant" , 0);
        when(userRepository.findById(1)).thenReturn(Optional.of(mockUser));

        User foundUser = userService.getUser(1);
        assertEquals("John", foundUser.getFirstname());
    }

    @Test
    public void testSaveUser() {
        User userToSave = new User( "John" , "Doe" , "1231233" , "JohnDoe@gmail.com" , 1, "Administrator,Support,Assistant" , 0);
        User savedUser = new User(12 , "John" , "Doe" , "1231233" , "JohnDoe@gmail.com" , 1, "Administrator,Support,Assistant" , 0);

        when(userRepository.save(userToSave)).thenReturn(savedUser);

        User returnedUser = userService.addUser(userToSave);
        assertEquals(12, returnedUser.getId());
    }

    @Test
    public void testUpdateUser() {
        User userToSave = new User(12 ,  "John" , "Doe" , "1231233" , "JohnDoe@gmail.com" , 1, "Administrator,Support,Assistant" , 0);
        User savedUser = new User(12 , "John1" , "Doe1" , "1231233" , "JohnDoe@gmail.com" , 1, "Administrator,Support,Assistant" , 0);


        when(userRepository.save(userToSave)).thenReturn(savedUser);

        User returnedUser = userService.updateUser(userToSave);
        assertEquals("John1", returnedUser.getFirstname());
    }

    @Test
    public void testFindAllUsers() {
        List<User> mockUsers = Arrays.asList(
                new User(12 , "John" , "Doe" , "1231233" , "JohnDoe@gmail.com" , 1, "Administrator,Support,Assistant" , 0),
                new User(13 , "John" , "Doe" , "1231233" , "JohnDoe@gmail.com" , 1, "Administrator,Support,Assistant" , 0)
        );

        when(userRepository.findAll()).thenReturn(mockUsers);

        List<User> foundUsers = userService.getAllUsers();
        assertEquals(2, foundUsers.size());
    }

    @Test
    public void testDeleteUser() {
        int userIdToDelete = 12;

        userService.deleteUser(userIdToDelete);
        verify(userRepository).deleteById(userIdToDelete);
    }
}
