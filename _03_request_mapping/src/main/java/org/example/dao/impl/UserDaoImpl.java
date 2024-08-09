package org.example.dao.impl;

import org.example.dao.UserDao;
import org.example.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void save(User user) {
        System.out.println("userDao save ...");
    }
}
