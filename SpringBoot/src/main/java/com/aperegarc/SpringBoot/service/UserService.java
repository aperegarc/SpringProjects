package com.aperegarc.SpringBoot.service;

import com.aperegarc.SpringBoot.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public User saveUser(User user);
    public User updateUser(Integer id, User nuevouser);
    public void deleteUser(Integer id);
}
