package com.offcn.service.impl;

import com.offcn.pojo.User;
import com.offcn.repository.UserRepository;
import com.offcn.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserInterface {
    
    @Autowired
    private UserRepository repository;
    
    @Override
    public void add(User user) {
        repository.save(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Long id, User user) {
        user.setId(id);
        repository.saveAndFlush(user);
    }

    @Override
    public List<User> findAll() {
        List<User> usersList = repository.findAll();
        return usersList;
    }

    @Override
    public User findOne(Long id) {
        Optional<User> optionalUser = repository.findById(id);
        User user = optionalUser.get();
        return user;
    }

    @Override
    public User findByUserName(String username) {
        User user = repository.findByNameIs(username);
        return user;
    }

    @Override
    public List<User> findByIdIn(List ids) {
        return  repository.findByIdIn(ids);
    }

    @Override
    public User findByName(String name) {
        return repository.findByName(name);
    }
}
