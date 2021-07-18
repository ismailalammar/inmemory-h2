package com.demo.inmemory.demo.controller;

import com.demo.inmemory.demo.entity.User;
import com.demo.inmemory.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/get")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping(value = "/getById")
    public User getById(@RequestParam("id") long id) {
        return userService.findById(id);
    }

    @GetMapping(value = "/getEmailById")
    public String getEmail(@RequestParam("id") long id) {
        return userService.findEmailById(id);
    }

    @GetMapping(value = "/add")
    public User add(@RequestParam("firstname") String firstName ,
                    @RequestParam("lastname") String lastName,
                    @RequestParam("email") String email){
        return userService.addUser(firstName , lastName , email);
    }
}
