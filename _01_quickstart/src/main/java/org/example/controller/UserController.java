package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  // 使用 @Controller 定义 Bean
public class UserController {

    public UserController(){
        System.out.println("UserController 启动了");
    }

    @RequestMapping("/save")  // 访问路径
    @ResponseBody // 当前操作的返回值类型
    public String save(){
        System.out.println("user save ...");
        return "{'module':'springmvc'}";
    }
}
