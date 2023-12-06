package com.project.test.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.test.demo.db.entities.User;
import com.project.test.demo.db.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User getUser(Integer id)
    {
        return userRepository.findById(id).get();
    }
    
    public User addUser(User user) {
        return userRepository.save(user);
    }
    
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}