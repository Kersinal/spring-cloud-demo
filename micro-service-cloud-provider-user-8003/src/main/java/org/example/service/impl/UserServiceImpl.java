package org.example.service.impl;

import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public List<User> getAll() {
        return userMapper.selectAll();
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(String username) {
        return userMapper.deleteByUsername(username);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
