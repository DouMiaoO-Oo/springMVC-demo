package org.example.controller;

import org.example.domain.Address;
import org.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/response")
public class UserController {
    @RequestMapping("/toJumpPage")
//    @ResponseBody
    public String toJumpPage(HttpServletRequest request, HttpSession session){
        System.out.println("getRealPath: " + session.getServletContext().getRealPath("/"));
        System.out.println("返回页面");
//        System.out.println(this.getClass().getResource("/").getPath());

        return "page.jsp";  // 响应页面.  springMVC-demo/src/main/webapp/response/page.jsp
    }

    @RequestMapping("/toText")
    @ResponseBody
    public String toText(){
        System.out.println("返回纯文本数据");
        return "Hello World!";  // 相应文本内容
    }


    @RequestMapping("/toJsonPOJO")
    @ResponseBody
    public User toJsonPOJO(){
        System.out.println("返回json对象数据");
        return new User("ming", 15);  // 返回 json 对象
    }

    @RequestMapping("/toJsonList")
    @ResponseBody
    public List<User> toJsonList(){
        System.out.println("返回json集合数据");
        User user1 = new User("明", 15);
        User user2 = new User("芳", 12, new Address("浙江","杭州"));
        return Arrays.asList(user1, user2);
    }
}
