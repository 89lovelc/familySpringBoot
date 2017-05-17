package com.hjh.cn.controller;

import com.hjh.cn.domain.UserPo;
import com.hjh.cn.po.Message;
import com.hjh.cn.service.UserService;
import org.apache.http.protocol.HTTP;
import org.hibernate.Session;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;

/**
 * Created by 89lovelc on 2017/5/5.
 */
@RestController
@RequestMapping("/")
public class LoginAndUserController {

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


    @RequestMapping("user/userData")
    @ResponseBody
    public UserPo userData(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserPo user =(UserPo) session.getAttribute("user");
        return user;
    }


    @RequestMapping("user/saveProfile")
    @ResponseBody
    public String saveProfile(@RequestBody UserPo  userPo, HttpServletRequest request){
        UserPo user = userService.saveProfile(userPo);
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        return "success";
    }

    @RequestMapping("/user/changePwd")
    @ResponseBody
    public String changePwd(@RequestBody String pwd, HttpServletRequest request){
        HttpSession session = request.getSession();
        pwd = pwd.replace("\"","");
        UserPo user =(UserPo) session.getAttribute("user");
        boolean tj = userService.changePwd(user.getUserId(),pwd);
        return "success";
    }


//    @RequestMapping("/user/upload/avatar")
//    public String uploadAvatar(@RequestParam("myFile") MultipartFile file, HttpServletRequest request){
//
//      String path = request.getSession().getServletContext().getRealPath("img");
//        String path = "E://";
//        String fileName = file.getOriginalFilename();
//        System.out.println(path);
//        File targetFile = new File(path, fileName);
//        if(!targetFile.exists()){
//            targetFile.mkdirs();
//        }
//        //保存
//        try {
//            file.transferTo(targetFile);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "/fmr/person/profile-edit";
//    }

}
