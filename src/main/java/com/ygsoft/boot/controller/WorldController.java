package com.ygsoft.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {

@RequestMapping("/world")
    public String World(){
        return "World 泥耗!";
    }

}
