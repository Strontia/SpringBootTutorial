package com.ygsoft.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @RestController: Controller和ResponseBody的合体
 */
//@Controller
//@ResponseBody

@RestController
public class HelloController {

    /**
     * @RequestMapping: 表示映射请求，映射哪个请求呢？希望浏览器给我们发送hello请求
     * @ResponseBody: 由于方法要以String的形式返回给浏览器，因此需要加上注解。写在类上代表这个类中的每一个方法都是直接写给浏览器的，而不是跳转一个页面。
     * @return
     */
    @RequestMapping("/hello")
    public String handle01(){
        return "Hello, Spring Boot 2!";
    }

}
