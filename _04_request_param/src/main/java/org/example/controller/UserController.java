package org.example.controller;

import org.example.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController{
    /*
    普通参数：
        请求参数与形参名称对应即可完成参数传递
        请求参数名与形参名不同时，使用 @RequestParam 注解关联请求参数名称与形参名称之间的关系
     */
    @RequestMapping("/commonParam")
    @ResponseBody
    public String commonParam(String name, @RequestParam("age") Integer UserAge){
        /*
            支持GET请求：
                curl 'localhost:8080/user/commonParam?name=ming&age=123'

            支持POST请求：
                curl 'localhost:8080/user/commonParam' \
                -X POST \
                -H "Content-Type:application/x-www-form-urlencoded" \
                -d 'name=ming&age=321'
         */
        System.out.printf("普通参数: name=%s, UserAge=%s\n", name, UserAge);
        return String.format("commonParam: name=%s, age=%s", name, UserAge);
    }

    /*
        POJO参数：
            请求参数与形参对象中的属性对应即可完成参数传递
            嵌套属性 Address 按照层次结构设定名称即可完成参数传递
    */
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user){
        /*
        支持GET请求：
            curl 'localhost:8080/user/pojoParam?name=ming&age=123'
            curl 'localhost:8080/user/pojoParam?name=ming&age=123&address.province=zhejiang&address.city=hangzhou'

        支持POST请求：
            curl 'localhost:8080/user/pojoParam' \
            -X POST \
            -H "Content-Type:application/x-www-form-urlencoded" \
            -d 'name=ming&age=321&address.province=zhejiang&address.city=hangzhou'
         */
        System.out.println("pojo参数接受普通格式数据 user ==> "+ user);
        return "pojoParam: " + user.toString();
    }



    /*
        数组参数：
            同名请求参数可以直接映射到对应名称的形参数组对象中, 非同名参数会被忽略
     */
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes){
        /*
            支持GET请求：
                curl 'localhost:8080/user/arrayParam?likes=a&likes=b&likes=c&hello=d'

            支持POST请求：
                curl 'localhost:8080/user/arrayParam' \
                -X POST \
                -H "Content-Type:application/x-www-form-urlencoded" \
                -d 'likes=A&likes=B&likes=C'
         */
        System.out.println("数组参数 likes ==> "+ Arrays.toString(likes));
        return "arrayParam: " + Arrays.toString(likes);
    }

    /*
        集合类型的普通参数：
            同名请求参数可以使用 @RequestParam 注解映射到对应名称的集合对象中作为数据
     */
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes){
        /*
            支持GET请求：
                curl 'localhost:8080/user/listParam?likes=a&likes=b&likes=c&hello=d'

            支持POST请求：
                curl 'localhost:8080/user/listParam' \
                -X POST \
                -H "Content-Type:application/x-www-form-urlencoded" \
                -d 'likes=A&likes=B&likes=C'
         */
        System.out.println("集合参数接受普通格式数组, likes ==> "+ likes);
        return "listParam: " + likes;
    }

    /*
         集合类型的普通参数（接受 json格式的数组数据）
         1. 开启json数据格式的自动转换，在配置类 SpringMvcConfig 中开启 @EnableWebMvc
         2. 使用 @RequestBody 注解将外部通过 Http body 传递的 json数组数据映射到形参的集合对象中作为数据
     */
    @RequestMapping(value = "/listParamForJson")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes){
        /*
            支持POST请求：
                    curl 'localhost:8080/user/listParamForJson' \
                    -X POST \
                    -H "Content-Type:application/json" \
                    -d '["a","b","c"]'

            GET请求（非常规操作.GET 请求一般 body 为空）：
                curl 'localhost:8080/user/listParamForJson' \
                    -X GET \
                    -H "Content-Type:application/json" \
                    -d '["a","b","c"]'

         */
        System.out.println("集合参数接受json格式数组, likes ==> " + likes);
        return "listParamForJson: " + likes;
    }


    @RequestMapping("/pojoParamForJson")
    @ResponseBody
    public String pojoParamForJson(@RequestBody User user){

            /*
            POST请求：
                curl 'localhost:8080/user/pojoParamForJson' \
                -X POST \
                -H "Content-Type:application/json" \
                -d '{"name":"ming", "age":"13", "address":{"province":"zhejiang","city":"hangzhou"}}'
            */

        System.out.println("pojo参数接受json格式数据, user  ==> " + user);
        return "pojoParamForJson: " + user;
    }

    @RequestMapping("/listPojoParamForJson")
    @ResponseBody
    public String listPojoParamForJson(@RequestBody List<User> users){

            /*
            POST请求：
                curl 'localhost:8080/user/listPojoParamForJson' \
                -X POST \
                -H "Content-Type:application/json" \
                -d '[
                        {"name":"ming", "age":"13", "address":{"province":"zhejiang","city":"hangzhou"}},
                        {"name":"wang", "age":"14", "address":{"province":"guangdong","city":"guangzhou"}}
                    ]'
            */

        System.out.println("pojo参数接受json格式数据, user  ==> " + users);
        return "listPojoParamForJson: " + users;
    }


    /*
        日期参数
        使用 @DateTimeFormat 注解设置日期类型数据格式，默认格式yyyy/MM/dd
        因为 java.util.date 逐步被弃用，后续推荐使用 java.time下的 LocalDate 和 LocalDateTime
    */
    @RequestMapping("/dateParam")
    @ResponseBody
    public String dateParam(Date date0,
                            @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date1,
                            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime){
        /*
            支持GET请求：
                curl 'localhost:8080/user/dateParam?date0=2023/12/01&date1=2023-12-02&dateTime=2023-12-01%2015:15:15'
                空格需要转义为 %20
            POST请求：
                curl 'localhost:8080/user/dateParam' \
                    -X POST \
                    -H "Content-Type:application/x-www-form-urlencoded" \
                    -d 'date0=2023%2F12%2F01&date1=2023-12-02&dateTime=2023-12-01%2015%3A15%3A15'
         */

        System.out.println("参数传递(默认格式yyyy/MM/dd) date0 ==> "+date0);
        System.out.println("参数传递                    date1(yyyy-MM-dd) ==> " + date1);
        System.out.println("参数传递                    date2(yyyy/MM/dd HH:mm:ss) ==> " + dateTime);
        return "dateParam: " + Arrays.asList(date0, date1, dateTime);
    }
}
