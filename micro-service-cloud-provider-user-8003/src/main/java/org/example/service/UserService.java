package org.example.service;

import org.example.entity.User;

import java.util.List;

public interface UserService {
    User getUser(String username);

    List<User> getAll();

    int updateUser(User user);

    int deleteUser(String username);

    int insertUser(User user);
}
