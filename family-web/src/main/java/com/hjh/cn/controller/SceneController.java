package com.hjh.cn.controller;

import com.hjh.cn.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 89lovelc on 2017/5/20.
 */
@RestController
public class SceneController {


    @Autowired
    private SceneService sceneService;

    /**
     * 进行情景模式的操作
     * @param id
     * @return
     */
    @RequestMapping("/operater/open/")
    @ResponseBody
    public String openOne(String id){

        boolean tj = sceneService.operate(id);


       return "success";
    }

}
