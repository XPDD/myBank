package me.yu.service.impl;

import me.yu.dao.UserMapper;
import me.yu.domain.User;
import me.yu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> soutAllUserJson() {
        List<User> allUsers = userMapper.findAllUsers();
        return allUsers;
    }

    @Override
    public List<User> soutAllUserJson2() {
        User u1 = userMapper.findUserAllByUid(1);
        User u2 = userMapper.findUserAllByUid(2);
        User u3 = userMapper.findUserAllByUid(3);
        ArrayList<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        return users;
    }
}
