package com.offcn.controller;

import com.offcn.pojo.Test;
import com.offcn.pojo.User;
import com.offcn.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInterface userInterface;

    @PostMapping("/")
    public void add(User user){
        userInterface.add(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userInterface.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,User user){
        userInterface.update(id,user);
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id){
       return  userInterface.findOne(id);
    }

    @GetMapping("/")
    public List<User> findAll(){
        return userInterface.findAll();
    }

    @GetMapping("/findByName/{name}")
    public User findByUserName(@PathVariable String name){
        return userInterface.findByUserName(name);
    }

    @PostMapping("/findByIds")
    public List<User> findByIds(@RequestBody Test test){
        String ids = test.getIds();
        return userInterface.findByIdIn(Arrays.asList(ids));
    }

    @GetMapping("/findByName")
    public User findByName(String name){
        User user = userInterface.findByName(name);
        return user;
    }
}
