package com.demo.inmemory.demo.service;

import com.demo.inmemory.demo.entity.User;
import com.demo.inmemory.demo.repo.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUser iUserRepo;

    public List<User> getAll() {
        return iUserRepo.findAll();
    }

    public User findById(Long id) {
        return Optional.ofNullable(iUserRepo.findOneById(id))
                .orElse(null);
    }

    public String findEmailById(Long id) {
        return iUserRepo.findEmailById(id);
    }

    public User addUser(String firstName , String lastName , String email){
        User user = new User(firstName , lastName , email);
        return iUserRepo.save(user);
    }

}
