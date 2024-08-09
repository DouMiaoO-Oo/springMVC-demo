package org.example.controller;

import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(){
        System.out.println("Constructor: UserController");
    }

    @RequestMapping({"/save"})
    @ResponseBody
    public String save(){
        System.out.println("userController save ...");
        userService.save(new User());
        return "{'module':'springmvc'}";
    }
}
