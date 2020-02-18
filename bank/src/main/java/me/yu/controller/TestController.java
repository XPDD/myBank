package me.yu.controller;

import me.yu.domain.User;
import me.yu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
public class TestController {
    @Autowired
    TestService testService;
    @RequestMapping("/test")
    @ResponseBody
    public List<User> test(){
        List<User> users = testService.soutAllUserJson();
        return users;
    }
    @RequestMapping("/test2")
    @ResponseBody
    public User test2(){
        User user = new User();
        user.setId(1);
        user.setUsername("test");
        user.setPassword("Test");
        return user;
    }
    @RequestMapping("/test3")
    @ResponseBody
    public List<User> test3(){
        List<User> users = testService.soutAllUserJson2();
        return users;
    }
}
