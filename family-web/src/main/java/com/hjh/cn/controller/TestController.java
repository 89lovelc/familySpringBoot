package com.hjh.cn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 89lovelc on 2017/4/9.
 */
@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        System.out.println("test");
        return "test";
    }


}
