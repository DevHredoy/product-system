package com.rafiul.productsystem.service.impl;

import com.rafiul.productsystem.model.User;
import com.rafiul.productsystem.repository.UserRepo;
import com.rafiul.productsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return userRepo.findUserByName(name);
    }

    @Override
    public String saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User user1 = userRepo.save(user);
        if (user1 != null && user1.getName() != "") {
            return "HURRAY, USER WAS SUCCEFULLY SAVED";
        }
        return "PLEASE TRY AGAIN, USER WAS NOT SAVED";
    }
}
