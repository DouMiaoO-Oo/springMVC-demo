package org.example.service.impl;

import org.example.dao.UserDao;
import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public void save(User user) {
        System.out.println("userService save...");
        userDao.save(user);
    }
}
