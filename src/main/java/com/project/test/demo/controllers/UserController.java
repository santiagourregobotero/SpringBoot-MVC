package com.project.test.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.test.demo.db.entities.User;
import com.project.test.demo.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    public UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "Hello , World!";
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        try{
            userService.addUser(user);
            return "Success";
        } catch(Exception e) { return "Error"; }
    }

    @GetMapping("/users/{id}")
    public User getUserItem(@PathVariable Integer id) {
        return userService.getUser(id);
    }
    

    @DeleteMapping("/remove/{id}")
    public String removeUser(@PathVariable Integer id) {
        try{
            userService.deleteUser(id);
            return "Success";
        } catch(Exception e) { return "Error"; }
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Integer id ,@RequestBody User userdetail) {
        try{
            User user = userService.getUser(id);
            user.setFirstname(userdetail.getFirstname());
            user.setName(userdetail.getName());
            user.setTelephone(userdetail.getTelephone());
            user.setEmail(userdetail.getEmail());
            user.setPosition(userdetail.getPosition());
            user.setRole(userdetail.getRole());
            user.setStatus(userdetail.getStatus());
            userService.updateUser(user);
            return "Success";
        } catch(Exception e) { return "Error"; }
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
