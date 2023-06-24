package com.rafiul.productsystem.controller;

import com.rafiul.productsystem.model.User;
import com.rafiul.productsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('admin')")
    public List<User> findAllUser(){
        return userService.findAllUsers();
    }

    @GetMapping("/{name}")
    @PreAuthorize("hasAuthority('USER')")
    public Optional<User> findUserByName(@PathVariable String name){
        return userService.findUserByName(name);
    }
    @PostMapping("/save")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public String saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping
    public String getHello() {
        return "Hello";
    }
}
