package com.hjh.cn.controller;

import com.hjh.cn.domain.UserPo;
import com.hjh.cn.po.Message;
import com.hjh.cn.service.UserService;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by 89lovelc on 2017/5/5.
 */
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView loginFtl(){
        return new ModelAndView("login");
    }

    @RequestMapping("user/login")
    public ModelAndView login(String userName , String password , HttpServletRequest request){
        UserPo user = userService.validUser(userName,password);
       if (user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return new ModelAndView("index");
       }else{
            HashMap<String, String > map = new HashMap<>();
            map.put("message","erro");
            ModelAndView modelAndView = new ModelAndView("login",map);
            return modelAndView;
       }
    }

}
