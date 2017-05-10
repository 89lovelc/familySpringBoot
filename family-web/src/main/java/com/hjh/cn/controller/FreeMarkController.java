package com.hjh.cn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 进行直接跳转页面的工作
 * Created by 89lovelc on 2017/5/7.
 */
@RestController
public class FreeMarkController {
    @RequestMapping(path = "/fmr/**",method = RequestMethod.GET)
    public ModelAndView freeMarkRedirect(HttpServletRequest request){
        String path = request.getRequestURI();
        int count = path.indexOf("fmr");
        path = path.substring(count + 3);
        return new ModelAndView(path);
    }
}
